package Salao_de_festas.Salao_de_festas.modells.repositories;

import org.springframework.data.repository.CrudRepository;

import Salao_de_festas.Salao_de_festas.modells.entities.Administrator;

/**
 * Repository interface for performing CRUD operations on {@link Administrator}
 * entities.
 * <p>
 * This interface extends the {@link CrudRepository} interface provided by
 * Spring Data JPA, which provides generic CRUD operation methods. Additional
 * query methods are defined to find {@link Administrator} entities based on
 * specific attributes.
 * </p>
 */
public interface RepositoryAdministrator extends CrudRepository<Administrator, Integer> {

    /**
     * Finds an {@link Administrator} by their name.
     *
     * @param name the name of the Administrator
     * @return the Administrator entity with the specified name, or null if no
     * Administrator is found
     */
    Administrator findByName(String name);

    /**
     * Finds an {@link Administrator} by their CNPJ.
     *
     * @param cnpj the CNPJ of the Administrator
     * @return the Administrator entity with the specified CNPJ, or null if no
     * Administrator is found
     */
    Administrator findByCnpj(String cnpj);

    /**
     * Finds an {@link Administrator} by their CNPJ and password.
     *
     * @param cnpj the CNPJ of the Administrator
     * @param password the password of the Administrator
     * @return the Administrator entity with the specified CNPJ and password, or
     * null if no Administrator is found
     */
    Administrator findByCnpjAndPassword(String cnpj, String password);
}
