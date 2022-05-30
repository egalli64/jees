package com.example.jees.s04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s04/redirect")
public class Redirect extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Redirect.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("redirect to Apache Tomcat");
        response.sendRedirect("https://tomcat.apache.org/");
    }
}
