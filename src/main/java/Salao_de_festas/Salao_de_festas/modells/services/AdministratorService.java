package Salao_de_festas.Salao_de_festas.modells.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Salao_de_festas.Salao_de_festas.modells.entities.Administrator;
import Salao_de_festas.Salao_de_festas.modells.repositories.RepositoryAdministrator;

/**
 * Service class for managing operations related to {@link Administrator}
 * entities.
 * <p>
 * This service provides methods for saving, listing, searching, and deleting
 * Administrators, as well as handling login functionality.
 * </p>
 */
@Service
public class AdministratorService {

    @Autowired
    private RepositoryAdministrator administratorRepository;

    /**
     * Saves a new or existing Administrator in the repository.
     *
     * @param administrator the Administrator entity to be saved
     * @return the saved Administrator entity
     */
    public Administrator salvarAdministrador(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    /**
     * Retrieves all Administrators from the repository.
     *
     * @return an Iterable of all Administrator entities
     */
    public Iterable<Administrator> listarAdministradores() {
        return administratorRepository.findAll();
    }

    /**
     * Searches for an Administrator by their ID.
     *
     * @param id the ID of the Administrator
     * @return an Optional containing the found Administrator, or empty if not
     * found
     */
    public Optional<Administrator> buscarPorId(int id) {
        return administratorRepository.findById(id);
    }

    /**
     * Searches for an Administrator by their CNPJ.
     *
     * @param cnpj the CNPJ of the Administrator
     * @return the Administrator entity with the specified CNPJ, or null if not
     * found
     */
    public Administrator buscarPorCNPJ(String cnpj) {
        return administratorRepository.findByCnpj(cnpj);
    }

    /**
     * Searches for an Administrator by their name.
     *
     * @param nome the name of the Administrator
     * @return the Administrator entity with the specified name, or null if not
     * found
     */
    public Administrator buscarPorNome(String nome) {
        return administratorRepository.findByName(nome);
    }

    /**
     * Deletes an Administrator from the repository by their ID.
     *
     * @param id the ID of the Administrator to be deleted
     */
    public void deletarAdministrador(int id) {
        administratorRepository.deleteById(id);
    }

    /**
     * Authenticates an Administrator by their CNPJ and password.
     *
     * @param cnpj the CNPJ of the Administrator
     * @param password the password of the Administrator
     * @return an Optional containing the authenticated Administrator, or empty
     * if authentication fails
     */
    public Optional<Administrator> login(String cnpj, String password) {
        Administrator administrator = administratorRepository.findByCnpjAndPassword(cnpj, password);
        return Optional.ofNullable(administrator);
    }
}
