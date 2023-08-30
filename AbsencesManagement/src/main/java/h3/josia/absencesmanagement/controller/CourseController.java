package h3.josia.absencesmanagement.controller;

import h3.josia.absencesmanagement.model.Course;
import h3.josia.absencesmanagement.model.Student;
import h3.josia.absencesmanagement.service.CourseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("ListOfAllCourses")
    public List<Course> courseList() {
        return courseService.getAllCourses();
    }

    @GetMapping("CourseByMaxAbsentStudents")
    public Course courseByMaxAbsentStudents() {
        return courseService.getCourseByMaxAbsentStudents();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        String message = courseService.addCourse(course);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{idCourse}/update-date")
    public ResponseEntity<String> updateCourseDate(@PathVariable int idCourse, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String newDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = dateFormat.parse(newDate);
        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

        String message = courseService.updateCourseDate(idCourse, sqlDate);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCourse}")
    public ResponseEntity<String> removeCourse(@PathVariable int idCourse) {
        String message = courseService.removeCourseById(idCourse);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
