package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Course;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryJDBC implements CourseRepository{

    @Override
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();

        String findAllRequest = "SELECT \n" +
                "    c.id_course,\n" +
                "    c.date_course,\n" +
                "    c.id_subject,\n" +
                "    COALESCE(COUNT(CASE WHEN p.ispresent is FALSE THEN 1 END), 0) AS nbr_absences\n" +
                "FROM courses c\n" +
                "LEFT JOIN present p ON c.id_course = p.id_course\n" +
                "GROUP BY c.id_course, c.date_course, c.id_subject\n" +
                "ORDER BY c.date_course DESC";

        try (
                Connection connection = DB_Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(findAllRequest)
        ) {
            while(resultSet.next()) {
                Course course = new Course();

                course.setIdCourse(resultSet.getInt("id_course"));
                course.setIdSubject(resultSet.getString("id_subject"));
                course.setDateCourse(resultSet.getDate("date_course"));
                course.setNbrAbsents((resultSet.getInt("nbr_absences")));

                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  courseList;
    }
    @Override
    public Course findByMaxAbsentStudents() {
        Course course = new Course();

        String findRequest = "SELECT c.id_course, c.id_subject, c.date_course, COUNT(p.isPresent) AS nbr_absents\n" +
                "FROM courses c\n" +
                "INNER JOIN present p ON c.id_course = p.id_course\n" +
                "WHERE p.isPresent IS FALSE \n" +
                "GROUP BY c.id_course, c.id_subject\n" +
                "ORDER BY COUNT(p.isPresent) DESC\n" +
                "LIMIT 1";

        try (
                Connection connection = DB_Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(findRequest)
        ) {
            resultSet.next();
            course.setIdCourse(resultSet.getInt("id_course"));
            course.setDateCourse(resultSet.getDate("date_course"));
            course.setIdSubject(resultSet.getString("id_subject"));
            course.setNbrAbsents(resultSet.getInt("nbr_absents"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  course;
    }

    @Override
    public void insertCourse(Course course) {
        String insert_sql = "INSERT INTO courses VALUES (?, ?, ?)";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_sql)) {

            preparedStatement.setInt(1, course.getIdCourse());
            preparedStatement.setDate(2, course.getDateCourse());
            preparedStatement.setString(3, course.getIdSubject());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourseDate(int idCourse, Date newDate) {
        String update_sql = "UPDATE courses \n" +
                "SET date_course = ?\n" +
                "WHERE id_course = ?";

        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_sql)) {

            preparedStatement.setInt(2, idCourse);
            preparedStatement.setDate(1, newDate);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int idCourse) {
        String delete_sql = "DELETE FROM courses WHERE id_course = ?";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete_sql)) {

            preparedStatement.setInt(1, idCourse);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
