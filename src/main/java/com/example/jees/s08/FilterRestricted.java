/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s08;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = { "/s08/restricted/*" })
public class FilterRestricted implements Filter {
    private static final Logger log = LogManager.getLogger(FilterRestricted.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            // put a denial message in the response and return
            response.setContentType("text/plain");
            response.setCharacterEncoding("utf-8");

            response.getWriter().println("Only HTTP requests accepted!");
            return;
        }

        HttpSession session = ((HttpServletRequest) request).getSession();
        Boolean logged = (Boolean) session.getAttribute("logged");

        log.trace("Access to restricted area is " + logged);
        if (logged == null || !logged) {
            // new request generated, not implicitly to the same web app
            ((HttpServletResponse) response).sendRedirect("/jees/s08/index.jsp");

            // use this to keep the original request
//                request.getRequestDispatcher("/s08/index.jsp").forward(request, response);

            // in both case, remember to end here the filtering
            return;
        }

        chain.doFilter(request, response);

        // put your filter-out behavior here
        log.trace("Exiting restricted area");

        // here, login is valid just for one access!
        session.setAttribute("logged", false);
    }
}
