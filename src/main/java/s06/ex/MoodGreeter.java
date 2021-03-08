package s06.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet("/s06/ex/greeter")
public class MoodGreeter extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MoodGreeter.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("Called");

        /*
         * TODO: ensure parameters user and mood have been passed with good values
         */

        request.getRequestDispatcher("mood.jsp").forward(request, response);
    }
}
