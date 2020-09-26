package s12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s12/send")
public class Router extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(Router.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        LOG.debug("called for " + to);

        String destination;
        switch (to) {
        case "home":
            System.out.println("forward back home");
            destination = "/";
            break;
        case "timer":
            System.out.println("forward to timer servlet");
            destination = "/s09/timer";
            break;
        case "checker":
            System.out.println("forward to checker servlet");
            destination = "/s10/checker";
            break;
        default:
            System.out.println("redirect to Apache Tomcat");
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
