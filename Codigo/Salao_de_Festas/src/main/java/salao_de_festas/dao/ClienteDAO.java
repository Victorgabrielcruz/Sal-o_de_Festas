package salao_de_festas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import salao_de_festas.entity.Cliente;

import java.util.List;

public class ClienteDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("salao_de_festas");

    public void save(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cliente findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Cliente> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cliente existingCliente = em.find(Cliente.class, cliente.getCodigo());
            if (existingCliente != null) {
                em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cliente findByEmailAndPassword(String email, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email AND c.password = :password", Cliente.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // Nenhum cliente encontrado com as credenciais fornecidas
        } finally {
            em.close();
        }
    }
    public Cliente findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
                     .setParameter("email", email)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }   



    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}