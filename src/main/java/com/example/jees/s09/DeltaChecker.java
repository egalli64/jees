/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s09;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/s09/delta")
public class DeltaChecker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalTime start = (LocalTime) getServletContext().getAttribute("start");
        long delta = start.until(LocalTime.now(), ChronoUnit.SECONDS);

        request.setAttribute("delta", delta);
        request.getRequestDispatcher("delta.jsp").forward(request, response);
    }
}
