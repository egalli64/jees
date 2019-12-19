package s15;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s15/forward")
public class Forwarder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        
        String destination;
        switch (to) {
        case "home":
            System.out.println("forward back home");
            destination = "/";
            break;
        case "timer":
            System.out.println("forward to timer servlet");
            destination = "/s07/timer";
            break;
        case "counter":
            System.out.println("forward to counter JSP");
            destination = "/s10/counter.jsp";
            break;
        default:
            System.out.println("redirect to Apache Tomcat");
            response.sendRedirect("https://tomcat.apache.org/");
            return;
        }

        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
