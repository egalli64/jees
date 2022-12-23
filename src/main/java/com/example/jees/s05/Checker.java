/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s05;

import java.io.IOException;
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
@WebServlet("/s05/checker")
public class Checker extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Checker.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        log.debug("Parameter user is '{}'", user);

        Set<Character> set = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
        }
        request.setAttribute("set", set);
        log.debug("Attribute set is {}", set);

        request.getRequestDispatcher("checker.jsp").forward(request, response);
        // same as above, in a more verbose way
//        RequestDispatcher rd = request.getRequestDispatcher("checker.jsp");
//        rd.forward(request, response);
    }
}
