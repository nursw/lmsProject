package start.service.servicImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.entities.Courses;
import start.entities.Instructors;
import start.entities.Students;
import start.repo.CoursesRepo;
import start.repo.StudentsRepo;
import start.service.CoursesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepo coursesRepo;
    private final StudentsRepo studentsRepo;

    @Override
    public Courses getCourseById(Long id) {
        return coursesRepo.findById(id);
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    @Override
    public void createCourse(Courses course) {
        coursesRepo.save(course);
    }

    @Override
    public void updateCourse(Courses course) {
        coursesRepo.update(course);
    }

    @Override
    public void deleteCourse(Long id) {
        coursesRepo.delete(id);
    }

    @Override
    public void assignInstructor(Long courseId, Instructors instructor) {
        Courses course = coursesRepo.findById(courseId);
        if (course != null) {
            course.setInstructor(instructor);
            coursesRepo.update(course);
        }
    }

    @Override
    public void addStudentToCourse(Long courseId, Students student) {
        Courses course = coursesRepo.findById(courseId);
        if (course != null) {
            course.getStudents().add(student);
            student.getCourses().add(course); // Добавить обратную связь
            coursesRepo.update(course);
            studentsRepo.update(student); // Обновить студента
        }
    }

    @Override
    public void getCourseDetails(Long courseId) {
        Courses course = coursesRepo.findById(courseId);
        if (course != null) {
            System.out.println("Курс: " + course.getTitle());
            System.out.println("Студенты:");
            course.getStudents().forEach(student ->
                    System.out.println(student.getFirst_name() + " " + student.getLast_name())
            );
            System.out.println("Уроки:");
            course.getLessonsList().forEach(lesson ->
                    System.out.println(lesson.getTitle() + " - " + lesson.getPublisher_date())
            );
        }
    }
}

