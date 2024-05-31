package kr.co.polycube.backendtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Exception 클래스 컨트롤러에서 발생한 예외를 처리.
 * IllegalArgumentException이 발생한 경우 해당 예외를 처리 및 응답.
 */
@RestControllerAdvice
public class Exception {

    /**
     * IllegalArgumentException 예외를 처리하는 핸들러.
     * 해당 예외가 발생한 경우 HttpStatus를 BAD_REQUEST로 설정,
     * 예외 메시지를 포함한 응답을 반환.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("reason", ex.getMessage());
        return errorResponse;
    }
}
