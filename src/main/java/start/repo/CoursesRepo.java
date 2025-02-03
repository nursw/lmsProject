package start.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import start.entities.Courses;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class CoursesRepo {

    private final EntityManager em;

    public Courses findById(Long id) {
        return em.find(Courses.class, id);
    }

    public List<Courses> findAll() {
        TypedQuery<Courses> query = em.createQuery("SELECT c FROM Courses c", Courses.class);
        return query.getResultList();
    }

    public void save(Courses course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
    }

    public void update(Courses course) {
        em.merge(course);
    }

    public void delete(Long id) {
        Courses course = findById(id);
        if (course != null) {
            em.remove(course);
        }
    }
}
