package com.example.jees.s06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s06/login")
public class Login extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Login.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        log.trace("Parameter user is {}", user);

        HttpSession session = request.getSession();
        session.setAttribute("user", user == null || user.isBlank() ? "unknown" : user);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
