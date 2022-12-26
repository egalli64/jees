/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s10;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A simple servlet that uses a service and then pass the control to a JSP
 */
@SuppressWarnings("serial")
@WebServlet("/s10/checker")
public class CheckerServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CheckerServlet.class);
    /** managed by the container */
    private static CheckerService service;

    /**
     * Initialize the servlet with the service provided by the container
     */
    @Override
    public void init() throws ServletException {
        service = (CheckerService) getServletContext().getAttribute("checker");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        log.traceEntry(user);

        Set<Character> set = service.check(user);
        request.setAttribute("set", set);
        request.getRequestDispatcher("checker.jsp").forward(request, response);
    }
}
