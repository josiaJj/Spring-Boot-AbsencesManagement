package h3.josia.absencesmanagement.service;

import h3.josia.absencesmanagement.model.Course;
import h3.josia.absencesmanagement.model.Student;
import h3.josia.absencesmanagement.repository.CourseRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepositoryJDBC courseRepository;

    public CourseService(CourseRepositoryJDBC courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseByMaxAbsentStudents() {
        return courseRepository.findByMaxAbsentStudents();
    }

    public String addCourse(Course course) {
        try {
            courseRepository.insertCourse(course);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String updateCourseDate(int idCourse, Date newDate) {
        try {
            courseRepository.updateCourseDate(idCourse, newDate);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String removeCourseById(int idCourse) {
        try {
            courseRepository.deleteById(idCourse);
            return "Http message SUCCES";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
