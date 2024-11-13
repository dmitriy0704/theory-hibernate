package dev.folomkin.hibernate.starter;

import dev.folomkin.hibernate.starter.entity.*;
import dev.folomkin.hibernate.starter.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.Instant;

class HibernateRunnerTest {
    @Test
    public void  checkHQL() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        // <-- Custom

//        var company = Company.builder()
//                .name("Yandex").build();
//        session.save(company);
//
//        var programmer = Programmer.builder()
//                .username("ivan@gmail.com")
//                .language(Language.JAVA)
//                .company(company)
//                .build();
//        session.save(programmer);
//
//        var manager = Manager.builder()
//                .username("petr@gmail.com")
//                .project("Java Enterprise")
//                .company(company)
//                .build();
//        session.save(manager);
//
//        session.flush();
//        session.clear();
//
//        var programmer1 = session.get(Programmer.class,1L);
//        var manager1 = session.get(Manager.class,2L);


        // Custom -->
        session.getTransaction().commit();
    }
    @Test
    public void testInheritance() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        // <-- Custom

//        var company = Company.builder()
//                .name("Yandex").build();
//        session.save(company);
//
//        var programmer = Programmer.builder()
//                .username("ivan@gmail.com")
//                .language(Language.JAVA)
//                .company(company)
//                .build();
//        session.save(programmer);
//
//        var manager = Manager.builder()
//                .username("petr@gmail.com")
//                .project("Java Enterprise")
//                .company(company)
//                .build();
//        session.save(manager);
//
//        session.flush();
//        session.clear();
//
//        var programmer1 = session.get(Programmer.class,1L);
//        var manager1 = session.get(Manager.class,2L);


        // Custom -->
        session.getTransaction().commit();
    }

    @Test
    public void checkH2() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        // <-- Custom

        var company = Company.builder()
                .name("MailRu").build();

        session.save(company);

        // Custom -->
        session.getTransaction().commit();
    }

    @Test
    public void checkManyToMany() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        Chat chat = session.get(Chat.class, 1L);
        User user = session.get(User.class, 10L);

//        UsersChat userChat = UsersChat.builder()
//                .createdAt(Instant.now())
//                .createdBy("Dmitriy")
//                .build();

        UsersChat userChat = new UsersChat();
        userChat.setChat(chat);
        userChat.setUser(user);
        session.save(userChat);
        session.getTransaction().commit();
    }


    @Test
    public void checkOneToOne() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
//
//        User user = User.builder()
//                .username("ivan4@gmail.com")
//                .build();
//
//        Profile profile = Profile.builder()
//                .language("RU")
//                .street("Wall St.")
//                .build();
//
//        session.save(user);
//        profile.setUser(user);
//        session.save(profile);

        session.getTransaction().commit();
    }


    @Test
    public void checkOrphanRemoval() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        Company company = session.get(Company.class, 11);
        company.getUsers().removeIf(user -> user.getId().equals(8));

        session.getTransaction().commit();
    }

    @Test
    public void addNewUserAndCompany() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

//        Company company = Company.builder()
//                .name("VK")
//                .build();
//        User user = User.builder()
//                .username("ivanVk@gmail.com")
//                .build();
//
//        company.addUser(user);
//        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    public void checkOneToMany() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        var company = session.get(Company.class, 7);
        System.out.println(company.getUsers());
        session.getTransaction().commit();
    }


    @Test
    public void testHibernateApi() throws SQLException, IllegalAccessException {
//        var user = User.builder()
//                .username("ivan2@gmail.com")
//                .firstname("ivan")
//                .lastname("ivanov")
//                .birthDate(LocalDate.of(2000, 4, 4))
//                .age(24)
//                .role(Role.ADMIN)
//                .build();
//        var sql = """
//                insert into
//                %s
//                (%s)
//                values
//                (%s)
//                """;
//
//        var tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
//                .map(table -> table.schema() + "." + table.name())
//                .orElse(user.getClass().getName());
//
//        Field[] fields = user.getClass().getDeclaredFields();
//
//        var columnName = Arrays.stream(fields)
//                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
//                        .map(Column::name)
//                        .orElse(field.getName())
//                )
//                .collect(Collectors.joining(", "));
//
//        var columnValues = Arrays.stream(fields)
//                .map(field -> "?")
//                .collect(Collectors.joining(", "));
//
//
//        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
//                "postgres", "postgres123");
//
//        PreparedStatement preparedStatement = connection
//                .prepareStatement(sql.formatted(tableName, columnName, columnValues));
//
//        for (int i = 0; i < fields.length; i++) {
//            fields[i].setAccessible(true);
//            preparedStatement.setObject(i + 1, fields[i].get(user));
//        }
//        System.out.println(preparedStatement);
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
//        connection.close();
    }
}