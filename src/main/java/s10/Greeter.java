package s10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s10/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Greeter.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        String user = request.getParameter("user");

        HttpSession session = request.getSession();
        String prevUser = (String) session.getAttribute("user");
        if (prevUser == null) {
            prevUser = "";
        }

        if (user == null) {
            session.invalidate();
        } else if (user.isBlank()) {
            session.setAttribute("user", "unknown");
        } else {
            session.setAttribute("user", user);
        }

        request.setAttribute("previous", prevUser);
        request.getRequestDispatcher("greeter.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
