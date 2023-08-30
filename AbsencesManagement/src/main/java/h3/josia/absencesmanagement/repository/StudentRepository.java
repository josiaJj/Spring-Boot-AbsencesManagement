package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Student;

import java.util.List;

public interface StudentRepository {

    // Liste de tous les étudiants avec son nombre total d'absences
    List<Student> findAll();

    // Liste des étudiants selon un tel nombre d'absences minimum
    List<Student> findByMinimumAbsences(int minAbsences);

    // Insérer un étudiants en fournissant tous ses colonnes
    void insertStudent(Student student);

    // Changer le groupe d'un étudiant en fonction de son STD
    void updateStudentGroup(String std, String newGroup);

    // Supprimer un étudiant en fonction de son STD
    void deleteByStd(String std);

}
