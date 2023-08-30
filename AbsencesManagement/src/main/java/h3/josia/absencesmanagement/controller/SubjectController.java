package h3.josia.absencesmanagement.controller;

import h3.josia.absencesmanagement.model.Course;
import h3.josia.absencesmanagement.model.Subject;
import h3.josia.absencesmanagement.service.SubjectService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/ListOfSubjects")
    public List<Subject> subjectList() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/SubjectByMaxAbsentsStudents")
    public Subject subjectByMaxAbsentsStudents() {
        return subjectService.getSubjectByMaxAbsentsStudents();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSubject(@RequestBody Subject subject) {
        String message = subjectService.addSubject(subject);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{idSubject}/update-name")
    public ResponseEntity<String> updateSubjectName(@PathVariable String idSubject, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String newName) throws ParseException {
        String message = subjectService.updateSubjectNameById(idSubject, newName);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idSubject}")
    public ResponseEntity<String> deleteSubjectById(@PathVariable String idSubject) {
        String message = subjectService.deleteSubjectById(idSubject);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
