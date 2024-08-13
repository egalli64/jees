/*
 * Introduction to Jakarta Enterprise Edition - Servlet & JSP
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m2.s4;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.jees.bean.Document;
import com.example.jees.bean.User;

/**
 * Generate attributes to be put in the view by JSP Expression Language
 */
@SuppressWarnings("serial")
@WebServlet("/m2/s4/el")
public class ExpressionLanguage extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ExpressionLanguage.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document doc = new Document("Hello", new User("Tom", 42));
        request.setAttribute("doc", doc);
        log.trace("Bean stored as request attribute: {}", doc);

        List<String> names = List.of("Tom", "Bob", "Kim");
        log.trace(names);
        request.setAttribute("names", names);
        log.trace("List stored as request attribute: {}", names);

        request.getRequestDispatcher("el.jsp").forward(request, response);
    }
}
