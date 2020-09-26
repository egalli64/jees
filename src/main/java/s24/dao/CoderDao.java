package s24.dao;

import java.util.List;

import org.hibernate.Session;

public class CoderDao {
    public List<Coder> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Coder", Coder.class).list();
        }
    }
}
