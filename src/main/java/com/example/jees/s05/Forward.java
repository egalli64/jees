package com.example.jees.s05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s05/send")
public class Forward extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Forward.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        log.debug("called for " + to);

        String destination = switch (to) {
        case "timer" -> {
            log.trace("forward to timer servlet");
            yield "/s02/timer";
        }
        case "checker" -> {
            log.trace("forward to checker servlet");
            yield "/s03/checker";
        }
        default -> {
            log.trace("forward back home");
            yield "/";
        }
        };

        request.getRequestDispatcher(destination).forward(request, response);
    }
}
