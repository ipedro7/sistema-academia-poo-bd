package model.entities;

/**
 * Classe abstrata responsável por representar uma pessoa no sistema,
 * contendo informações básicas como CPF, nome, telefone e e-mail.
 * Serve como base para outras entidades como Aluno e Instrutor.
 */
public abstract class Pessoa {
    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    /**
     * Retorna o CPF da pessoa.
     *
     * @return CPF da pessoa
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cpf CPF da pessoa
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone da pessoa.
     *
     * @return telefone da pessoa
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     *
     * @param telefone telefone da pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o e-mail da pessoa.
     *
     * @return e-mail da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail da pessoa.
     *
     * @param email e-mail da pessoa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses
     * para exibir os dados da pessoa.
     *
     * @return dados da pessoa em formato textual
     */
    public abstract String mostrarDados();
}