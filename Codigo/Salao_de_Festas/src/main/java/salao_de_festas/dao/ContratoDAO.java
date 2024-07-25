package salao_de_festas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import salao_de_festas.entity.Contrato;

import java.util.List;

/**
 * DAO para a entidade Contrato.
 */
public class ContratoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("salao_de_festas");

    public void save(Contrato contrato) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(contrato);
        em.getTransaction().commit();
        em.close();
    }

    public Contrato findById(int id) {
        EntityManager em = emf.createEntityManager();
        Contrato contrato = em.find(Contrato.class, id);
        em.close();
        return contrato;
    }

    public List<Contrato> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Contrato> contratos = em.createQuery("FROM Contrato", Contrato.class).getResultList();
        em.close();
        return contratos;
    }

    public void update(Contrato contrato) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(contrato);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Contrato contrato = em.find(Contrato.class, id);
        if (contrato != null) {
            em.remove(contrato);
        }
        em.getTransaction().commit();
        em.close();
    }
}
