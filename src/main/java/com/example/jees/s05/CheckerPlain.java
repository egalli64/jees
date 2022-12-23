/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        log.trace("Parameter user is '{}'", user);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        if (user != null) {
            Set<Character> set = new TreeSet<>();

            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
            log.debug("Local set is {}", set);

            try (PrintWriter writer = response.getWriter()) {
                for (Character c : set) {
                    writer.print(c);
                }
            }
        }
    }
}
