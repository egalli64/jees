package s16;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "*.jsp" })
public class FilterJsp implements Filter {
    private static final Logger log = LogManager.getLogger(FilterJsp.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new IllegalStateException("Only HttpServletRequest are expected!");
        }

        HttpServletRequest hsr = (HttpServletRequest) request;
        String url = getUrl(hsr);
        log.trace("Enter " + url);

        chain.doFilter(request, response);

//        log.trace("Exit " + url);
    }

    private String getUrl(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String query = request.getQueryString();
        if (query != null) {
            url.append("?");
            url.append(query);
        }

        return url.toString();
    }
}
