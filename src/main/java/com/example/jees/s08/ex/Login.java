package com.example.jees.s08.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/s08/ex/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        String url;
        if (user == null || user.isBlank() || password == null || password.isBlank()) {
            url = "/s06/unknown.jsp";
        } else {
            // TODO: pass the JSP a boolean attribute for morning / afternoon
            url = "logged.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
