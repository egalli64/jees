package s02;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dd.User;

@WebServlet("/s02/users")
public class UsersJson extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Gson GSON = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = Arrays.asList(new User("Tom", 12), new User("Bob", 42));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(GSON.toJson(users));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
