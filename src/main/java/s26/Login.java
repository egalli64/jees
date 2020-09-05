package s26;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s26/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        LOG.trace("user is " + user);

        // any password should be encrypted and stored in a safe place!
        if ("superuser".equals(user) && "fido".equals(password)) {
            request.getSession().setAttribute("logged", true);

            try (PrintWriter writer = response.getWriter()) {
                writer.println("Now you are logged in, " + user);
            }
        } else {
            request.getSession().setAttribute("logged", false);
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
