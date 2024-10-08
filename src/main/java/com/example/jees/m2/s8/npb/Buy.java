/*
 * Introduction to Jakarta Enterprise Edition - Servlet & JSP
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m2.s8.npb;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Buy servlet
 */
@SuppressWarnings("serial")
@WebServlet("/m2/s8/npb/buy")
public class Buy extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Buy.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        Map<String, Album> orders = (Map<String, Album>) session.getAttribute("orders");
        if (orders != null) {
            request.setAttribute("albums", orders.values());
        }

        request.getRequestDispatcher("done.jsp").forward(request, response);
    }
}
