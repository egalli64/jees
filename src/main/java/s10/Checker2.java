package s10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s10/checker2")
public class Checker2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(Checker2.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        LOG.trace("called for user [" + user + "]");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        if (user != null) {
            Set<Character> set = new TreeSet<>();

            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }

            try (PrintWriter writer = response.getWriter()) {
                for (Character c : set) {
                    writer.print(c);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
