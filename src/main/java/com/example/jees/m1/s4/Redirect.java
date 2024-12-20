/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s4;

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
@WebServlet("/m1/s4/redirect")
public class Redirect extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Redirect.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String destination = "../s2/timer";

        log.traceEntry("Redirecting to {}", destination);
        response.sendRedirect(destination);
    }
}
