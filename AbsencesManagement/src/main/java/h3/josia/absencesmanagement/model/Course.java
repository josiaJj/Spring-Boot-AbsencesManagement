package h3.josia.absencesmanagement.model;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Course {
    private int idCourse;
    private Date dateCourse;
    private String idSubject;
    private int NbrAbsents;
}
