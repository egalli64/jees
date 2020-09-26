package s11;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s11/process")
public class FormProcessor extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(FormProcessor.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        LOG.debug("called for " + name);

        if (name == null || name.isBlank()) {
            LOG.warn("No name passed as parameter!");
        } else {
            LOG.info("name is " + name);
        }

        String[] colors = request.getParameterValues("color");
        if (colors == null) {
            LOG.warn("No color passed as parameter!");
        } else {
            LOG.info("color(s) passed: " + Arrays.asList(colors));
        }

        request.getRequestDispatcher("feedback.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
