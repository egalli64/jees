package s03;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s03/checker")
public class Checker extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Checker.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        log.debug("User is {" + user + "}");

        Set<Character> set = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
        }
        request.setAttribute("set", set);

        RequestDispatcher rd = request.getRequestDispatcher("/s03/checker.jsp");
        rd.forward(request, response);

        // same as above, in a more compact way
        // request.getRequestDispatcher("checker.jsp").forward(request, response);
    }
}
