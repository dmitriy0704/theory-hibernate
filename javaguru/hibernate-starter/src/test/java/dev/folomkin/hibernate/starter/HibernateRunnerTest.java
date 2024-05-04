package dev.folomkin.hibernate.starter;

import dev.folomkin.hibernate.starter.entity.*;
import dev.folomkin.hibernate.starter.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.time.LocalDate;

class HibernateRunnerTest {

    @Test
    public void addUserAndCompany() throws SQLException {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();




        Company company = Company.builder()
                .name("Google")
                .build();
        User user = User.builder()
                .username("ivan2@gmail.com")
                .personalInfo(
                        PersonalInfo.builder()
                                .firstname("ivan")
                                .lastname("ivanov")
                                .birthDate(new Birthday(LocalDate.of(2000, 4, 4)))
                                .build()
                )
                .company(company)
                .role(Role.ADMIN)
                .build();


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