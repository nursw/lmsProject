package start.service;



import start.entities.Lessons;

import java.util.List;

public interface LessonsService {
    Lessons getLessonById(Long id);
    List<Lessons> getAllLessons();
    void createLesson(Lessons lesson);
    void updateLesson(Lessons lesson);
    void deleteLesson(Long id);
    void assignLessonToCourse(Long lessonId, Long courseId);
}
