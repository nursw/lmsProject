package start.service;


import start.entities.Courses;
import start.entities.Instructors;

import java.util.List;

public interface InstructorsService {
    Instructors getInstructorById(Long id);
    List<Instructors> getAllInstructors();
    void createInstructor(Instructors instructor);
    void updateInstructor(Instructors instructor);
    void deleteInstructor(Long id);
    List<Courses> getInstructorCourses(Long instructorId);
}
