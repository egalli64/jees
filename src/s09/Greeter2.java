package s09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class More
 */
@WebServlet("/s09/greeter2")
public class Greeter2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean invalidate = false;

        HttpSession session = request.getSession();
        if (session.isNew()) {
            request.setAttribute("message", "Welcome");
        } else {
            if (request.getParameter("done") != null) {
                invalidate = true;
            } else {
                request.setAttribute("message", "Welcome back");
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher( //
                invalidate ? "/s09/invalidate.jsp" : "/s09/greeter.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
