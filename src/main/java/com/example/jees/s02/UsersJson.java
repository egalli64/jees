/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s02;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.jees.bean.User;
import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet("/s02/users")
public class UsersJson extends HttpServlet {
    private static final Logger log = LogManager.getLogger(UsersJson.class);
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();
        List<User> users = List.of(new User("Tom", 12), new User("Bob", 42));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(gson.toJson(users));
    }
}
