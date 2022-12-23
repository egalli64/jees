/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s08;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "*.jsp" })
public class FilterAllJsp implements Filter {
    private static final Logger log = LogManager.getLogger(FilterAllJsp.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new IllegalStateException("Only HttpServletRequest are expected!");
        }

        HttpServletRequest hsr = (HttpServletRequest) request;
        String url = getUrl(hsr);
        log.trace("Enter " + url);

        chain.doFilter(request, response);

//        log.trace("Exit " + url);
    }

    private String getUrl(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String query = request.getQueryString();
        if (query != null) {
            url.append("?");
            url.append(query);
        }

        return url.toString();
    }
}
