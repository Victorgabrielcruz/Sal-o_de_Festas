package salao_de_festas.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Entidade Cliente que representa a tabela CLIENTE no banco de dados.
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    // Identificador único do cliente, gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private int codigo;

    // Nome do cliente, campo obrigatório.
    @Column(name = "nome", nullable = false)
    private String nome;

    // Endereço do cliente, campo opcional.
    @Column(name = "endereco")
    private String endereco;

    // Telefone do cliente, campo opcional.
    @Column(name = "telefone")
    private String telefone;

    // Data de nascimento do cliente, campo opcional.
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name  = "password")
    private String password;
    
    @Column (name = "email")
    private String email;

    // Getters e Setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
