package start.service;


import start.entities.Courses;
import start.entities.Instructors;
import start.entities.Students;

import java.util.List;

public interface CoursesService {
    Courses getCourseById(Long id);
    List<Courses> getAllCourses();
    void createCourse(Courses course);
    void updateCourse(Courses course);
    void deleteCourse(Long id);
    void assignInstructor(Long courseId, Instructors instructor);
    void addStudentToCourse(Long courseId, Students student);
    void getCourseDetails(Long courseId);
}
