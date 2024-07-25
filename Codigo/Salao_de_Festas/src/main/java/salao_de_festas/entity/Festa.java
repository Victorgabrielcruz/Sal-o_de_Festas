package salao_de_festas.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Entidade Festa que representa a tabela FESTA no banco de dados.
 */
@Entity
@Table(name = "FESTA")
public class Festa implements Serializable {

    // Identificador único da festa, gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoFesta;

    // Quantidade de convidados da festa, campo obrigatório.
    @Column(name = "quantidade_convidados", nullable = false)
    private int quantidadeConvidados;

    // Data da festa, campo obrigatório.
    @Column(name = "data", nullable = false)
    private Date data;

    // Dia da semana da festa, campo obrigatório.
    @Column(name = "dia_da_semana", nullable = false)
    @Enumerated(EnumType.STRING)
    private DiaSemana diaDaSemana;

    // Horário de início da festa, campo obrigatório.
    @Column(name = "horario_inicio", nullable = false)
    private Time horarioInicio;

    // Horário de fim da festa, campo obrigatório.
    @Column(name = "horario_fim", nullable = false)
    private Time horarioFim;

    // Tema da festa, campo opcional.
    @Column(name = "tema")
    private String tema;

    // Cliente associado à festa.
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente cliente;

    // Enumeração para os dias da semana.
    public enum DiaSemana {
        Segunda, Terça, Quarta, Quinta, Sexta, Sábado, Domingo
    }

    // Getters e Setters
    public int getCodigoFesta() {
        return codigoFesta;
    }

    public void setCodigoFesta(int codigoFesta) {
        this.codigoFesta = codigoFesta;
    }

    public int getQuantidadeConvidados() {
        return quantidadeConvidados;
    }

    public void setQuantidadeConvidados(int quantidadeConvidados) {
        this.quantidadeConvidados = quantidadeConvidados;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DiaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
