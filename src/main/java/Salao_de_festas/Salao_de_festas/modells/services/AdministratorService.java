package Salao_de_festas.Salao_de_festas.modells.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Salao_de_festas.Salao_de_festas.modells.entities.Administrator;
import Salao_de_festas.Salao_de_festas.modells.repositories.RepositoryAdministrator;

@Service
public class AdministratorService {

    @Autowired
    private RepositoryAdministrator administratorRepository;

    public Administrator salvarAdministrador(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Iterable<Administrator> listarAdministradores() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> buscarPorId(int id) {
        return administratorRepository.findById(id);
    }

    public Administrator buscarPorCNPJ(String cnpj) {
        return administratorRepository.findByCnpj(cnpj);
    }

    public Administrator buscarPorNome(String nome) {
        return administratorRepository.findByName(nome);
    }

    public void deletarAdministrador(int id) {
        administratorRepository.deleteById(id);
    }

    public Optional<Administrator> login(String cnpj, String password) {
        Administrator administrator = administratorRepository.findByCnpjAndPassword(cnpj, password);
        return Optional.ofNullable(administrator);
    }
}
