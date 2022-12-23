/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s08;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s08/login")
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
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
