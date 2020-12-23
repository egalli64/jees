package s05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s05/send")
public class Router extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Router.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        log.debug("called for " + to);

        String destination;
        switch (to) {
        case "home":
            log.trace("forward back home");
            destination = "/";
            break;
        case "timer":
            log.trace("forward to timer servlet");
            destination = "/s02/timer";
            break;
        case "checker":
            log.trace("forward to checker servlet");
            destination = "/s03/checker";
            break;
        default:
            log.trace("redirect to Apache Tomcat");
            response.sendRedirect("https://tomcat.apache.org/");
            return;
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
