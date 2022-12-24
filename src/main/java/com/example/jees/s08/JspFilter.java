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

/**
 * Filter applied on all JSP in the web app, dispatched for request and forward
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "*.jsp" })
public class JspFilter implements Filter {
    private static final Logger log = LogManager.getLogger(JspFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.traceEntry();
        if (!(request instanceof HttpServletRequest)) {
            // reject non-web requests throwing an exception (costly)
            throw new IllegalStateException("Only HttpServletRequest are expected!");
        }

        HttpServletRequest hsr = (HttpServletRequest) request;
        log.debug("Requesting {}", getUrl(hsr));

        chain.doFilter(request, response);

//        log.trace("Exit " + url);
    }

    /**
     * Extract also parameters from the request
     * 
     * @param request as passed to the filter
     * @return URI for the HTTP command (as in GET form)
     */
    private String getUrl(HttpServletRequest request) {
        log.traceEntry();
        StringBuffer url = request.getRequestURL();
        String query = request.getQueryString();
        if (query != null) {
            url.append("?");
            url.append(query);
        }

        return url.toString();
    }
}
