/*
 * Introduction to Jakarta Enterprise Edition - Servlet and JSP
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.m1.s5;

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
 * <ul>
 * <li>A parameter "user" is expected
 * <li>An attribute "set" is generated
 * <li>The control is passed to the checker JSP in the same folder
 */
@SuppressWarnings("serial")
@WebServlet("/m1/s5/checker")
public class Checker extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Checker.class);

    // reference to the checker service singleton
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

        // 2. delegate the service for the actual business logic
        Set<Character> set = service.check(user);

        // 3. put the data coming from the service in a request attribute
        request.setAttribute("set", set);

        // 4. pass the control to the associated JSP
        // notice that using a relative URI, the /m1/s5 folder is assumed
        request.getRequestDispatcher("checker.jsp").forward(request, response);

        // same as above, in a more verbose way
//        var dispatcher = request.getRequestDispatcher("checker.jsp");
//        dispatcher.forward(request, response);
    }
}
