package start.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Instructors {
    @Id
    @GeneratedValue(generator = "instructors_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "instructors_gen", sequenceName = "instructors_seq", allocationSize = 1)
    private Long id;

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Courses> courses;
}