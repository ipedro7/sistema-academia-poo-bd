package model.entities;

import java.math.BigDecimal;

/**
 * Classe responsável por representar a entidade Plano no sistema de academia,
 * contendo informações como nome, valor, descrição e duração do plano.
 *
 * @author Pedro
 */
public class Plano {

    private Integer idPlano;
    private String nome;
    private BigDecimal valor;
    private String descricao;
    private Integer duracao;

    public Plano() {
    }

    public Plano(Integer idPlano, String nome, BigDecimal valor, String descricao, Integer duracao) {
        this.idPlano = idPlano;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    /**
     * Retorna o identificador do plano.
     *
     * @return id do plano
     */
    public Integer getIdPlano() {
        return idPlano;
    }

    /**
     * Define o identificador do plano.
     *
     * @param idPlano id do plano
     */
    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    /**
     * Retorna o nome do plano.
     *
     * @return nome do plano
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do plano.
     *
     * @param nome nome do plano
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor do plano.
     *
     * @return valor do plano
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Define o valor do plano.
     *
     * @param valor valor do plano
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * Retorna a descrição do plano.
     *
     * @return descrição do plano
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do plano.
     *
     * @param descricao descrição do plano
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a duração do plano em meses.
     *
     * @return duração do plano
     */
    public Integer getDuracao() {
        return duracao;
    }

    /**
     * Define a duração do plano em meses.
     *
     * @param duracao duração do plano
     */
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

}