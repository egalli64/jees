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

@SuppressWarnings("serial")
@WebServlet("/s09/checkAdminBirthday")
public class CheckAdminBirthday extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CheckAdminBirthday.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        LocalDate birthday = LocalDate.parse(getServletContext().getInitParameter("birthday"));
        LocalDate today = LocalDate.now();
        request.setAttribute("birthday", birthday.getDayOfMonth() == today.getDayOfMonth() && birthday.getMonth() == today.getMonth());
        request.getRequestDispatcher("adminBirthday.jsp").forward(request, response);
    }
}
