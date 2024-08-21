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

    // Getters and setters
}
