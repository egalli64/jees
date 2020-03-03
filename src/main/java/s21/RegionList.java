package s21;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/s21/regions")
public class RegionList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DataSource ds;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            Context envContext = (Context) (new InitialContext().lookup("java:/comp/env"));
            ds = (DataSource) envContext.lookup("jdbc/me");
        } catch (NamingException ne) {
            throw new ServletException("Can't resolve JDBC resource", ne);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select REGION_ID, REGION_NAME from regions")) {
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
