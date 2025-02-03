package start.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Courses {
    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    private Long id;

    private String title;
    private Date date_of_start;
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructors instructor;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Students> students;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Lessons> lessonsList;
}
