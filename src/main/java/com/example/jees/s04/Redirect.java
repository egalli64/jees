/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s04;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A redirecting servlet
 */
@SuppressWarnings("serial")
@WebServlet("/s04/redirect")
public class Redirect extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Redirect.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry("redirect to Apache Tomcat");
        response.sendRedirect("https://tomcat.apache.org/");
    }
}
