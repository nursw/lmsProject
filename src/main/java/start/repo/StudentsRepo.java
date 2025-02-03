package start.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import start.entities.Students;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentsRepo {

    private final EntityManager em;

    public Students findById(Long id) {
        return em.find(Students.class, id);
    }

    public List<Students> findAll() {
        TypedQuery<Students> query = em.createQuery("SELECT s FROM Students s", Students.class);
        return query.getResultList();
    }

    public void save(Students student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
    }

    public void update(Students student) {
        em.merge(student);
    }

    public void delete(Long id) {
        Students student = findById(id);
        if (student != null) {
            em.remove(student);
        }
    }
}
