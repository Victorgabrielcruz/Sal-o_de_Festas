package salao_de_festas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import salao_de_festas.entity.Fornecedor;

import java.util.List;

/**
 * DAO para a entidade Fornecedor.
 */
public class FornecedorDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("salao_de_festas");

    public void save(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public Fornecedor findById(int id) {
        EntityManager em = emf.createEntityManager();
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        em.close();
        return fornecedor;
    }

    public List<Fornecedor> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Fornecedor> fornecedores = em.createQuery("FROM Fornecedor", Fornecedor.class).getResultList();
        em.close();
        return fornecedores;
    }

    public void update(Fornecedor fornecedor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        if (fornecedor != null) {
            em.remove(fornecedor);
        }
        em.getTransaction().commit();
        em.close();
    }
}
