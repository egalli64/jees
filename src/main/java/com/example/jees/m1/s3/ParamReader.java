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
 * TODO: complete the servlet code
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s3/paramReader")
public class ParamReader extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ParamReader.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        // TODO: get a parameter, single value expected
        String name = "TO BE DONE";

        // TODO: get a parameter, possibly more values expected
        String[] colors = new String[] { "TO BE DONE" };

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println(name + " -> " + Arrays.toString(colors));
        }
    }
}
