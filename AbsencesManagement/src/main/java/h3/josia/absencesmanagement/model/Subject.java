package h3.josia.absencesmanagement.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Subject {
    private String idSubject;
    private String name;
    private int nbrAbsents;
}
