package com.example.jees.s02;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s02/timer")
public class Timer extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Timer.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head><meta charset=\"utf-8\">");
            writer.println("<link rel=\"icon\" href=\"data:;base64,=\">");
            writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/jees/css/simple.css\">");
            writer.println("<title>Hello Servlet</title></head>");
            writer.println("<body>");
            writer.println("<h1>" + LocalTime.now() + "</h1>");
            writer.println("<a href=\"..\">back home</a>");
            writer.println("</body></html>");
        }
    }
}
