/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s05;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A simple servlet that uses a service and then pass the control to a JSP
 */
@SuppressWarnings("serial")
@WebServlet("/s05/checker")
public class Checker extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Checker.class);
    private static final CheckerService service = CheckerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. extract parameters from the request
        String user = request.getParameter("user");
        if (user == null) {
            log.info("Parameter user is null!");
            user = "";
        } else {
            log.debug("Parameter user is '{}'", user);
        }

        // 2. access the business layer through the service
        Set<Character> set = service.check(user);

        // 3. put the data in request attributes
        request.setAttribute("set", set);

        // 4. pass the control to the associated JSP
        request.getRequestDispatcher("checker.jsp").forward(request, response);
        // same as above, in a more verbose way
//        var dispatcher = request.getRequestDispatcher("checker.jsp");
//        dispatcher.forward(request, response);
    }
}
