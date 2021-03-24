package s04;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s04/process")
public class FormProcessor extends HttpServlet {
    private static final Logger log = LogManager.getLogger(FormProcessor.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        StringBuilder result = new StringBuilder();

        if (name == null || name.isBlank()) {
            log.warn("No name passed as parameter!");
        } else {
            log.trace("Name: " + name);
            result.append(String.format("[%s] as name ", name));
        }

        String[] colors = request.getParameterValues("color");
        if (colors == null) {
            log.warn("No color passed as parameter!");
        } else {
            result.append(String.format("%s as colors", Arrays.toString(colors)));
        }

        request.setAttribute("result", result.toString());
        request.getRequestDispatcher("feedback.jsp").forward(request, response);
    }
}
