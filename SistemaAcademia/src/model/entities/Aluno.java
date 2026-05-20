package model.entities;

import java.time.LocalDate;

/**
 * Classe responsável por representar a entidade Aluno no sistema de academia.
 *
 * @author Pedro
 */
public class Aluno extends Pessoa {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String email;
    private String telefone;
    private Plano plano;

    public Aluno() {
    }

    public Aluno(String cpf, String nome, LocalDate dataNascimento, String cep,
                 String email, String telefone, Plano plano) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }

    /**
     * Retorna o CPF do aluno.
     *
     * @return CPF do aluno
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do aluno.
     *
     * @param cpf CPF do aluno
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o nome do aluno.
     *
     * @return nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     *
     * @param nome nome do aluno
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a data de nascimento do aluno.
     *
     * @return data de nascimento do aluno
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento do aluno.
     *
     * @param dataNascimento data de nascimento do aluno
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna o CEP do aluno.
     *
     * @return CEP do aluno
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o CEP do aluno.
     *
     * @param cep CEP do aluno
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna o e-mail do aluno.
     *
     * @return e-mail do aluno
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do aluno.
     *
     * @param email e-mail do aluno
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o telefone do aluno.
     *
     * @return telefone do aluno
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do aluno.
     *
     * @param telefone telefone do aluno
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o plano associado ao aluno.
     *
     * @return plano do aluno
     */
    public Plano getPlano() {
        return plano;
    }

    /**
     * Define o plano associado ao aluno.
     *
     * @param plano plano do aluno
     */
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    /**
     * Retorna os dados principais do aluno em formato textual.
     *
     * @return dados do aluno
     */
    @Override
    public String mostrarDados() {
        return "Aluno | Nome : " + getNome() + " | Telefone : " + getTelefone() + " | Email : " + getEmail()
                + " | Data de Nascimento : " + this.dataNascimento + " | CEP : " + this.cep
                + " | Plano : " + (this.plano != null ? this.plano.getNome() : "Sem plano");
    }
}