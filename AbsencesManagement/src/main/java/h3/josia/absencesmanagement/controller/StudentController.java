package h3.josia.absencesmanagement.controller;

import h3.josia.absencesmanagement.model.Student;
import h3.josia.absencesmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/ListOfAllStudents")
    public List<Student> studentList() {
        return studentService.getAllStudents();
    }

    @GetMapping("/ListOfStudents")
    public List<Student> studentsList(@RequestParam int minAbsences) {

        return studentService.getStudentsWithMinimumAbsences(minAbsences);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        String message = studentService.addStudent(student);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{std}/update-group")
    public ResponseEntity<String> updateStudentGroup(@PathVariable String std, @RequestParam String newGroup) {
        String message = studentService.updateStudentGroup(std, newGroup);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{std}")
    public ResponseEntity<String> removeStudent(@PathVariable String std) {
        String message = studentService.removeStudentByStd(std);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
