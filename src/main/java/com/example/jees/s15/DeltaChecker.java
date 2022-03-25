package com.example.jees.s15;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/s15/delta")
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
