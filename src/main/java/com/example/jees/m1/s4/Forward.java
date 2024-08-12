/*
 * Introduction to Jakarta Enterprise Edition - Servlet
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
 * A forwarding servlet
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s4/forward")
public class Forward extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Forward.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        if (to == null) {
            log.warn("Null destination!");
            to = "";
        } else {
            log.traceEntry("called for {}", to);
        }

        // destination could be set here to a servlet, a jsp, a plain HTML page
        String destination = switch (to) {
        case "servlet" -> "/m1/s2/timer";
        case "jsp" -> "/m1/s2/timer.jsp";
        default -> "/index.html";
        };

        // classic alternative to switch assignment
//        String destination;
//        if (to.equals("servlet")) {
//            destination = "/m1/s2/timer";
//        } else if (to.equals("jsp")) {
//            destination = "/m1/s2/timer.jsp";
//        } else {
//            destination = "/index.html";
//        }

        log.trace("Forwarding to {}", destination);
        request.getRequestDispatcher(destination).forward(request, response);

        // split the forwarding in two steps, for improved readability
//        var dispatcher = request.getRequestDispatcher(destination);
//        dispatcher.forward(request, response);
    }
}
