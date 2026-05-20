package model.entities;

import java.math.BigDecimal;

/**
 * Classe responsável por representar a entidade Instrutor no sistema de academia,
 * contendo informações pessoais, especialidade, salário e horário de trabalho.
 *
 * @author Pedro
 */
public class Instrutor extends Pessoa {

    private Integer idFuncionario;
    private String cpf;
    private String nome;
    private String telefone;
    private String cep;
    private String email;
    private String especialidade;
    private BigDecimal salario;
    private String horarioTrabalho;

    public Instrutor() {
    }

    public Instrutor(Integer idFuncionario, String cpf, String nome, String telefone, String cep,
                     String email, String especialidade, BigDecimal salario, String horarioTrabalho) {
        this.idFuncionario = idFuncionario;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.cep = cep;
        this.email = email;
        this.especialidade = especialidade;
        this.salario = salario;
        this.horarioTrabalho = horarioTrabalho;
    }

    /**
     * Retorna o identificador do instrutor.
     *
     * @return id do instrutor
     */
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Define o identificador do instrutor.
     *
     * @param idFuncionario id do instrutor
     */
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * Retorna o CPF do instrutor.
     *
     * @return CPF do instrutor
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do instrutor.
     *
     * @param cpf CPF do instrutor
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o nome do instrutor.
     *
     * @return nome do instrutor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do instrutor.
     *
     * @param nome nome do instrutor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone do instrutor.
     *
     * @return telefone do instrutor
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do instrutor.
     *
     * @param telefone telefone do instrutor
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o CEP do instrutor.
     *
     * @return CEP do instrutor
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o CEP do instrutor.
     *
     * @param cep CEP do instrutor
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna o e-mail do instrutor.
     *
     * @return e-mail do instrutor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do instrutor.
     *
     * @param email e-mail do instrutor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a especialidade do instrutor.
     *
     * @return especialidade do instrutor
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Define a especialidade do instrutor.
     *
     * @param especialidade especialidade do instrutor
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * Retorna o salário do instrutor.
     *
     * @return salário do instrutor
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * Define o salário do instrutor.
     *
     * @param salario salário do instrutor
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * Retorna o horário de trabalho do instrutor.
     *
     * @return horário de trabalho
     */
    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    /**
     * Define o horário de trabalho do instrutor.
     *
     * @param horarioTrabalho horário de trabalho
     */
    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    /**
     * Retorna os dados principais do instrutor em formato textual.
     *
     * @return dados do instrutor
     */
    @Override
    public String mostrarDados() {
        return "Instrutor | Nome : " + getNome() + " | Telefone : " + getTelefone() + " | Email : " + getEmail()
                + " | Especialidade : " + this.especialidade + " | Salario : " + this.salario
                + " | Horario de Trabalho : " + this.horarioTrabalho;
    }
}