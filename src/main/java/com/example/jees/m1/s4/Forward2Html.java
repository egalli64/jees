/*
 * Introduction to Jakarta Enterprise Edition
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s4;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet forwarding to a HTML
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s4/forward2html")
public class Forward2Html extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Forward2Html.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String destination = "hello.html";

        log.traceEntry("Forwarding to {}", destination);

        request.getRequestDispatcher(destination).forward(request, response);

        // split in two steps, for improved readability
//        var dispatcher = request.getRequestDispatcher(destination);
//        dispatcher.forward(request, response);
    }
}
