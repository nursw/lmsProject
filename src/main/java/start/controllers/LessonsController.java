package start.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import start.entities.Lessons;
import start.service.LessonsService;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonsController {

    private final LessonsService lessonsService;

    @GetMapping("/{id}")
    public Lessons getLessonById(@PathVariable Long id) {
        return lessonsService.getLessonById(id);
    }

    @GetMapping
    public List<Lessons> getAllLessons() {
        return lessonsService.getAllLessons();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createLesson(@RequestBody Lessons lesson) {
        lessonsService.createLesson(lesson);
    }

    @PutMapping("/{id}")
    public void updateLesson(@PathVariable Long id, @RequestBody Lessons lesson) {
        lesson.setId(id);
        lessonsService.updateLesson(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonsService.deleteLesson(id);
    }

    @PostMapping("/{lessonId}/courses/{courseId}")
    public void assignLessonToCourse(@PathVariable Long lessonId, @PathVariable Long courseId) {
        lessonsService.assignLessonToCourse(lessonId, courseId);
    }
}
