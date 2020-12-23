package s17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s17/buyNull")
public class BuyNull extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(BuyNull.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Integer> orders = (List<Integer>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
            session.setAttribute("orders", orders);
        }

        String index = request.getParameter("title");
        String value = request.getParameter("quantity");
        log.debug(String.format("called for index=%s, value=%s", index, value));

        boolean done = true;
        if (index != null && value != null) {
            int pos = Integer.parseInt(index);

            Integer cur = orders.get(pos) + Integer.parseInt(value);
            orders.set(pos, cur);
            done = false;
        } else {
            session.invalidate();
        }

        int total = 0;
        for (Integer cur : orders) {
            total += cur;
        }
        request.setAttribute("total", total);

        String url;
        if (done) {
            url = "/s17/buyNullDone.jsp";
        } else {
            url = "/s17/buyNull.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
