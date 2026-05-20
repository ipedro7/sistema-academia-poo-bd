package dao;

import model.entities.Instrutor;
import model.entities.Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelas operações de acesso a dados da entidade Plano,
 * como inserção, listagem, atualização e exclusão no banco de dados.
 *
 * @author Wendel
 */
public class PlanoDAO {
    private Connection conexao;

    public PlanoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // insere
    /**
     * Método responsável por adicionar um plano ao banco de dados.
     *
     * @param plano objeto contendo os dados do plano
     */
    public void adicionar(Plano plano) {
        String sql = "INSERT INTO plano (pln_nome, pln_desc, pln_valor, pln_duracao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, plano.getNome());
            stmt.setString(2, plano.getDescricao());
            stmt.setBigDecimal(3, plano.getValor());
            if (plano.getDuracao() != null)
                stmt.setInt(4, plano.getDuracao());
            else
                stmt.setNull(4, java.sql.Types.INTEGER);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir plano: " + e.getMessage(), e);
        }
    }

    // lista
    /**
     * Método responsável por listar todos os planos cadastrados.
     *
     * @return lista de planos
     */
    public List<Plano> listar() {
        String sql = "SELECT * FROM plano";

        List<Plano> planos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Plano plano = new Plano();
                plano.setIdPlano(rs.getInt("pln_id"));
                plano.setNome(rs.getString("pln_nome"));
                plano.setDescricao(rs.getString("pln_desc"));
                plano.setValor(rs.getBigDecimal("pln_valor"));
                int dur = rs.getInt("pln_duracao");
                if (!rs.wasNull())
                    plano.setDuracao(dur);
                planos.add(plano);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar planos: " + e.getMessage(), e);
        }
        return planos;
    }

    // atualizar
    /**
     * Método responsável por atualizar os dados de um plano existente.
     *
     * @param plano objeto com os novos dados do plano
     */
    public void atualizar(Plano plano) {
        String sql = "UPDATE plano SET pln_nome=?, pln_desc=?, pln_valor=?, pln_duracao=? WHERE pln_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, plano.getNome());
            stmt.setString(2, plano.getDescricao());
            stmt.setBigDecimal(3, plano.getValor());
            if (plano.getDuracao() != null)
                stmt.setInt(4, plano.getDuracao());
            else
                stmt.setNull(4, java.sql.Types.INTEGER);
            stmt.setInt(5, plano.getIdPlano());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar planos: " + e.getMessage(), e);
        }
    }

    // excluir
    /**
     * Método responsável por excluir um plano do banco de dados.
     *
     * @param id identificador do plano a ser removido
     */
    public void excluir(int id) {
        String sql = "DELETE FROM plano WHERE pln_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir planos: " + e.getMessage(), e);
        }
    }
}