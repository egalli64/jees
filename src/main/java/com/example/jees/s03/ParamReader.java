/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A parameter checking servlet
 */
@SuppressWarnings("serial")
@WebServlet("/s03/paramReader")
public class ParamReader extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ParamReader.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get a parameter, single value expected
        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            log.warn("No name passed as parameter!");
        } else {
            log.trace("Name: " + name);
        }

        // get a parameter, possibly more values expected
        String[] colors = request.getParameterValues("colors");
        if (colors == null) {
            log.warn("No colors passed as parameter!");
        } else {
            log.trace(String.format("%s as colors", Arrays.toString(colors)));
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println(name + " -> " + Arrays.toString(colors));
        }
    }
}
