package s16;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = { "/s16/restricted/*" })
public class FilterRestricted implements Filter {
    private static final Logger log = LoggerFactory.getLogger(FilterRestricted.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            // put a denial message in the response and return
            response.setContentType("text/plain");
            response.setCharacterEncoding("utf-8");

            response.getWriter().println("Only HTTP requests accepted!");
            return;
        }

        HttpSession session = ((HttpServletRequest) request).getSession();
        Boolean logged = (Boolean) session.getAttribute("logged");

        log.trace("Access to restricted area is " + logged);
        if (logged == null || !logged) {
            // new request, the URL is _not_ relative to the current web app
            ((HttpServletResponse) response).sendRedirect("/jes/s16/login.html");

            // use this to keep the original request
//                request.getRequestDispatcher("/s16/login.html").forward(request, response);

            // in both case, remember to end here the filtering
            return;
        }

        chain.doFilter(request, response);

        // put your filter-out behavior here
        log.trace("Exiting restricted area");

        // here, login is valid just for one access!
        session.setAttribute("logged", false);
    }
}
