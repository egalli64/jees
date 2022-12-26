/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Listen on web app events, add an attribute to the servlet context at startup
 */
@WebListener
public class CheckerContextListener implements ServletContextListener {
    private static final Logger log = LogManager.getLogger(CheckerContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.traceEntry();
        sce.getServletContext().setAttribute("checker", new CheckerService());
    }
}
