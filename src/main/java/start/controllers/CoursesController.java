package start.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import start.entities.Courses;
import start.entities.Instructors;
import start.entities.Students;
import start.service.CoursesService;
import start.service.InstructorsService;
import start.service.StudentsService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService coursesService;
    private final InstructorsService instructorsService;
    private final StudentsService studentsService;

    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable Long id) {
        return coursesService.getCourseById(id);
    }

    @GetMapping
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@RequestBody Courses course) {
        coursesService.createCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody Courses course) {
        course.setId(id);
        coursesService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
    }

    @PostMapping("/{courseId}/instructors/{instructorId}")
    public void assignInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        Instructors instructor = instructorsService.getInstructorById(instructorId);
        coursesService.assignInstructor(courseId, instructor);
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public void addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Students student = studentsService.getStudentById(studentId);
        coursesService.addStudentToCourse(courseId, student);
    }

    @GetMapping("/{id}/details")
    public void getCourseDetails(@PathVariable Long id) {
        coursesService.getCourseDetails(id);
    }
}
