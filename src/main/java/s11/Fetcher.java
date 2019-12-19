package s11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dd.User;

@WebServlet("/s11/fetch")
public class Fetcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null) {
            name = "Tom";
        }
        Integer id;
        try {
            String param = request.getParameter("id");
            if (param == null) {
                id = 0;
            } else {
                id = Integer.valueOf(param);
            }
        } catch (Exception e) {
            id = 1;
        }

        request.setAttribute("user", new User(name, id));

        RequestDispatcher rd = request.getRequestDispatcher("/s11/fetch.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
