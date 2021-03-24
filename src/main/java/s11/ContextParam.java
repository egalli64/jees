package s11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s11/contextParam")
public class ContextParam extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ContextParam.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        String admin = this.getServletContext().getInitParameter("admin");
        request.setAttribute("reversedAdmin", new StringBuilder(admin).reverse().toString());
        request.getRequestDispatcher("contextParam.jsp").forward(request, response);
    }
}
