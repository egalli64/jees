package s02;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet("/s02/timer")
public class Timer extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(Timer.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head><meta charset=\"utf-8\">");
            writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/jes/css/simple.css\">");
            writer.println("<title>Hello Servlet</title></head>");
            writer.println("<body>");
            writer.println("<h1>" + LocalTime.now() + "</h1>");
            writer.println("<a href=\"..\">back home</a>");
            writer.println("</body></html>");
        }
    }
}
