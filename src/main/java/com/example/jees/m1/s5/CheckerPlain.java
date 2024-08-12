/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A simple servlet that uses a service and then generates a response on its own
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s5/checkerPlain")
public class CheckerPlain extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CheckerPlain.class);

    // reference to the checker service singleton
    private static final CheckerService service = CheckerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. extract parameters from the request
        String user = request.getParameter("user");
        if (user == null) {
            log.info("Parameter user is null!");
            user = "";
        } else {
            log.debug("Parameter user is '{}'", user);
        }

        // 2. delegate the service for the actual business logic
        Set<Character> set = service.check(user);

        // 3. prepare the response, setting up type and encoding
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // 4. fill the response with data
        try (PrintWriter writer = response.getWriter()) {
            for (Character c : set) {
                writer.print(c);
            }
        }
    }
}
