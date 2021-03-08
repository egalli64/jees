package s06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dd.Document;
import dd.User;

@SuppressWarnings("serial")
@WebServlet("/s06/fetch")
public class Fetcher extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(Fetcher.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        request.setAttribute("doc", new Document("JSP Cheatsheet", new User("Tom", 42)));
        request.getRequestDispatcher("fetch.jsp").forward(request, response);
    }
}
