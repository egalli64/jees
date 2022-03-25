package com.example.jees.s02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jees.dao.User;
import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet("/s02/users")
public class UsersJson extends HttpServlet {
    private final Gson GSON = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = List.of(new User("Tom", 12), new User("Bob", 42));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(GSON.toJson(users));
    }
}
