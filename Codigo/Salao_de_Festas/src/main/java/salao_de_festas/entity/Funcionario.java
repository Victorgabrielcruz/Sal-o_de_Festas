package salao_de_festas.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Entidade Funcionario que representa a tabela FUNCIONARIO no banco de dados.
 */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

    // Identificador único do funcionário, gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    // Nome do funcionário, campo obrigatório.
    @Column(name = "nome", nullable = false)
    private String nome;

    // Telefone do funcionário, campo opcional.
    @Column(name = "telefone")
    private String telefone;

    // Função do funcionário, campo opcional.
    @Column(name = "funcao")
    private String funcao;

    // Salário do funcionário, campo opcional.
    @Column(name = "salario")
    private double salario;

    // Tipo do funcionário (temporário ou fixo), campo obrigatório.
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoFuncionario tipo;

    // Enumeração para os tipos de funcionário.
    public enum TipoFuncionario {
        TEMPORARIO,
        FIXO
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }
}
