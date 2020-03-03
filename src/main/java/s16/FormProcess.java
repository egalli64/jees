package s16;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s16/process")
public class FormProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name != null && !name.isEmpty()) {
            request.setAttribute("name", name);
        } else {
            request.setAttribute("name", "missing");
        }

        String[] colors = request.getParameterValues("color");
        if (colors != null) {
            request.setAttribute("colors", Arrays.asList(colors));
        } else {
            request.setAttribute("colors", "missing");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/s16/feedback.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
