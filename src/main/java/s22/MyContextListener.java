package s22;

import java.time.LocalTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MyContextListener implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(MyContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        LOG.trace("called");
        sce.getServletContext().setAttribute("start", LocalTime.now());
    }
}
