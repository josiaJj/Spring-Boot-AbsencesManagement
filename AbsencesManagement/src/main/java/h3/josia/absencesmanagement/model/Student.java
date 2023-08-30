package h3.josia.absencesmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private String std;
    private String firstname;
    private String lastname;
    private String email;
    private int idGroup;
    private int nbrAbsences;
}
