package Salao_de_festas.Salao_de_festas.modells.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "hourly_rate", nullable = false)
    private double hourlyRate;

    @ManyToMany(mappedBy = "employees")
    private List<Party> parties;

    // Getters and setters
}
