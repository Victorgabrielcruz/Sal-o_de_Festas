package Salao_de_festas.Salao_de_festas.modells.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "administrator", nullable = false)
    private Administrator administrator;

    @Column(name = "lessee_name", nullable = false)
    private String lesseeName;

    @Column(name = "lessor_name", nullable = false)
    private String lessorName;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @ManyToMany
    @JoinTable(
            name = "Party_Employees",
            joinColumns = @JoinColumn(name = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    @Column(name = "status", nullable = false)
    private String status;

    /**
     * Constructs a new Party instance with the specified details.
     *
     * @param contract the contract related to the party
     * @param client the client associated with the party
     * @param administrator the administrator managing the party
     * @param lesseeName the name of the lessee (tenant)
     * @param lessorName the name of the lessor (owner)
     * @param startDate the start date of the party
     * @param endDate the end date of the party
     * @param startTime the start time of the party
     * @param endTime the end time of the party
     * @param employees the list of employees working at the party
     * @param status the status of the party
     * @throws IllegalArgumentException if any of the provided arguments are
     * invalid
     */
    public Party(Contract contract, Client client, Administrator administrator, String lesseeName, String lessorName,
            Date startDate, Date endDate, Date startTime, Date endTime, List<Employee> employees, String status) {

        validarDados(contract, client, administrator, lesseeName, lessorName, startDate, endDate, startTime, endTime, employees, status);

        this.contract = contract;
        this.client = client;
        this.administrator = administrator;
        this.lesseeName = lesseeName;
        this.lessorName = lessorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employees = employees;
        this.status = status;
    }

    /**
     * Validates the provided data.
     *
     * @param contract the contract related to the party
     * @param client the client associated with the party
     * @param administrator the administrator managing the party
     * @param lesseeName the name of the lessee (tenant)
     * @param lessorName the name of the lessor (owner)
     * @param startDate the start date of the party
     * @param endDate the end date of the party
     * @param startTime the start time of the party
     * @param endTime the end time of the party
     * @param employees the list of employees working at the party
     * @param status the status of the party
     * @throws IllegalArgumentException if any data is invalid
     */
    private void validarDados(Contract contract, Client client, Administrator administrator, String lesseeName,
            String lessorName, Date startDate, Date endDate, Date startTime, Date endTime,
            List<Employee> employees, String status) {

        if (contract == null) {
            throw new IllegalArgumentException("Contract cannot be null");
        }
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        if (administrator == null) {
            throw new IllegalArgumentException("Administrator cannot be null");
        }
        if (lesseeName == null || lesseeName.isEmpty()) {
            throw new IllegalArgumentException("Lessee name cannot be null or empty");
        }
        if (lessorName == null || lessorName.isEmpty()) {
            throw new IllegalArgumentException("Lessor name cannot be null or empty");
        }
        if (startDate == null || endDate == null || startDate.after(endDate)) {
            throw new IllegalArgumentException("Invalid start or end date");
        }
        if (startTime == null || endTime == null || startTime.after(endTime)) {
            throw new IllegalArgumentException("Invalid start or end time");
        }
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employees list cannot be null or empty");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public Contract getContract() {
        return contract;
    }

    public Client getClient() {
        return client;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public String getLesseeName() {
        return lesseeName;
    }

    public String getLessorName() {
        return lessorName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getStatus() {
        return status;
    }
}
