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
 * Session attribute getter/setter
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s6/attr")
public class SessionAttribute extends HttpServlet {
    private static final Logger log = LogManager.getLogger(SessionAttribute.class);
    private static final String INFO = "info";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String info = request.getParameter(INFO);
        if (info == null || info.isBlank()) {
            log.info("The user specified no info, keeping the current one");
        } else {
            log.info("Storing {} in session", info);
            session.setAttribute(INFO, info);
        }

        request.getRequestDispatcher("attr.jsp").forward(request, response);
    }
}
