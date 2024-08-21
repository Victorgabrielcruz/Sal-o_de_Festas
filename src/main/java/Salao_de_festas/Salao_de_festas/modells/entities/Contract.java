package Salao_de_festas.Salao_de_festas.modells.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    @ElementCollection
    @CollectionTable(name = "Contract_Employees", joinColumns = @JoinColumn(name = "contract_id"))
    @Column(name = "employee_id")
    private List<Integer> employeeIds;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "administrator", nullable = false)
    private Administrator administrator;

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

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    /**
     * Constructs a new Contract instance with the specified details.
     *
     * @param party the party associated with the contract
     * @param employeeIds the list of employee IDs associated with the contract
     * @param client the client associated with the contract
     * @param administrator the administrator managing the contract
     * @param startDate the start date of the contract
     * @param endDate the end date of the contract
     * @param startTime the start time of the contract
     * @param endTime the end time of the contract
     * @param totalAmount the total amount of the contract
     * @throws IllegalArgumentException if any of the provided arguments are
     * invalid
     */
    public Contract(Party party, List<Integer> employeeIds, Client client, Administrator administrator,
            Date startDate, Date endDate, Date startTime, Date endTime, double totalAmount) {

        validarDados(party, employeeIds, client, administrator, startDate, endDate, startTime, endTime, totalAmount);

        this.party = party;
        this.employeeIds = employeeIds;
        this.client = client;
        this.administrator = administrator;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalAmount = totalAmount;
    }

    /**
     * Validates the provided data.
     *
     * @param party the party associated with the contract
     * @param employeeIds the list of employee IDs
     * @param client the client associated with the contract
     * @param administrator the administrator managing the contract
     * @param startDate the start date of the contract
     * @param endDate the end date of the contract
     * @param startTime the start time of the contract
     * @param endTime the end time of the contract
     * @param totalAmount the total amount of the contract
     * @throws IllegalArgumentException if any data is invalid
     */
    private void validarDados(Party party, List<Integer> employeeIds, Client client, Administrator administrator,
            Date startDate, Date endDate, Date startTime, Date endTime, double totalAmount) {
        if (party == null) {
            throw new IllegalArgumentException("Party cannot be null");
        }
        if (employeeIds == null || employeeIds.isEmpty()) {
            throw new IllegalArgumentException("Employee IDs list cannot be null or empty");
        }
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        if (administrator == null) {
            throw new IllegalArgumentException("Administrator cannot be null");
        }
        if (startDate == null || endDate == null || startTime == null || endTime == null) {
            throw new IllegalArgumentException("Date and time fields cannot be null");
        }
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        if (endTime.before(startTime)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero");
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public Party getParty() {
        return party;
    }

    public List<Integer> getEmployeeIds() {
        return employeeIds;
    }

    public Client getClient() {
        return client;
    }

    public Administrator getAdministrator() {
        return administrator;
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

    public double getTotalAmount() {
        return totalAmount;
    }
}
