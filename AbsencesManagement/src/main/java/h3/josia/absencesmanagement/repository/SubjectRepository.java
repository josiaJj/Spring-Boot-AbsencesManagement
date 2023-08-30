package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Subject;

import java.util.List;

public interface SubjectRepository {

    // Liste de tous les matières avec leur nombre d'absences
    List<Subject> findAll();

    // La matière qui a eu le plus d'étudiants absents
    Subject findByMaxAbsentsStudents();

    // insérer une nouvelle matière
    void insertSubject(Subject subject);

    // Modifer le nom d'une matière par son Id
    void updateNameById(String idSubject, String newName);

    // Supprimer une matière par son Id
    void deleteById(String idSubject);
}
