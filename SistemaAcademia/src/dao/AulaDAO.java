package dao;

import model.entities.Aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelas operações de acesso a dados da entidade Aula,
 * como inserção, listagem, atualização e exclusão no banco de dados.
 *
 * @author Wendel
 */
public class AulaDAO {
    private Connection conexao;

    public AulaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // insere
    /**
     * Método responsável por adicionar uma aula ao banco de dados.
     *
     * @param aula objeto contendo os dados da aula
     */
    public void adicionar(Aula aula) {
        String sql = "INSERT INTO aula (aul_nome, aul_desc, aul_duracao, aul_horario, aul_max_alunos) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getDescricao());
            if (aula.getDuracao() != null)
                stmt.setInt(3, aula.getDuracao());
            else
                stmt.setNull(3, java.sql.Types.INTEGER);
            stmt.setObject(4, aula.getHorario());
            if (aula.getCapacidadeMaximaAlunos() != null)
                stmt.setInt(5, aula.getCapacidadeMaximaAlunos());
            else
                stmt.setNull(5, java.sql.Types.INTEGER);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aula: " + e.getMessage(), e);
        }
    }

    // lista
    /**
     * Método responsável por listar todas as aulas cadastradas.
     *
     * @return lista de aulas cadastradas
     */
    public List<Aula> listar() {
        String sql = "SELECT * FROM aula";

        List<Aula> aulas = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aula aula = new Aula();
                aula.setIdAula(rs.getInt("aul_id"));
                aula.setNome(rs.getString("aul_nome"));
                aula.setDescricao(rs.getString("aul_desc"));
                int dur = rs.getInt("aul_duracao");
                if (!rs.wasNull())
                    aula.setDuracao(dur);
                aula.setHorario(rs.getObject("aul_horario", java.time.LocalDateTime.class));
                int max = rs.getInt("aul_max_alunos");
                if (!rs.wasNull())
                    aula.setCapacidadeMaximaAlunos(max);
                aulas.add(aula);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar aulas: " + e.getMessage(), e);
        }
        return aulas;
    }

    // atualizar
    /**
     * Método responsável por atualizar os dados de uma aula existente.
     *
     * @param aula objeto com os novos dados da aula
     */
    public void atualizar(Aula aula) {
        String sql = "UPDATE aula SET aul_nome=?, aul_desc=?, aul_duracao=?, aul_horario=?, aul_max_alunos=? WHERE aul_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getDescricao());
            if (aula.getDuracao() != null)
                stmt.setInt(3, aula.getDuracao());
            else
                stmt.setNull(3, java.sql.Types.INTEGER);
            stmt.setObject(4, aula.getHorario());
            if (aula.getCapacidadeMaximaAlunos() != null)
                stmt.setInt(5, aula.getCapacidadeMaximaAlunos());
            else
                stmt.setNull(5, java.sql.Types.INTEGER);
            stmt.setInt(6, aula.getIdAula());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar aulas: " + e.getMessage(), e);
        }
    }

    // excluir
    /**
     * Método responsável por excluir uma aula do banco de dados.
     *
     * @param id identificador da aula a ser removida
     */
    public void excluir(int id) {
        String sql = "DELETE FROM aula WHERE aul_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir aulas: " + e.getMessage(), e);
        }
    }
}