package start.entities;



import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lessons {
    @Id
    @GeneratedValue(generator = "lessons_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "lessons_gen", sequenceName = "lessons_seq", allocationSize = 1)
    private Long id;

    private String title;
    private Date publisher_date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course;
}
