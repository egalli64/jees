package s27;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s27.dao.Coder;
import s27.dao.CoderDao;

@WebServlet("/s27/coders")
public class HibRegions extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(HibRegions.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.trace("enter");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        List<Coder> coders = new CoderDao().getAll();
        LOG.debug(String.format("Found %d regions", coders.size()));

        try (PrintWriter writer = response.getWriter()) {
            writer.println(coders);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
