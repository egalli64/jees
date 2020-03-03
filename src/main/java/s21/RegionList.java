package s21;

import java.io.IOException;

import javax.annotation.Resource;
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

    @Resource(name = "jdbc/me")
    private DataSource ds;

    @Override
    public void init() throws ServletException {
        super.init();

        // resource injection not working in Tomcat latest versions (?!)
        if (ds == null) {
            System.err.println("*** Resource-not-injected Tomcat patch ***");
            try {
                Context envContext = (Context) (new InitialContext().lookup("java:/comp/env"));
                ds = (DataSource) envContext.lookup("jdbc/me");
            } catch (NamingException ne) {
                throw new ServletException("Can't resolve JDBC resource", ne);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (DaoRegion dao = new DaoRegion(ds)) {
            request.setAttribute("regions", dao.getAll());
            request.getRequestDispatcher("/s21/regions2.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
