package h3.josia.absencesmanagement.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Group {
    private Integer idGroup;
    private String codeGroup;
    private Integer totalAbsents;
}
