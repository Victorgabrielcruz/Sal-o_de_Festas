package Salao_de_festas.Salao_de_festas.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Salao_de_festas.Salao_de_festas.modells.entities.Administrator;
import Salao_de_festas.Salao_de_festas.modells.services.AdministratorService;

/**
 * REST controller for managing {@link Administrator} entities.
 * <p>
 * This controller provides endpoints for creating, retrieving, listing,
 * deleting, and authenticating Administrators.
 * </p>
 */
@RestController
@RequestMapping("/api/Administrator")
public class ControllersAdministrator {

    @Autowired
    private AdministratorService administratorService;

    /**
     * Creates a new Administrator.
     *
     * @param administrator the Administrator entity to be created
     * @return a ResponseEntity containing the created Administrator
     */
    @PostMapping
    public ResponseEntity<Administrator> criarAdministrador(@RequestBody Administrator administrator) {
        Administrator savedAdministrator = administratorService.salvarAdministrador(administrator);
        return ResponseEntity.ok(savedAdministrator);
    }

    /**
     * Retrieves an Administrator by their ID.
     *
     * @param id the ID of the Administrator to retrieve
     * @return a ResponseEntity containing the found Administrator, or 404 Not
     * Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Administrator> buscarAdministradorPorId(@PathVariable int id) {
        Optional<Administrator> administrator = administratorService.buscarPorId(id);
        return administrator.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Lists all Administrators.
     *
     * @return a ResponseEntity containing an Iterable of all Administrators
     */
    @GetMapping
    public ResponseEntity<Iterable<Administrator>> listarAdministradores() {
        Iterable<Administrator> administradores = administratorService.listarAdministradores();
        return ResponseEntity.ok(administradores);
    }

    /**
     * Deletes an Administrator by their ID.
     *
     * @param id the ID of the Administrator to delete
     * @return a ResponseEntity with HTTP status 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdministrador(@PathVariable int id) {
        administratorService.deletarAdministrador(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Authenticates an Administrator using their CNPJ and password.
     *
     * @param cnpj the CNPJ of the Administrator
     * @param password the password of the Administrator
     * @return a ResponseEntity containing the authenticated Administrator, or
     * 401 Unauthorized if authentication fails
     */
    @PostMapping("/login")
    public ResponseEntity<Administrator> login(@RequestParam String cnpj, @RequestParam String password) {
        Optional<Administrator> administrator = administratorService.login(cnpj, password);
        return administrator.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
