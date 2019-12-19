package s19;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dd.User;

/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/s19/loops")
public class Loops extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User[] users = new User[] { new User("Alpha", 1), new User("Beta", 2), new User("Gamma", 3) };
        request.setAttribute("users", users);

        Double[] values = new Double[12]; // ...
        for (int i = 0; i < values.length; i++) {
            values[i] = Math.random();
        }
        request.setAttribute("values", values);

        String names = "bob,tom,bill";
        request.setAttribute("names", names);

        RequestDispatcher rd = request.getRequestDispatcher("/s19/loops.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
