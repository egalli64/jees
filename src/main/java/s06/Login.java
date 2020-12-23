package s06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s06/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        String url;
        if (user == null || user.isBlank() || password == null || password.isBlank()) {
            url = "unknown.jsp";
        } else {
            url = "logged.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
