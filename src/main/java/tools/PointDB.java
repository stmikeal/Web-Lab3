package tools;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@ApplicationScoped
public class PointDB {

    private final EntityManagerFactory entityManagerFactory;

    public PointDB(){
        System.out.println("Some shit code to add break.");
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        System.out.println("Some shit code to add break.\n ManagerFactory has been created.");
    }

    public void add(Point point) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(point);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void clear(String session_id) {

    }

    public List<Point> findAll(String session_id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Point> criteriaQuery = cb.createQuery(Point.class);
        Root<Point> root = criteriaQuery.from(Point.class);
        CriteriaQuery<Point> all = criteriaQuery.select(root);
        TypedQuery<Point> allQuery = entityManager.createQuery(all);
        entityManager.close();
        return allQuery.getResultList();
    }
}
