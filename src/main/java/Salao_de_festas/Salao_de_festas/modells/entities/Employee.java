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

    /**
     * Constructs a new Employee instance with the specified details.
     *
     * @param name the name of the employee
     * @param role the role of the employee
     * @param cpf the CPF of the employee
     * @param rg the RG of the employee
     * @param salary the salary of the employee
     * @param hourlyRate the hourly rate of the employee
     * @throws IllegalArgumentException if any of the provided arguments are
     * invalid
     */
    public Employee(String name, String role, String cpf, String rg, double salary, double hourlyRate) {
        validarDados(name, role, cpf, rg, salary, hourlyRate);

        this.name = name;
        this.role = role;
        this.cpf = cpf;
        this.rg = rg;
        this.salary = salary;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Validates the provided data.
     *
     * @param name the name of the employee
     * @param role the role of the employee
     * @param cpf the CPF of the employee
     * @param rg the RG of the employee
     * @param salary the salary of the employee
     * @param hourlyRate the hourly rate of the employee
     * @throws IllegalArgumentException if any data is invalid
     */
    private void validarDados(String name, String role, String cpf, String rg, double salary, double hourlyRate) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        if (cpf == null || cpf.isEmpty() || cpf.length() != 11) {
            throw new IllegalArgumentException("Invalid CPF: must have exactly 11 digits");
        }
        if (rg == null || rg.isEmpty() || rg.length() < 7 || rg.length() > 14) {
            throw new IllegalArgumentException("Invalid RG: must have between 7 and 14 characters");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero");
        }
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate must be greater than zero");
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public double getSalary() {
        return salary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public List<Party> getParties() {
        return parties;
    }
}
