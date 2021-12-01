package studManager.ui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;


public class MysqlRepository implements StudentRepository {
    private final static String url = "jdbc:mysql://localhost:3306/student_manager";
    private final static String user = "root";
    private final static String password = "1234";


    @Override
    public Iterable<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from `student`;")) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setGroupName(resultSet.getString("group_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setSecondName(resultSet.getString("second_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setBirthdayDate(resultSet.getString("birthday_date"));
                students.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;

    }

    @Override
    public Student save(Student student) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            String str3 = """
                      CREATE TABLE IF NOT EXISTS `student` (
                      `id` int NOT NULL AUTO_INCREMENT,
                      `group_name` varchar(45) NOT NULL,
                      `first_name` varchar(45) NOT NULL,
                      `second_name` varchar(45) NOT NULL,
                      `last_name` varchar(45) NOT NULL,
                      `birthday_date` date NOT NULL,
                      PRIMARY KEY (`id`),
                      UNIQUE KEY `idstudent_UNIQUE` (`id`)
                    )""";
            statement.executeUpdate(str3);
            String str4 = "INSERT INTO `student_manager`.`student` (`group_name`," +
                    " `first_name`, `second_name`, `last_name`, `birthday_date`)" +
                    " VALUES ('" + student.getGroupName() + "', '" + student.getFirstName()
                    + "', '" + student.getSecondName() + "', '"
                    + student.getLastName() + "', '"
                    + student.getBirthdayDate() + "');";
            statement.executeUpdate(str4);
            ResultSet resultSet = statement.executeQuery("select * from `student` where group_name='"
                    + student.getGroupName() + "' and first_name='" + student.getFirstName()
                    + "' and second_name='" + student.getSecondName()
                    + "' and last_name='" + student.getLastName()
                    + "' and birthday_date='" + student.getBirthdayDate() + "';");
            if (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public Student findStudent(Long id) {
        Student student = new Student();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from `student` where id='"
                    + id + "';");
            if (resultSet.next()) {

                student.setId(id);
                student.setGroupName(resultSet.getString("group_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setSecondName(resultSet.getString("second_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setBirthdayDate(resultSet.getString("birthday_date"));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }


}
