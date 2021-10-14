package tools;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class PointDB {

    private EntityManager manager;

    public void open() {
        manager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
    }

    public void add(Point point) {
        manager.getTransaction().begin();
        manager.persist(point);
        manager.flush();
        manager.getTransaction().commit();
    }

    public void clear(String session_id) {

    }

    public List<Point> findAll(String session_id) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Point> criteriaQuery = cb.createQuery(Point.class);
        Root<Point> root = criteriaQuery.from(Point.class);
        CriteriaQuery<Point> all = criteriaQuery.select(root);
        TypedQuery<Point> allQuery = manager.createQuery(all);
        return allQuery.getResultList();
    }
}
