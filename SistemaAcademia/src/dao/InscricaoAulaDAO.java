package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.entities.InscricaoAula;

/**
 * Classe responsável pelas operações de acesso a dados da entidade InscricaoAula,
 * permitindo registrar, cancelar e consultar inscrições de alunos em aulas.
 *
 * @author Wendel
 */
public class InscricaoAulaDAO {

    private Connection conexao;

    public InscricaoAulaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // Inscreve um aluno em uma aula
    /**
     * Método responsável por registrar a inscrição de um aluno em uma aula.
     *
     * @param inscricao objeto contendo os dados da inscrição
     */
    public void adicionar(InscricaoAula inscricao) {
        String sql = "INSERT INTO inscricao_aula (fk_aln_cpf, fk_aul_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, inscricao.getAluno().getCpf());
            stmt.setInt(2, inscricao.getAula().getIdAula());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inscrever aluno na aula: " + e.getMessage(), e);
        }
    }

    // Cancela a inscrição de um aluno em uma aula
    /**
     * Método responsável por cancelar a inscrição de um aluno em uma aula.
     *
     * @param cpfAluno CPF do aluno
     * @param idAula identificador da aula
     */
    public void excluir(String cpfAluno, Integer idAula) {
        String sql = "DELETE FROM inscricao_aula WHERE fk_aln_cpf = ? AND fk_aul_id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfAluno);
            stmt.setInt(2, idAula);

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cancelar inscrição: " + e.getMessage(), e);
        }
    }

    // conta quantos alunos estão inscritos em uma aula
    /**
     * Método responsável por contar o número de inscrições em uma aula.
     *
     * @param idAula identificador da aula
     * @return quantidade de alunos inscritos
     */
    public int contarInscricoesPorAula(Integer idAula) {
        String sql = "SELECT COUNT(*) AS total FROM inscricao_aula WHERE fk_aul_id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idAula);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao contar inscrições da aula: " + e.getMessage(), e);
        }

        return 0;
    }
}