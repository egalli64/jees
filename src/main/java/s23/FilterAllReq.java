package s23;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class FilterAllReq implements Filter {
    private FilterConfig fc;

    public void init(FilterConfig fc) throws ServletException {
        this.fc = fc;
    }

    public void destroy() {
        // nothing to do here, currently
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ServletContext sc = fc.getServletContext();

        if (! (request instanceof HttpServletRequest)) {
            sc.log("Strange. Not a HttpServletRequest");
        } else {
            HttpServletRequest hsr = (HttpServletRequest) request;
            
            StringBuffer url = hsr.getRequestURL();
            String query = hsr.getQueryString();
            if(query != null) {
                url.append("?");
                url.append(query);
            }

            sc.log("filter all on " + url.toString());
        }
        // ...
        chain.doFilter(request, response);
    }
}
