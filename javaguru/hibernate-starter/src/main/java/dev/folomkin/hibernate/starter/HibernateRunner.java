package dev.folomkin.hibernate.starter;

import dev.folomkin.hibernate.starter.entity.Birthday;
import dev.folomkin.hibernate.starter.entity.PersonalInfo;
import dev.folomkin.hibernate.starter.entity.Role;
import dev.folomkin.hibernate.starter.entity.User;
import dev.folomkin.hibernate.starter.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.time.LocalDate;


@Slf4j
public class HibernateRunner {
    public static void main(String[] args) {
        User user = User.builder()
                .username("ivan2@gmail.com")
                .personalInfo(
                        PersonalInfo.builder()
                                .firstname("ivan")
                                .lastname("ivanov")
                                .birthDate(new Birthday(LocalDate.of(2000, 4, 4)))
                                .build()
                )
                .role(Role.ADMIN)
                .build();
        log.info("User object is transient state {} ", user);
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();
                session1.saveOrUpdate(user);
                session1.getTransaction().commit();
            }
        } catch (Exception e) {
            log.error("Exception occurred: ", e);
            throw e;
        }
    }
}
