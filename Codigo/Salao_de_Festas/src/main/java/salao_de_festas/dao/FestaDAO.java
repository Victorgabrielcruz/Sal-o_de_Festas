package salao_de_festas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import salao_de_festas.entity.Festa;

import java.util.List;

/**
 * DAO para a entidade Festa.
 */
public class FestaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("salao_de_festas");

    public void save(Festa festa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(festa);
        em.getTransaction().commit();
        em.close();
    }

    public Festa findById(int id) {
        EntityManager em = emf.createEntityManager();
        Festa festa = em.find(Festa.class, id);
        em.close();
        return festa;
    }

    public List<Festa> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Festa> festas = em.createQuery("FROM Festa", Festa.class).getResultList();
        em.close();
        return festas;
    }

    public void update(Festa festa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(festa);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Festa festa = em.find(Festa.class, id);
        if (festa != null) {
            em.remove(festa);
        }
        em.getTransaction().commit();
        em.close();
    }
}
