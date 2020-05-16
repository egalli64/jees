package s11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s11/buyNull")
public class BuyNull extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(BuyNull.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Integer> orders = (List<Integer>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
        }

        String index = (String) request.getParameter("title");
        String value = (String) request.getParameter("quantity");
        LOG.debug(String.format("called for index=%s, value=%s", index, value));

        boolean done = true;
        if (index != null && value != null) {
            int pos = Integer.parseInt(index);

            Integer cur = orders.get(pos) + Integer.parseInt(value);
            orders.set(pos, cur);
            session.setAttribute("orders", orders);

            done = false;
        } else {
            session.invalidate();
        }

        int total = 0;
        for (Integer cur : orders) {
            total += cur;
        }
        request.setAttribute("total", total);

        RequestDispatcher rd = request.getRequestDispatcher( //
                done ? "/s11/buyNullDone.jsp" : "/s11/buyNull.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
