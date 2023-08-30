package h3.josia.absencesmanagement.service;

import h3.josia.absencesmanagement.model.Student;
import h3.josia.absencesmanagement.model.Group;
import h3.josia.absencesmanagement.repository.GroupRepository;
import h3.josia.absencesmanagement.repository.GroupRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepositoryJDBC groupRepository;

    public GroupService(GroupRepositoryJDBC groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getALlGroups() {
        return groupRepository.findAll();
    }
    public List<Group> getGroupsByAbsentStudentsFromDate(Date anyDate) {
        return groupRepository.findByAbsentStudentsFromDate(anyDate);
    }
    public String addGroup(String codeGroup) {
        try {
            groupRepository.insertGroup(codeGroup);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String updateCodeGroup(int idGroup, String newCodeGroup) {
        try {
            groupRepository.updateCode(idGroup, newCodeGroup);
            return "Http message SUCCES !";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public String removeGroupByCode(String codeGroup) {
        try {
            groupRepository.deleteByCode(codeGroup);
            return "Http message SUCCES";
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
