package s27.dao;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();

        settings.put(Environment.DATASOURCE, "java:comp/env/jdbc/me");
        settings.put(Environment.SHOW_SQL, "true");
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Coder.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
