package h3.josia.absencesmanagement.service;

import h3.josia.absencesmanagement.model.Student;
import h3.josia.absencesmanagement.repository.StudentRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepositoryJDBC studentRepository;

    public StudentService(StudentRepositoryJDBC studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public List<Student> getStudentsWithMinimumAbsences(int minAbsences) {
        return studentRepository.findByMinimumAbsences(minAbsences);
    }

    public String addStudent(Student student) {
        try {
            studentRepository.insertStudent(student);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }

    }

    public String updateStudentGroup(String std, String newGroup) {
        try {
            studentRepository.updateStudentGroup(std, newGroup);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String removeStudentByStd(String std) {
        try {
            studentRepository.deleteByStd(std);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
