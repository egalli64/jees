/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s09;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Listen on web app events, add an attribute to the servlet context at startup
 */
@WebListener
public class MyContextListener implements ServletContextListener {
    private static final Logger log = LogManager.getLogger(MyContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.traceEntry();

        // some setup work on the servlet context
        ServletContext sc = sce.getServletContext();

        // add a custom attribute to the servlet context
        sc.setAttribute("start", LocalTime.now());

        // Attributes, accessible by enumeration
//        for (var e = sc.getAttributeNames(); e.hasMoreElements();) {
//            String name = e.nextElement();
//            System.out.print(name);
//            System.out.print(name.equals("start") ? String.format("(%s)", sc.getAttribute(name)) : " ");
//        }

        // Initialization parameter (see web.xml), accessible by enumeration
//        for (var e = sc.getInitParameterNames(); e.hasMoreElements();) {
//             uncomment next lines to access them
//            String name = e.nextElement();
//            System.out.printf("%s %s%n", name, sc.getInitParameter(name));
//        }

        // uncomment the next line to set the web app default session timeout programmatically
//         sc.setSessionTimeout(1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.traceEntry();
    }
}
