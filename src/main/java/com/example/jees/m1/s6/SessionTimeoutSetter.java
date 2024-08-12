/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s6;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Session attribute reader (with specific timeout)
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s6/timeout")
public class SessionTimeoutSetter extends HttpServlet {
    private static final Logger log = LogManager.getLogger(SessionTimeoutSetter.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int current = session.getMaxInactiveInterval();
        log.info("Current session max inactive interval is set to {} seconds", current);

        String param = request.getParameter("sec");
        if (param == null || param.isBlank()) {
            log.info("The user specified no timeout, keeping the current one");
            request.setAttribute("timeout", current);
        } else {
            int timeout = 0;
            try {
                timeout = Integer.parseInt(param);
                log.info("Setting max inactive interval to {} seconds", timeout);
            } catch (NumberFormatException ex) {
                log.error("The session will expire at the end of the current request!", ex);
            }
            // the session is going to auto-expire after the specified time (in seconds)
            session.setMaxInactiveInterval(timeout);
            request.setAttribute("timeout", timeout);
        }

        request.getRequestDispatcher("timeout.jsp").forward(request, response);
    }
}
