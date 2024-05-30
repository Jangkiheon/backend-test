package kr.co.polycube.backendtest.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpecialCharacterFilter implements javax.servlet.Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

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
