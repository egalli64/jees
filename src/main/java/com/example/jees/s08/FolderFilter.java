/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s08;

import java.io.IOException;

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
 * Filter applied on all the resources in the specified folder
 */
@WebFilter(urlPatterns = { "/s08/*" })
public class FolderFilter implements Filter {
    private static final Logger log = LogManager.getLogger(FolderFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            // quietly reject non-web requests
            log.error("Only HttpServletRequest are accepted");
            return;
        }

        // 1. filter in
        HttpServletRequest hsr = (HttpServletRequest) request;
        log.trace("Requesting {}", hsr.getRequestURL().toString());

        // 2. pass the control to the next filter or actual resource
        chain.doFilter(request, response);

        // 3. filter out
//        log.trace("filter out " + url.toString());
    }
}
