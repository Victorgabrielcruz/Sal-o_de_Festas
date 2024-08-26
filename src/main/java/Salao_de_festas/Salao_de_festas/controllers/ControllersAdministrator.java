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

@RestController
@RequestMapping("/api/Administrator")
public class ControllersAdministrator {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping
    public ResponseEntity<Administrator> criarAdministrador(@RequestBody Administrator administrator) {
        Administrator savedAdministrator = administratorService.salvarAdministrador(administrator);
        return ResponseEntity.ok(savedAdministrator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> buscarAdministradorPorId(@PathVariable int id) {
        Optional<Administrator> administrator = administratorService.buscarPorId(id);
        return administrator.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Administrator>> listarAdministradores() {
        Iterable<Administrator> administradores = administratorService.listarAdministradores();
        return ResponseEntity.ok(administradores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdministrador(@PathVariable int id) {
        administratorService.deletarAdministrador(id);
        return ResponseEntity.noContent().build();
    }

    // Método de login
    @PostMapping("/login")
    public ResponseEntity<Administrator> login(@RequestParam String cnpj, @RequestParam String password) {
        Optional<Administrator> administrator = administratorService.login(cnpj, password);
        return administrator.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
