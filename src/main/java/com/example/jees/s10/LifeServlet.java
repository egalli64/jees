package com.example.jees.s10;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/s10/life")
public class LifeServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(LifeServlet.class);

    public LifeServlet() {
        log.traceEntry();
    }

    @Override
    public void init() throws ServletException {
        log.traceEntry();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        request.getRequestDispatcher("/index.html").forward(request, response);
    }

    @Override
    public void destroy() {
        log.traceEntry();
    }
}
