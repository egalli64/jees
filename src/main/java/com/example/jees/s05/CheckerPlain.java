/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s05;

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
@WebServlet("/s05/checkerPlain")
public class CheckerPlain extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CheckerPlain.class);
    private static final CheckerService service = CheckerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. extract parameters from the request
        String user = request.getParameter("user");
        log.trace("Parameter user is '{}'", user);

        // 2. access the business layer through the service
        Set<Character> set = service.check(user);

        // 3. prepare the response, setting its type and encoding
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
