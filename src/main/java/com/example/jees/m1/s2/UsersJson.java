/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.jees.bean.User;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A JSON-generating servlet (quite common nowadays)
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s2/users")
public class UsersJson extends HttpServlet {
    private static final Logger log = LogManager.getLogger(UsersJson.class);
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        // 1. data generation - usually delegated to the business layer
        List<User> users = List.of(new User("Tom", 12), new User("Bob", 42));

        // 2. prepare the response, setting its type and encoding
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            // 3. put dynamically generated data in the response
            writer.append(gson.toJson(users));
        }
    }
}
