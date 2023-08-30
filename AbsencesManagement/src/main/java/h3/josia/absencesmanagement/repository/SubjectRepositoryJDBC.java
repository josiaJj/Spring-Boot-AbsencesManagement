package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Subject;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectRepositoryJDBC implements SubjectRepository{
    @Override
    public List<Subject> findAll() {
        List<Subject> subjectList = new ArrayList<>();

        String findAllRequest = "SELECT sb.id_subject, sb.name AS subject_name, COUNT(p.isPresent) AS nbr_absents\n" +
                "FROM subjects sb \n" +
                "LEFT JOIN courses c ON sb.id_subject = c.id_subject\n" +
                "FULL OUTER JOIN present p ON c.id_course = p.id_course\n" +
                "WHERE p.isPresent IS NULL\n" +
                "    OR p.isPresent IS FALSE\n" +
                "GROUP BY sb.id_subject\n" +
                "ORDER BY COUNT(p.isPresent) DESC";

        try (
                Connection connection = DB_Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(findAllRequest)
        ) {
            while(resultSet.next()) {
                Subject subject = new Subject();

                subject.setIdSubject(resultSet.getString("id_subject"));
                subject.setName(resultSet.getString("subject_name"));
                subject.setNbrAbsents(resultSet.getInt("nbr_absents"));

                subjectList.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjectList;
    }

    @Override
    public Subject findByMaxAbsentsStudents() {
        Subject subject = new Subject();

        String findSubjectRequest = "SELECT sb.id_subject, sb.name AS subject_name, COUNT(p.isPresent) AS nbr_absents\n" +
                "FROM subjects sb \n" +
                "INNER JOIN courses c ON sb.id_subject = c.id_subject\n" +
                "INNER JOIN present p ON c.id_course = p.id_course\n" +
                "WHERE p.isPresent IS FALSE\n" +
                "GROUP BY sb.id_subject\n" +
                "ORDER BY COUNT(p.isPresent) DESC\n" +
                "LIMIT 1";

        try (
                Connection connection = DB_Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(findSubjectRequest)
        ) {
            while(resultSet.next()) {

                subject.setIdSubject(resultSet.getString("id_subject"));
                subject.setName(resultSet.getString("subject_name"));
                subject.setNbrAbsents(resultSet.getInt("nbr_absents"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subject;
    }

    public void insertSubject(Subject subject) {
        String insert_sql = "INSERT INTO subjects \n" +
                "VALUES(?, ?)";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_sql)) {

            preparedStatement.setString(1, subject.getIdSubject());
            preparedStatement.setString(2, subject.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNameById(String idSubject, String newName) {
        String update_sql = "UPDATE subjects \n" +
                "SET name = ?\n" +
                "WHERE id_subject = ?;";

        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_sql)) {

            preparedStatement.setString(2, idSubject);
            preparedStatement.setString(1, newName);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String idSubject) {
        String delete_sql = "DELETE FROM subjects WHERE id_subject = ?";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete_sql)) {

            preparedStatement.setString(1, idSubject);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
