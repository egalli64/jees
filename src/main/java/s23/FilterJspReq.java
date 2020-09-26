package s23;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "*.jsp" })
public class FilterJspReq implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(FilterJspReq.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest hsr = (HttpServletRequest) request;

            // rebuild the full URL joining the parameters, when available
            StringBuffer url = hsr.getRequestURL();
            String query = hsr.getQueryString();
            if (query != null) {
                url.append("?");
                url.append(query);
            }

            LOG.trace("filter JSP on " + url.toString());
        }

        chain.doFilter(request, response);
    }
}
