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

@WebFilter(urlPatterns = { "/s08/*" })
public class FilterAllFolder implements Filter {
    private static final Logger log = LogManager.getLogger(FilterAllFolder.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            log.error("Only HttpServletRequest are accepted");
            return;
        }

        // filter in
        HttpServletRequest hsr = (HttpServletRequest) request;
        String url = hsr.getRequestURL().toString();
        log.trace("filter in " + url);

        chain.doFilter(request, response);

        // filter out
//        log.trace("filter out " + url.toString());
    }
}
