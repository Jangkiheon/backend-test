package kr.co.polycube.backendtest.logging;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * LoggingAspect 클래스 컨트롤러 호출을 로깅하는 역할을 담당
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * 컨트롤러 호출 전에 로깅 작업을 수행.
     * @param joinPoint 컨트롤러 메서드 실행 지점
     */
    @Before("execution(* kr.co.polycube.backendtest.controller.*.*(..))")
    public void logRequest(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            if (request != null) {
                String userAgent = request.getHeader("User-Agent");
                String methodName = joinPoint.getSignature().getName();
                logger.info(String.format("Method: %s - User-Agent: %s", methodName, userAgent));
            }
        }
    }
}
