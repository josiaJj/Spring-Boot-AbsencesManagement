package h3.josia.absencesmanagement.controller;

import h3.josia.absencesmanagement.model.Course;
import h3.josia.absencesmanagement.model.Group;
import h3.josia.absencesmanagement.service.GroupService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {

        this.groupService = groupService;
    }

    @GetMapping("ListOfAllGroups")
    public List<Group> groupList() {
        return groupService.getALlGroups();
    }

    @GetMapping("/ListOfGroupsFromDate")
    public List<Group> groupsWithNumberOfAbsentStudents(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") String anyDate) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(anyDate);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            return groupService.getGroupsByAbsentStudentsFromDate(sqlDate);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody String codeGroup) {
        String message = groupService.addGroup(codeGroup);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{idGroup}/update-code")
    public ResponseEntity<String> updateCodeGroup(@PathVariable int idGroup, @RequestParam String newCode) {
        String message = groupService.updateCodeGroup(idGroup, newCode);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{codeGroup}")
    public ResponseEntity<String> removeGroupByCode(@PathVariable String codeGroup) {
        String message = groupService.removeGroupByCode(codeGroup);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
