package s21;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s21/choice")
public class Choice extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String[] colors = request.getParameterValues("colors");
//        request.setAttribute("values", colors);

        request.getRequestDispatcher("/s21/feedback.jsp").forward(request, response);
    }
}
