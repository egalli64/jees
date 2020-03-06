package s23;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s23/regions")
public class RegionList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(RegionList.class);

    @Resource(name = "jdbc/me")
    private DataSource ds;

    @Override
    public void init() throws ServletException {
        super.init();

        // resource injection not working in Tomcat latest versions (?!)
        if (ds == null) {
            logger.info("Resource-not-injected Tomcat patch");
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
        logger.trace("called");
        try (DaoRegion dao = new DaoRegion(ds)) {
            request.setAttribute("regions", dao.getAll());
            request.getRequestDispatcher("/s23/regions2.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
