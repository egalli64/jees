package s09;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/s09/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.isNew()) {
            request.setAttribute("message", "Welcome");
        } else {
            if (request.getParameter("done") != null) {
                session.invalidate();

                response.setContentType("text/html");
                response.setCharacterEncoding("utf-8");
                try (PrintWriter writer = response.getWriter()) {
                    writer.println("<!DOCTYPE html><html>");
                    writer.println("<head><meta charset=\"utf-8\">");
                    writer.println("<title>So long</title></head>");
                    writer.println("<body><h1>Goodbye</h1>");
                    writer.println("</body></html>");
                }
                return;
            } else {
                request.setAttribute("message", "Welcome back");
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/s09/greeter.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
