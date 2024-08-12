/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s3;

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
 * A servlet looking for a repeated parameter
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s3/multipleParamReader")
public class MultipleParamReader extends HttpServlet {
    private static final Logger log = LogManager.getLogger(MultipleParamReader.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get a parameter, possibly more values expected
        String[] colors = request.getParameterValues("color");
        if (colors == null) {
            log.warn("No colors passed as parameter!");
        } else {
            log.trace(String.format("%s as colors", Arrays.toString(colors)));
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("The list of passed colors is " + Arrays.toString(colors));
        }
    }
}
