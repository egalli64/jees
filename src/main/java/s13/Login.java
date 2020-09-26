package s13;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s13/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        request.setAttribute("user", user);

        String url;
        if (user == null || password == null || user.isBlank() || password.isBlank()) {
            url = "/s13/unknown.jsp";
        } else {
            url = "/s13/logged.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
