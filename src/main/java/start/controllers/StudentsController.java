package start.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import start.entities.Courses;
import start.entities.Students;
import start.service.StudentsService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable Long id) {
        return studentsService.getStudentById(id);
    }

    @GetMapping
    public List<Students> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Students student) {
        studentsService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Students student) {
        student.setId(id);
        studentsService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentsService.deleteStudent(id);
    }

    @GetMapping("/{id}/courses")
    public List<Courses> getStudentCourses(@PathVariable Long id) {
        return studentsService.getStudentCourses(id);
    }
}
