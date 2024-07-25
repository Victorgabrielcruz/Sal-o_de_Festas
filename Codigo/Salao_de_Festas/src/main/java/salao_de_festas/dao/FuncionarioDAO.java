package salao_de_festas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import salao_de_festas.entity.Funcionario;

import java.util.List;

/**
 * DAO para a entidade Funcionario.
 */
public class FuncionarioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("salao_de_festas");

    public void save(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public Funcionario findById(int id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    public List<Funcionario> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery("FROM Funcionario", Funcionario.class).getResultList();
        em.close();
        return funcionarios;
    }

    public void update(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.remove(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }
}
