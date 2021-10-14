package tools;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;


public class PointDB {
    public void add(Point point) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(point);
        tx1.commit();
        session.close();
    }

    public void clear(String session_id) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("delete from Point where session_id = :session_id");
        query.setParameter("session_id", session_id);
        query.executeUpdate();
        tx1.commit();
        session.close();
    }

    public List<Point> findAll(String session_id) {
        Session session = HibernateFactory.getSessionFactory().openSession();

        String requestString = "from Point where session_id = :session_id";
        Query query = session.createQuery(requestString);
        query.setParameter("session_id", session_id);
        try {
            return (List<Point>) query.list();
        }catch(ClassCastException e) {
            System.out.println("Threw Exception due casting query in 'findAll' in DB:\n" + e.getMessage());
            return null;
        }
    }
}
