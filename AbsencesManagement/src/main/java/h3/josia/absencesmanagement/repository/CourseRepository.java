package h3.josia.absencesmanagement.repository;

import h3.josia.absencesmanagement.model.Course;

import java.sql.Date;
import java.util.List;

public interface CourseRepository {

    // La liste de tous les cours avec le nombre d'absences de chaque cours
    List<Course> findAll();

    // Le cours qui a le plus d'étudiats absents
    Course findByMaxAbsentStudents();

    // Insérer un cours en fournissant ses colonnes
    void insertCourse(Course course);

    //  Modifier la date d'un cours en fonction de l'ID du cours
    void updateCourseDate(int idCourse, Date newDate);

    // Supprimer un cours par son ID
    void deleteById(int idCourse);
}
