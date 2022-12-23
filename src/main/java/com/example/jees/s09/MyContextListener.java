/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s09;

import java.time.LocalTime;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class MyContextListener implements ServletContextListener {
    private static final Logger log = LogManager.getLogger(MyContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        log.traceEntry();
        sce.getServletContext().setAttribute("start", LocalTime.now());
    }
}
