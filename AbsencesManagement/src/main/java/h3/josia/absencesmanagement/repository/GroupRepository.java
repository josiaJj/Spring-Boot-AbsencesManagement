package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Group;

import java.sql.Date;
import java.util.List;

public interface GroupRepository {
    // Liste de tous les courses avec son nombre d'absences en ordre du plus recent
    List<Group> findAll();

    // Liste des groupes avec le nombre d'étudiants absents d'une telle date
    List<Group> findByAbsentStudentsFromDate(Date anyDate);

    // insérer un nouveau groupe
    void insertGroup(String codeGroup);

    // Modifier le code du group par son Id
    void updateCode(int idGroup, String newCodeGroup);

    // Supprimer un groupe par son code
    void deleteByCode(String codeGroup);
}
