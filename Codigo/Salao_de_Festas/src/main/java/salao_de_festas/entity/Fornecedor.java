package salao_de_festas.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Entidade Fornecedor que representa a tabela FORNECEDOR no banco de dados.
 */
@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor implements Serializable {

    // Identificador único do fornecedor, gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    // Nome do fornecedor, campo obrigatório.
    @Column(name = "nome", nullable = false)
    private String nome;

    // Telefone do fornecedor, campo opcional.
    @Column(name = "telefone")
    private String telefone;

    // Produto fornecido pelo fornecedor, campo opcional.
    @Column(name = "produto_fornecido")
    private String produtoFornecido;

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

    public String getProdutoFornecido() {
        return produtoFornecido;
    }

    public void setProdutoFornecido(String produtoFornecido) {
        this.produtoFornecido = produtoFornecido;
    }
}
