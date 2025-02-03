package start.service.servicImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.entities.Courses;
import start.entities.Students;
import start.repo.StudentsRepo;
import start.service.StudentsService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepo studentsRepo;

    @Override
    public Students getStudentById(Long id) {
        return studentsRepo.findById(id);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepo.findAll();
    }

    @Override
    public void createStudent(Students student) {
        studentsRepo.save(student);
    }

    @Override
    public void updateStudent(Students student) {
        studentsRepo.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentsRepo.delete(id);
    }

    @Override
    public List<Courses> getStudentCourses(Long studentId) {
        Students student = studentsRepo.findById(studentId);
        return student != null ? student.getCourses() : null;
    }
}

