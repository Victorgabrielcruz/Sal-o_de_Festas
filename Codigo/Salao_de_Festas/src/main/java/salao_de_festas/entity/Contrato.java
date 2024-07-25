package salao_de_festas.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Entidade Contrato que representa a tabela CONTRATO no banco de dados.
 */
@Entity
@Table(name = "CONTRATO")
public class Contrato implements Serializable {

    // Identificador único do contrato, gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroContrato;

    // Valor total do contrato.
    @Column(name = "valor_total")
    private double valorTotal;

    // Desconto aplicado no contrato.
    @Column(name = "desconto")
    private double desconto;

    // Valor final do contrato após desconto.
    @Column(name = "valor_final")
    private double valorFinal;

    // Forma de pagamento do contrato.
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    // Status do contrato.
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    // Festa associada ao contrato.
    @ManyToOne
    @JoinColumn(name = "codigo_festa", nullable = false)
    private Festa festa;

    // Enumeração para as formas de pagamento.
    public enum FormaPagamento {
        Pix, Cartão_2x, Cartão_3x, Cartão_4x
    }

    // Enumeração para os status do contrato.
    public enum Status {
        A_PAGAR, PAGO, CANCELADO
    }

    // Getters e Setters
    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Festa getFesta() {
        return festa;
    }

    public void setFesta(Festa festa) {
        this.festa = festa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
