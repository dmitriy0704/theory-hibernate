package my.home;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .buildSessionFactory();

        Session session = null;

        // ==== CREATE ==== //
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item item = new Item("Milk", 80);
//        System.out.println(item);
//        session.save(item);
//        System.out.println(item);
//        session.getTransaction().commit();

        // ==== READ ==== //
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class, 1L);
//        System.out.println(itemFromDb);
//        session.getTransaction().commit();

        // ||
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();

        // Получаем один объект
//        Item itemFromDb = session.createQuery(
//                        "select i from Item i where i.id = :id",
//                        Item.class)
//                .setParameter("id", 4L)
//                .getSingleResult();
//        System.out.println(itemFromDb);


        // Получаем список объектов:
//        List<Item> items = session.createQuery("select i from Item i", Item.class).getResultList();
//        System.out.println(items );
//        session.getTransaction().commit();

        // === UPDATE === //
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class, 1L);
//        System.out.println(itemFromDb);
//        itemFromDb.setPrice(80);
//        itemFromDb.setTitle("Milk");
//        session.getTransaction().commit();

        // === DELETE === //
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDb = session.get(Item.class, 1L);
//        System.out.println(itemFromDb);
//        session.remove(itemFromDb);
//        session.getTransaction().commit();


        //Реализация связанных таблиц
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, 1L);
        System.out.println(user);
        System.out.println(user.getDetails());
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
