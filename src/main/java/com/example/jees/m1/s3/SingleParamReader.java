/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s3;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet looking for a single parameter
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s3/singleParamReader")
public class SingleParamReader extends HttpServlet {
    private static final Logger log = LogManager.getLogger(SingleParamReader.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get a parameter, single value expected
        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            log.warn("No name passed as parameter!");
        } else {
            log.trace("Name: " + name);
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("The passed name is " + name);
        }
    }
}
