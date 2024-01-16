package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    // create
    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    // read
    public List<Team> findAll() {
        return em.createQuery("select t From Team t", Team.class).getResultList();
    }

    public Optional<Team> findById(Long id) {
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }

    // count
    public long count() {
        return em.createQuery("select count(t) From Team t", Long.class).getSingleResult();
    }

    // delete
    public void delete(Team team) {
        em.remove(team);
    }
}
