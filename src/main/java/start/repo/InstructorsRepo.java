package start.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import start.entities.Instructors;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class InstructorsRepo {

    private final EntityManager em;

    public Instructors findById(Long id) {
        return em.find(Instructors.class, id);
    }

    public List<Instructors> findAll() {
        TypedQuery<Instructors> query = em.createQuery("SELECT i FROM Instructors i", Instructors.class);
        return query.getResultList();
    }

    public void save(Instructors instructor) {
        if (instructor.getId() == null) {
            em.persist(instructor);
        } else {
            em.merge(instructor);
        }
    }

    public void update(Instructors instructor) {
        em.merge(instructor);
    }

    public void delete(Long id) {
        Instructors instructor = findById(id);
        if (instructor != null) {
            em.remove(instructor);
        }
    }
}