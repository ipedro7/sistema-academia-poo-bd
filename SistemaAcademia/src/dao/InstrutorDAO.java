package dao;

import model.entities.Instrutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelas operações de acesso a dados da entidade Instrutor,
 * como inserção, listagem, atualização e exclusão no banco de dados.
 *
 * @author Wendel
 */
public class InstrutorDAO {
    private Connection conexao;

    public InstrutorDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // insere
    /**
     * Método responsável por adicionar um instrutor ao banco de dados.
     *
     * @param instrutor objeto contendo os dados do instrutor
     */
    public void adicionar(Instrutor instrutor) {
        String sql = "INSERT INTO instrutor (itr_cpf, itr_nome, itr_telefone, itr_email, itr_especialidade, itr_horarioTrabalho, itr_salario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getCpf());
            stmt.setString(2, instrutor.getNome());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getEmail());
            stmt.setString(5, instrutor.getEspecialidade());
            stmt.setString(6, instrutor.getHorarioTrabalho());
            stmt.setBigDecimal(7, instrutor.getSalario());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir instrutor: " + e.getMessage(), e);
        }
    }

    // lista
    /**
     * Método responsável por listar todos os instrutores cadastrados.
     *
     * @return lista de instrutores
     */
    public List<Instrutor> listar() {
        String sql = "SELECT * FROM instrutor";

        List<Instrutor> instrutores = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setIdFuncionario(rs.getInt("itr_id"));
                instrutor.setCpf(rs.getString("itr_cpf"));
                instrutor.setNome(rs.getString("itr_nome"));
                instrutor.setTelefone(rs.getString("itr_telefone"));
                instrutor.setEmail(rs.getString("itr_email"));
                instrutor.setEspecialidade(rs.getString("itr_especialidade"));
                instrutor.setHorarioTrabalho(rs.getString("itr_horarioTrabalho"));
                instrutor.setSalario(rs.getBigDecimal("itr_salario"));
                instrutores.add(instrutor);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar instrutores: " + e.getMessage(), e);
        }
        return instrutores;
    }

    // atualizar
    /**
     * Método responsável por atualizar os dados de um instrutor existente.
     *
     * @param instrutor objeto com os novos dados do instrutor
     */
    public void atualizar(Instrutor instrutor) {
        String sql = "UPDATE instrutor SET itr_cpf=?, itr_nome=?, itr_telefone=?, itr_email=?, itr_especialidade=?, itr_horarioTrabalho=?, itr_salario=? WHERE itr_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getCpf());
            stmt.setString(2, instrutor.getNome());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getEmail());
            stmt.setString(5, instrutor.getEspecialidade());
            stmt.setString(6, instrutor.getHorarioTrabalho());
            stmt.setBigDecimal(7, instrutor.getSalario());
            stmt.setInt(8, instrutor.getIdFuncionario());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar instrutores: " + e.getMessage(), e);
        }
    }

    // excluir
    /**
     * Método responsável por excluir um instrutor do banco de dados.
     *
     * @param id identificador do instrutor a ser removido
     */
    public void excluir(int id) {
        String sql = "DELETE FROM instrutor WHERE itr_id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir instrutores: " + e.getMessage(), e);
        }
    }
}