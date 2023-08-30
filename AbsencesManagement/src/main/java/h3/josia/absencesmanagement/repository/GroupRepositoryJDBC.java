package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Group;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepositoryJDBC implements GroupRepository{

    @Override
    public List<Group> findAll() {
        List<Group> groupList = new ArrayList<>();

                String findAllRequest = "SELECT \n" +
                        "    g.id_group, \n" +
                        "    g.code_group, \n" +
                        "    COALESCE(COUNT(CASE WHEN p.ispresent = FALSE THEN 1 END), 0) AS total_absents\n" +
                        "FROM \"group\" g\n" +
                        "LEFT JOIN students s ON g.id_group = s.id_group\n" +
                        "FULL OUTER JOIN present p ON s.std = p.std\n" +
                        "GROUP BY g.id_group\n" +
                        "ORDER BY total_absents DESC";
        try(Connection connection = DB_Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllRequest)
            ) {
            while(resultSet.next()) {
                Group group = new Group();
                group.setIdGroup(resultSet.getInt("id_group"));
                group.setCodeGroup(resultSet.getString("code_group"));
                group.setTotalAbsents(resultSet.getInt("total_absents"));

                groupList.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return groupList;
    }
    @Override
    public List<Group> findByAbsentStudentsFromDate(Date anyDate) {
        List<Group> groupList = new ArrayList<>();

        String groupListRequest = "SELECT g.id_group, g.code_group, COUNT(p.isPresent) AS total_absents\n" +
                "FROM \"group\" g\n" +
                "LEFT JOIN students s ON g.id_group = s.id_group\n" +
                "LEFT JOIN present p ON s.std = p.std\n" +
                "INNER JOIN courses c ON p.id_course = c.id_course\n" +
                "WHERE (p.isPresent IS FALSE\n" +
                "        OR p.isPresent IS NULL)\n" +
                "    AND c.date_course = ?\n" +
                "GROUP BY g.id_group, g.code_group\n" +
                "ORDER BY total_absents DESC";

        try (Connection connection = DB_Connection.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(groupListRequest);
            preparedStatement.setDate(1, anyDate);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Group group = new Group();
                group.setIdGroup(resultSet.getInt("id_group"));
                group.setCodeGroup(resultSet.getString("code_group"));
                group.setTotalAbsents(resultSet.getInt("total_absents"));
                groupList.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return groupList;
    }

    @Override
    public void insertGroup(String codeGroup) {
        String insert_sql = "INSERT INTO \"group\"(code_group) VALUES (?)";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_sql)) {

            preparedStatement.setString(1, codeGroup);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCode(int idGroup, String newCodeGroup) {
        String update_sql = "UPDATE \"group\" \n" +
                "SET code_group = ?\n" +
                "WHERE id_group = ?";

        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_sql)) {

            preparedStatement.setInt(2, idGroup);
            preparedStatement.setString(1, newCodeGroup);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByCode(String codeGroup) {
        String delete_sql = "DELETE FROM \"group\" WHERE code_group = ?";
        try (Connection connection = DB_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete_sql)) {

            preparedStatement.setString(1, codeGroup);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
