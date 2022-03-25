package com.example.jees.s16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s16/login")
public class Login extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Login.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        log.trace("user is " + user);

        // don't do that! sensitive data should be encrypted and stored in a safe place!
        boolean vouched = "superuser".equals(user) && "fido".equals(password);
        request.getSession().setAttribute("logged", vouched);
        request.getRequestDispatcher(vouched ? "index.jsp" : "login.html").forward(request, response);
    }
}
