package s27.dao;

import java.util.List;

import org.hibernate.Session;

public class RegionDao {
    public List<Region> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Region", Region.class).list();
        }
    }
}
