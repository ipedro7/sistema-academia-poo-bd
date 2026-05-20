package dao;

import model.entities.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe responsável pelas operações de acesso a dados da entidade Aluno,
 * como inserção, listagem, atualização e exclusão no banco de dados.
 *
 * @author Wendel
 */
public class AlunoDAO {
    private Connection conexao;

    public AlunoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // insere
    /**
     * Método responsável por adicionar um aluno ao banco de dados.
     *
     * @param aluno objeto contendo os dados do aluno
     */
    public void adicionar(Aluno aluno) {
        String sql = "INSERT INTO aluno (aln_cpf, aln_nome, aln_telefone, aln_DataNasc, aln_email, aln_cep) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getTelefone());
            stmt.setObject(4, aluno.getDataNascimento());
            stmt.setString(5, aluno.getEmail());
            stmt.setString(6, aluno.getCep());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno: " + e.getMessage(), e);
        }
    }

    // lista
    /**
     * Método responsável por listar todos os alunos cadastrados.
     *
     * @return lista de alunos
     */
    public List<Aluno> listar() {
        String sql = "SELECT * FROM aluno";

        List<Aluno> alunos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setCpf(rs.getString("aln_cpf"));
                aluno.setNome(rs.getString("aln_nome"));
                aluno.setTelefone(rs.getString("aln_telefone"));
                aluno.setDataNascimento(rs.getObject("aln_DataNasc", java.time.LocalDate.class));
                aluno.setEmail(rs.getString("aln_email"));
                aluno.setCep(rs.getString("aln_cep"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos: " + e.getMessage(), e);
        }
        return alunos;
    }

    // atualizar
    /**
     * Método responsável por atualizar os dados de um aluno existente.
     *
     * @param aluno objeto com os novos dados do aluno
     */
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET aln_nome=?, aln_telefone=?, aln_DataNasc=?, aln_email=?, aln_cep=? WHERE aln_cpf=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setObject(3, aluno.getDataNascimento());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCep());
            stmt.setString(6, aluno.getCpf());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos: " + e.getMessage(), e);
        }
    }

    // excluir
    /**
     * Método responsável por excluir um aluno do banco de dados.
     *
     * @param cpf identificador do aluno a ser removido
     */
    public void excluir(String cpf) {
        String sql = "DELETE FROM aluno WHERE aln_cpf=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir alunos: " + e.getMessage(), e);
        }
    }
}