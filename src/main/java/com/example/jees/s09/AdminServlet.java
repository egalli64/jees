/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s09;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Access to servlet context parameters
 * <p>
 * They are set in web.xml configuration file
 */
@SuppressWarnings("serial")
@WebServlet("/s09/admin")
public class AdminServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(AdminServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        LocalDate check = LocalDate.parse(getServletContext().getInitParameter("birthday"));
        LocalDate today = LocalDate.now();
        request.setAttribute("birthday",
                check.getDayOfMonth() == today.getDayOfMonth() && check.getMonth() == today.getMonth());
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
