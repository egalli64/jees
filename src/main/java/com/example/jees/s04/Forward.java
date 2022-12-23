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

@SuppressWarnings("serial")
@WebServlet("/s04/forward")
public class Forward extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Forward.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        log.debug("called for " + to);

        String destination = switch (to) {
        case "servlet" -> {
            log.trace("forward to timer servlet");
            yield "/s02/timer";
        }
        case "jsp" -> {
            log.trace("forward to timer jsp");
            yield "/s02/timer.jsp";
        }
        default -> {
            log.trace("forward back home");
            yield "/";
        }
        };

        request.getRequestDispatcher(destination).forward(request, response);
    }
}
