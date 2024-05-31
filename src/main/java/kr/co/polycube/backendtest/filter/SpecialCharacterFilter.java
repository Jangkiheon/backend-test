package kr.co.polycube.backendtest.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SpecialCharacterFilter 클래스 요청 쿼리 문자열에 유효하지 않은 특수 문자가 있는지 확인,
 * 유효하지 않은 문자가 있을 경우 400 Bad Request 응답을 반환.
 */
public class SpecialCharacterFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 필터링 로직 수행. 쿼리 문자열에 유효하지 않은 특수 문자가 포함되어 있는지 확인,
     * 포함되어 있으면 400 Bad Request 응답을 반환
     *
     * @param request  서블릿 요청
     * @param response 서블릿 응답
     * @param chain    필터 체인
     * @throws IOException      I/O 예외
     * @throws ServletException 서블릿 예외
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String queryString = httpRequest.getQueryString();
        if (queryString != null && queryString.matches(".*[\\\\[\\\\]{}|\\\\\\\\^`<>].*")) {
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid characters in query string");
            return;
        }
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {

    }
}
