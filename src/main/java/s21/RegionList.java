package s21;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s21/regions")
public class RegionList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/me?serverTimezone=Europe/Rome";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(URL, "me", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select REGION_ID, REGION_NAME from regions");

            List<Region> regions = new ArrayList<>();
            while (rs.next()) {
                regions.add(new Region(rs.getLong(1), rs.getString(2)));
            }

            request.setAttribute("regions", regions);
        } catch (SQLException se) {
            se.printStackTrace();
            throw new IllegalStateException("Database issue: " + se.getMessage());
        }

        request.getRequestDispatcher("/s21/regions2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
