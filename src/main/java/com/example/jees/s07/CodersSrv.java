/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s07;

import java.io.IOException;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s07/coders")
public class CodersSrv extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CodersSrv.class);

    @Resource(name = "jdbc/hron")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");
        try (CoderDao dao = new CoderDao(ds)) {
            request.setAttribute("coders", dao.getAll());
            request.getRequestDispatcher("coders.jsp").forward(request, response);
        }
    }
}
