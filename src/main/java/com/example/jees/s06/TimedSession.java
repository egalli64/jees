/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s06;

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
 * Session attribute set/get + timeout
 */
@SuppressWarnings("serial")
@WebServlet("/s06/timed")
public class TimedSession extends HttpServlet {
    private static final Logger log = LogManager.getLogger(TimedSession.class);
    private static final int SPECIFIC_TIMEOUT = 10;
    private static final String USER_INFO = "info";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Application default timeout could be configured in web.xml
        int maxInactive = session.getMaxInactiveInterval();
        log.info("Current session max inactive interval is {}", maxInactive);

        String stored = (String) session.getAttribute(USER_INFO);
        log.info("Stored info is {}", stored);
        // It there is no user info in session, put what the user pass
        if (stored == null) {
            // the session is going to auto-expire after the specified time (in seconds)
            session.setMaxInactiveInterval(SPECIFIC_TIMEOUT);

            String info = request.getParameter(USER_INFO);
            log.traceEntry("User info is {}", info);
            session.setAttribute(USER_INFO, info == null || info.isBlank() ? "unknown" : info);
        }

        request.getRequestDispatcher("timedInfo.jsp").forward(request, response);
    }
}
