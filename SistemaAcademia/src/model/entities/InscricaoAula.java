package model.entities;

/**
 * Classe responsável por representar a entidade InscricaoAula no sistema,
 * associando um aluno a uma aula específica.
 *
 * @author Pedro
 */
public class InscricaoAula {

    private Aluno aluno;
    private Aula aula;

    public InscricaoAula() {
    }

    public InscricaoAula(Aluno aluno, Aula aula) {
        this.aluno = aluno;
        this.aula = aula;
    }

    /**
     * Retorna o aluno associado à inscrição.
     *
     * @return aluno da inscrição
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * Define o aluno associado à inscrição.
     *
     * @param aluno aluno da inscrição
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * Retorna a aula associada à inscrição.
     *
     * @return aula da inscrição
     */
    public Aula getAula() {
        return aula;
    }

    /**
     * Define a aula associada à inscrição.
     *
     * @param aula aula da inscrição
     */
    public void setAula(Aula aula) {
        this.aula = aula;
    }
}