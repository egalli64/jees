package s22;

import java.time.LocalTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("start", LocalTime.now());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do here, currently
    }

}
