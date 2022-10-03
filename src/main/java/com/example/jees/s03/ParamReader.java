package com.example.jees.s03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s03/paramReader")
public class ParamReader extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ParamReader.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            log.warn("No name passed as parameter!");
        } else {
            log.trace("Name: " + name);
        }

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
