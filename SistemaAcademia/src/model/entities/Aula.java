package model.entities;

import java.time.LocalDateTime;

/**
 * Classe responsável por representar a entidade Aula no sistema de academia,
 * contendo informações como nome, descrição, horário, duração e instrutor.
 *
 * @author Pedro
 */
public class Aula {

    private Integer idAula;
    private String nome;
    private String descricao;
    private Integer capacidadeMaximaAlunos;
    private LocalDateTime horario;
    private Integer duracao;
    private Instrutor instrutor;

    public Aula() {
    }

    public Aula(Integer idAula, String nome, String descricao, Integer capacidadeMaximaAlunos,
                LocalDateTime horario, Integer duracao, Instrutor instrutor) {
        this.idAula = idAula;
        this.nome = nome;
        this.descricao = descricao;
        this.capacidadeMaximaAlunos = capacidadeMaximaAlunos;
        this.horario = horario;
        this.duracao = duracao;
        this.instrutor = instrutor;
    }

    /**
     * Retorna o identificador da aula.
     *
     * @return id da aula
     */
    public Integer getIdAula() {
        return idAula;
    }

    /**
     * Define o identificador da aula.
     *
     * @param idAula id da aula
     */
    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    /**
     * Retorna o nome da aula.
     *
     * @return nome da aula
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da aula.
     *
     * @param nome nome da aula
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição da aula.
     *
     * @return descrição da aula
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da aula.
     *
     * @param descricao descrição da aula
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a capacidade máxima de alunos da aula.
     *
     * @return capacidade máxima de alunos
     */
    public Integer getCapacidadeMaximaAlunos() {
        return capacidadeMaximaAlunos;
    }

    /**
     * Define a capacidade máxima de alunos da aula.
     *
     * @param capacidadeMaximaAlunos quantidade máxima de alunos
     */
    public void setCapacidadeMaximaAlunos(Integer capacidadeMaximaAlunos) {
        this.capacidadeMaximaAlunos = capacidadeMaximaAlunos;
    }

    /**
     * Retorna o horário da aula.
     *
     * @return horário da aula
     */
    public LocalDateTime getHorario() {
        return horario;
    }

    /**
     * Define o horário da aula.
     *
     * @param horario horário da aula
     */
    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    /**
     * Retorna a duração da aula.
     *
     * @return duração da aula
     */
    public Integer getDuracao() {
        return duracao;
    }

    /**
     * Define a duração da aula.
     *
     * @param duracao duração da aula
     */
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    /**
     * Retorna o instrutor responsável pela aula.
     *
     * @return instrutor da aula
     */
    public Instrutor getInstrutor() {
        return instrutor;
    }

    /**
     * Define o instrutor responsável pela aula.
     *
     * @param instrutor instrutor da aula
     */
    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}