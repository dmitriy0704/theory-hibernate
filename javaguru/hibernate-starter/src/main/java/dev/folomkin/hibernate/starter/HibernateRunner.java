package dev.folomkin.hibernate.starter;

import dev.folomkin.hibernate.starter.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAnnotatedClass(User.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.save(User.builder()
                    .username("ivan@gmail.com")
                    .firstname("ivan")
                    .lastname("ivanov")
                    .birthDate(LocalDate.of(2000, 4, 4))
                    .age(24)
                    .build());

            session.getTransaction().commit();
        }
    }
}
