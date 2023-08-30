package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Group;
import h3.josia.absencesmanagement.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class StudentRepositoryJDBC implements StudentRepository{

    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        String studentList_request = "SELECT \n" +
                "    s.std,\n" +
                "    s.first_name,\n" +
                "    s.last_name,\n" +
                "    s.email,\n" +
                "    s.id_group,\n" +
                "    COALESCE(COUNT(CASE WHEN p.ispresent = FALSE THEN 1 END), 0) AS nbr_absences\n" +
                "FROM students s\n" +
                "LEFT JOIN present p ON s.std = p.std\n" +
                "GROUP BY s.std, s.first_name, s.last_name\n" +
                "ORDER BY s.last_name, s.first_name";

        try (
                Connection connection = DB_Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(studentList_request)
                ) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setStd(resultSet.getString("std"));
                student.setFirstname(resultSet.getString("first_name"));
                student.setLastname(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setIdGroup(resultSet.getInt("id_group"));
                student.setNbrAbsences(resultSet.getInt("nbr_absences"));

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    @Override
    public List<Student> findByMinimumAbsences(int minAbsences) {
        List<Student> studentList = new ArrayList<>();

        String studentList_request = "SELECT s.std, s.first_name, s.last_name, s.email, s.id_group, COUNT(p.isPresent) AS nbr_absences\n" +
                "FROM students s \n" +
                "INNER JOIN present p ON s.std = p.std \n" +
                "WHERE p.isPresent IS FALSE\n" +
                "GROUP BY s.std\n" +
                "HAVING COUNT(p.isPresent) >= ?";

        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(studentList_request);) {

            preparedStatement.setInt(1, minAbsences);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStd(resultSet.getString("std"));
                student.setFirstname(resultSet.getString("first_name"));
                student.setLastname(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setIdGroup(resultSet.getInt("id_group"));
                student.setNbrAbsences(resultSet.getInt("nbr_absences"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }
    public void insertStudent(Student student) {
        String insert_sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_sql)) {

            preparedStatement.setString(1, student.getStd());
            preparedStatement.setString(2, student.getFirstname());
            preparedStatement.setString(3, student.getLastname());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getIdGroup());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentGroup(String std, String newGroup) {
        String update_sql = "UPDATE students\n" +
                "SET id_group = (SELECT g.id_group FROM \"group\" g WHERE g.code_group = ?)\n" +
                "WHERE std = ? ";
        try (Connection connection = DB_Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(update_sql)) {

            preparedStatement.setString(2, std);
            preparedStatement.setString(1, newGroup);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteByStd(String std) {
        String delete_sql = "DELETE FROM students WHERE std = ?";
        try (Connection connection = DB_Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(delete_sql)) {

            preparedStatement.setString(1, std);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
