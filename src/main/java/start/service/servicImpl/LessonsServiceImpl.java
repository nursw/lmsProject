package start.service.servicImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.entities.Courses;
import start.entities.Lessons;
import start.repo.CoursesRepo;
import start.repo.LessonsRepo;
import start.service.LessonsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonsServiceImpl implements LessonsService {
    private final LessonsRepo lessonsRepo;
    private final CoursesRepo coursesRepo;

    @Override
    public Lessons getLessonById(Long id) {
        return lessonsRepo.findById(id);
    }

    @Override
    public List<Lessons> getAllLessons() {
        return lessonsRepo.findAll();
    }

    @Override
    public void createLesson(Lessons lesson) {
        lessonsRepo.save(lesson);
    }

    @Override
    public void updateLesson(Lessons lesson) {
        lessonsRepo.update(lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonsRepo.delete(id);
    }

    @Override
    public void assignLessonToCourse(Long lessonId, Long courseId) {
        Lessons lesson = lessonsRepo.findById(lessonId);
        Courses course = coursesRepo.findById(courseId); // Получить курс по ID
        if (lesson != null && course != null) {
            lesson.setCourse(course);
            lessonsRepo.update(lesson);
        }
    }
}
