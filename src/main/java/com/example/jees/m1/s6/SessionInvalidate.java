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
 * Session invalidate
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s6/checkout")
public class SessionInvalidate extends HttpServlet {
    private static final Logger log = LogManager.getLogger(SessionInvalidate.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        HttpSession session = request.getSession();
        session.invalidate();

        request.getRequestDispatcher("attr.jsp").forward(request, response);
    }
}
