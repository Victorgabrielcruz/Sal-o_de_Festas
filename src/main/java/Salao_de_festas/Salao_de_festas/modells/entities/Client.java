package Salao_de_festas.Salao_de_festas.modells.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "cpf", length = 100, nullable = false)
    private String cpf;

    @Column(name = "rg", length = 100, nullable = false)
    private String rg;

    @Column(name = "phone", length = 100, nullable = false)
    private String phone;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    // Getters and setters
}
