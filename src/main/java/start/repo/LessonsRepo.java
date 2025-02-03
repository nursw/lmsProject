package start.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import start.entities.Lessons;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonsRepo {
    private final EntityManager em;

    public Lessons findById(Long id) {
        return em.find(Lessons.class, id);
    }

    public List<Lessons> findAll() {
        TypedQuery<Lessons> query = em.createQuery("SELECT l FROM Lessons l", Lessons.class);
        return query.getResultList();
    }

    public void save(Lessons lesson) {
        if (lesson.getId() == null) {
            em.persist(lesson);
        } else {
            em.merge(lesson);
        }
    }

    public void update(Lessons lesson) {
        em.merge(lesson);
    }

    public void delete(Long id) {
        Lessons lesson = findById(id);
        if (lesson != null) {
            em.remove(lesson);
        }
    }
}
