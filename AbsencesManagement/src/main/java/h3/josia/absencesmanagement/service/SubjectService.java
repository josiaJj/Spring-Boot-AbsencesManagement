package h3.josia.absencesmanagement.service;

import h3.josia.absencesmanagement.model.Subject;
import h3.josia.absencesmanagement.repository.SubjectRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepositoryJDBC subjectRepository;

    SubjectService(SubjectRepositoryJDBC subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectByMaxAbsentsStudents() { return subjectRepository.findByMaxAbsentsStudents(); }

    public String addSubject(Subject subject) {
        try {
            subjectRepository.insertSubject(subject);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String updateSubjectNameById(String idSubject, String newName) {
        try {
            subjectRepository.updateNameById(idSubject, newName);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String deleteSubjectById(String idSubject) {
        try {
            subjectRepository.deleteById(idSubject);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
