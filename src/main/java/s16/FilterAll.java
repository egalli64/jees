package s16;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = { "/s16/*" })
public class FilterAll implements Filter {
    private static final Logger log = LoggerFactory.getLogger(FilterAll.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            log.error("Only HttpServletRequest are accepted");
            return;
        }

        // filter in
        HttpServletRequest hsr = (HttpServletRequest) request;
        String url = hsr.getRequestURL().toString();
        log.trace("filter in " + url);

        chain.doFilter(request, response);

        // filter out
//        log.trace("filter out " + url.toString());
    }
}
