import tools.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Hibernate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Point p = new Point("3", "4", "5");
        EntityTransaction entityTransaction= entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(p);
        entityTransaction.commit();
        entityManager.close();
    }
}
