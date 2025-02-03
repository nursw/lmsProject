package start.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Students {
    @Id
    @GeneratedValue(generator = "students_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "students_gen", sequenceName = "students_seq", allocationSize = 1)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    @ToString.Exclude
    @ManyToMany(mappedBy = "students")
    private List<Courses> courses;
}
