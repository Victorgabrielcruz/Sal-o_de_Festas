package Salao_de_festas.Salao_de_festas.modells.repositories;

import org.springframework.data.repository.CrudRepository;
import Salao_de_festas.Salao_de_festas.modells.entities.Contract;

public interface RepositoryContract extends CrudRepository <Contract , Integer> {
    
}
