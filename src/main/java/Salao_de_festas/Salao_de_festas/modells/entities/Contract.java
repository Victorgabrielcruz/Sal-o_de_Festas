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

    // Getters and setters
}
