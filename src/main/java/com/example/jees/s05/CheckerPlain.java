package com.example.jees.s05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s05/checkerPlain")
public class CheckerPlain extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CheckerPlain.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        log.trace("User is {" + user + "}");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        if (user != null) {
            Set<Character> set = new TreeSet<>();

            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }

            try (PrintWriter writer = response.getWriter()) {
                for (Character c : set) {
                    writer.print(c);
                }
            }
        }
    }
}
