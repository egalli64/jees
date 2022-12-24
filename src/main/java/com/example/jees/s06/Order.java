/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.jees.s06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ordering servlet
 */
@SuppressWarnings("serial")
@WebServlet("/s06/order")
public class Order extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Order.class);

    /**
     * Fake order generation
     * 
     * @return a new empty order
     */
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

        int total = orders.values().stream().mapToInt(Album::getQuantity).sum();
        request.setAttribute("total", total);

        request.getRequestDispatcher("buy.jsp").forward(request, response);
    }
}
