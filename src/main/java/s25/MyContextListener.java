package s25;

import java.time.LocalTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MyContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(MyContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        logger.trace("called");
        sce.getServletContext().setAttribute("start", LocalTime.now());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do here, currently
    }
}
