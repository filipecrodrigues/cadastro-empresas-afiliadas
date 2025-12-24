package com.filipecrodrigues.cadastro.entities;

// Importa as anotações do JPA (Jakarta Persistence)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica que esta classe é uma ENTIDADE JPA
// Ou seja, será mapeada para uma tabela no banco de dados
@Entity

// Define explicitamente o nome da tabela no banco
@Table(name = "empresas")
public class Empresa {

    // Define a chave primária da tabela
    @Id

    // Indica que o ID será gerado automaticamente pelo banco
    // IDENTITY = auto incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // CNPJ da empresa (String para preservar zeros e formatação)
    private String cnpj;

    // Razão social da empresa
    private String razaoSocial;

    // Nome fantasia da empresa
    private String nomeFantasia;

    // Atividade econômica da empresa
    private String atividadeEconomica;

    // Endereço da empresa
    private String endereco;

    // Telefone de contato
    private String telefone;

    // Construtor sem argumentos
    // Obrigatório para o JPA
    public Empresa() {
    }

    // Construtor com argumentos
    public Empresa(String cnpj, String razaoSocial, String nomeFantasia,
                   String atividadeEconomica, String endereco, String telefone) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.atividadeEconomica = atividadeEconomica;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getter e Setter do ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter do CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Getter e Setter da Razão Social
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    // Getter e Setter do Nome Fantasia
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    // Getter e Setter da Atividade Econômica
    public String getAtividadeEconomica() {
        return atividadeEconomica;
    }

    public void setAtividadeEconomica(String atividadeEconomica) {
        this.atividadeEconomica = atividadeEconomica;
    }

    // Getter e Setter do Endereço
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter e Setter do Telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
