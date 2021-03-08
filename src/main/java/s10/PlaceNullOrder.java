package s10;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet("/s10/nullOrder")
public class PlaceNullOrder extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(PlaceNullOrder.class);

    private Map<String, Album> createEmptyOrder() {
        Map<String, Album> result = new HashMap<>();
        result.put("1", new Album(1, "Null", 0));
        result.put("2", new Album(2, "One second", 0));
        result.put("3", new Album(3, "Three trees", 0));
        result.put("4", new Album(4, "For four forks", 0));

        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        Map<String, Album> orders = (Map<String, Album>) session.getAttribute("orders");
        if (orders == null) {
            orders = createEmptyOrder();
            session.setAttribute("orders", orders);
        }

        // TODO: check null
        String id = request.getParameter("id");
        String value = request.getParameter("quantity");
        log.debug("called for id={}, value={}", id, value);

        Album chosen = orders.get(id);

        try {
            // TODO: check less than zero
            int quantity = Integer.parseInt(value);
            chosen.setQuantity(chosen.getQuantity() + quantity);
        } catch (Exception ex) {
            // TODO: handle exception
            log.error(ex.getMessage());
            throw ex;
        }

        int total = 0;
        for (Album current : orders.values()) {
            total += current.getQuantity();
        }
        request.setAttribute("total", total);

        request.getRequestDispatcher("buyNull.jsp").forward(request, response);
    }
}
