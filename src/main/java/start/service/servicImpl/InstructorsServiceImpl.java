package start.service.servicImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.entities.Courses;
import start.entities.Instructors;
import start.repo.InstructorsRepo;
import start.service.InstructorsService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InstructorsServiceImpl implements InstructorsService {
    private final InstructorsRepo instructorsRepo;
    @Override
    public Instructors getInstructorById(Long id) {
        return instructorsRepo.findById(id);
    }

    @Override
    public List<Instructors> getAllInstructors() {
        return instructorsRepo.findAll();
    }

    @Override
    public void createInstructor(Instructors instructor) {
        instructorsRepo.save(instructor);
    }

    @Override
    public void updateInstructor(Instructors instructor) {
        instructorsRepo.update(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorsRepo.delete(id);
    }

    @Override
    public List<Courses> getInstructorCourses(Long instructorId) {
        Instructors instructor = instructorsRepo.findById(instructorId);
        return instructor != null ? instructor.getCourses() : null;
    }
}
