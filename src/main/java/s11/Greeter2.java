package s11;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s11/greeter2")
public class Greeter2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean invalidate = false;

        HttpSession session = request.getSession();
        Duration duration;
        LocalTime start = (LocalTime) session.getAttribute("start");
        if (start != null) {
            duration = Duration.between(start, LocalTime.now());
        } else {
            duration = Duration.ZERO;
            session.setAttribute("start", LocalTime.now());
        }

        request.setAttribute("duration", duration);

        if (request.getParameter("done") != null) {
            invalidate = true;
        } else {
            request.setAttribute("message", "Welcome back");
        }

        RequestDispatcher rd = request.getRequestDispatcher( //
                invalidate ? "/s11/invalidate.jsp" : "/s11/greeter.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
