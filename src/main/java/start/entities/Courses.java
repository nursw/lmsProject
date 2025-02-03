package start.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "courses")

public class Course {
    private Long id;
    private String title;
    private Date date_of_start;
    private String description;

}
