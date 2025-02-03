package start.service;



import start.entities.Courses;
import start.entities.Students;

import java.util.List;

public interface StudentsService {
    Students getStudentById(Long id);
    List<Students> getAllStudents();
    void createStudent(Students student);
    void updateStudent(Students student);
    void deleteStudent(Long id);
    List<Courses> getStudentCourses(Long studentId);
}
