/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s02;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A HTML-generating servlet (not commonly used)
 */
@SuppressWarnings("serial")
@WebServlet("/s02/timer")
public class Timer extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Timer.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        // 1. prepare the response, setting its type and encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        // 2. fill the response with static data
        try (PrintWriter out = response.getWriter()) {
            out.println("""
                    <!DOCTYPE html>
                    <html>
                    <head>
                        <meta charset="utf-8">
                        <link rel="icon" href="data:;base64,=">
                        <link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
                        <title>Hello JSP</title>
                    </head>
                    <body>
                        <nav>
                            <a href="/jees/index.html">Home</a>
                        </nav>
                        """);

            // 3. put some dynamically generated data in the response
            out.println("<h1>" + LocalTime.now() + "</h1>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}
