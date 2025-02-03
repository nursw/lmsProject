package start.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import start.entities.Courses;
import start.entities.Instructors;
import start.service.InstructorsService;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorsController {

    private final InstructorsService instructorsService;

    @GetMapping("/{id}")
    public Instructors getInstructorById(@PathVariable Long id) {
        return instructorsService.getInstructorById(id);
    }

    @GetMapping
    public List<Instructors> getAllInstructors() {
        return instructorsService.getAllInstructors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInstructor(@RequestBody Instructors instructor) {
        instructorsService.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public void updateInstructor(@PathVariable Long id, @RequestBody Instructors instructor) {
        instructor.setId(id);
        instructorsService.updateInstructor(instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorsService.deleteInstructor(id);
    }

    @GetMapping("/{id}/courses")
    public List<Courses> getInstructorCourses(@PathVariable Long id) {
        return instructorsService.getInstructorCourses(id);
    }
}
