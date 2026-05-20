package model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe responsável por representar a entidade Frequencia no sistema,
 * registrando a entrada de um aluno na academia com data e horário.
 *
 * @author Pedro
 */
public class Frequencia {

    private Integer idFrequencia;
    private Aluno aluno;
    private LocalDate dataEntrada;
    private LocalTime horaEntrada;

    public Frequencia() {
    }

    public Frequencia(Integer idFrequencia, Aluno aluno, LocalDate dataEntrada, LocalTime horaEntrada) {
        this.idFrequencia = idFrequencia;
        this.aluno = aluno;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
    }

    /**
     * Retorna o identificador da frequência.
     *
     * @return id da frequência
     */
    public Integer getIdFrequencia() {
        return idFrequencia;
    }

    /**
     * Define o identificador da frequência.
     *
     * @param idFrequencia id da frequência
     */
    public void setIdFrequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    /**
     * Retorna o aluno associado à frequência.
     *
     * @return aluno da frequência
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * Define o aluno associado à frequência.
     *
     * @param aluno aluno da frequência
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * Retorna a data de entrada do aluno.
     *
     * @return data de entrada
     */
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Define a data de entrada do aluno.
     *
     * @param dataEntrada data de entrada
     */
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * Retorna o horário de entrada do aluno.
     *
     * @return horário de entrada
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Define o horário de entrada do aluno.
     *
     * @param horaEntrada horário de entrada
     */
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}