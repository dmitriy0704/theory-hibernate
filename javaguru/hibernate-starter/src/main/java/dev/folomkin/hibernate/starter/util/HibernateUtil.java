package dev.folomkin.hibernate.starter.util;

import dev.folomkin.hibernate.starter.converter.BirthdayConverter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {

        Configuration configuration = new Configuration().configure();
        configuration.addAttributeConverter(new BirthdayConverter(), true);
        return configuration.buildSessionFactory();
    }

}
