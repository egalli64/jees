/*
 * Introduction to Jakarta Enterprise Edition - Servlet & JSP
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m2.s8;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.jees.bean.User;

/**
 * Enrich the request with a few attributes then pass the control to a JSP
 */
@SuppressWarnings("serial")
@WebServlet("/m2/s8/loops")
public class Loops extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Loops.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        List<User> users = List.of(new User("Bob", 23), new User("Tom", 72), new User("Kim", 55));
        request.setAttribute("users", users);

        double[] values = new double[12];
        for (int i = 0; i < values.length; i++) {
            values[i] = ThreadLocalRandom.current().nextDouble();
        }
        request.setAttribute("values", values);

        String names = "Alma,Benno,Charles,Darla";
        request.setAttribute("names", names);

        request.getRequestDispatcher("loops.jsp").forward(request, response);
    }
}
