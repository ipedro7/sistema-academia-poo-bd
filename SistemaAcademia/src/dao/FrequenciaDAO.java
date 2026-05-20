package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;
import model.entities.Frequencia;

/**
 * Classe responsável pelas operações de acesso a dados da entidade Frequencia,
 * incluindo registro, listagem e consultas por aluno e período.
 *
 * @author Wendel
 */
public class FrequenciaDAO {

    private Connection conexao;

    public FrequenciaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // registra a entrada do aluno na academia
    /**
     * Método responsável por registrar a entrada de um aluno na academia.
     *
     * @param frequencia objeto contendo os dados da frequência
     */
    public void adicionar(Frequencia frequencia) {
        String sql = "INSERT INTO frequencia "
                + "(fk_aln_cpf, frq_data_entrada, frq_hora_entrada) "
                + "VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, frequencia.getAluno().getCpf());
            stmt.setObject(2, frequencia.getDataEntrada());
            stmt.setObject(3, frequencia.getHoraEntrada());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar frequência: " + e.getMessage(), e);
        }
    }

    // lista todos os registros de frequência
    /**
     * Método responsável por listar todos os registros de frequência.
     *
     * @return lista de frequências cadastradas
     */
    public List<Frequencia> listar() {
        String sql = "SELECT * FROM frequencia";
        List<Frequencia> frequencias = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Frequencia frequencia = new Frequencia();

                frequencia.setIdFrequencia(rs.getInt("frq_id"));

                Aluno aluno = new Aluno();
                aluno.setCpf(rs.getString("fk_aln_cpf"));
                frequencia.setAluno(aluno);

                frequencia.setDataEntrada(rs.getObject("frq_data_entrada", LocalDate.class));
                frequencia.setHoraEntrada(rs.getObject("frq_hora_entrada", LocalTime.class));

                frequencias.add(frequencia);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar frequências: " + e.getMessage(), e);
        }

        return frequencias;
    }

    // lista os registros de frequência de um aluno específico
    /**
     * Método responsável por listar as frequências de um aluno específico.
     *
     * @param cpfAluno CPF do aluno
     * @return lista de frequências do aluno
     */
    public List<Frequencia> listarPorAluno(String cpfAluno) {
        String sql = "SELECT * FROM frequencia WHERE fk_aln_cpf = ?";
        List<Frequencia> frequencias = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfAluno);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Frequencia frequencia = new Frequencia();

                    frequencia.setIdFrequencia(rs.getInt("frq_id"));

                    Aluno aluno = new Aluno();
                    aluno.setCpf(rs.getString("fk_aln_cpf"));
                    frequencia.setAluno(aluno);

                    frequencia.setDataEntrada(rs.getObject("frq_data_entrada", LocalDate.class));
                    frequencia.setHoraEntrada(rs.getObject("frq_hora_entrada", LocalTime.class));

                    frequencias.add(frequencia);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar frequências do aluno: " + e.getMessage(), e);
        }

        return frequencias;
    }

    // lista as frequências de um aluno em um período específico
    /**
     * Método responsável por listar as frequências de um aluno dentro de um período.
     *
     * @param cpfAluno CPF do aluno
     * @param dataInicio data inicial do período
     * @param dataFim data final do período
     * @return lista de frequências no período informado
     */
    public List<Frequencia> listarPorAlunoPeriodo(String cpfAluno, LocalDate dataInicio, LocalDate dataFim) {
        String sql = "SELECT * FROM frequencia "
                + "WHERE fk_aln_cpf = ? "
                + "AND frq_data_entrada BETWEEN ? AND ?";

        List<Frequencia> frequencias = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfAluno);
            stmt.setObject(2, dataInicio);
            stmt.setObject(3, dataFim);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Frequencia frequencia = new Frequencia();

                    frequencia.setIdFrequencia(rs.getInt("frq_id"));

                    Aluno aluno = new Aluno();
                    aluno.setCpf(rs.getString("fk_aln_cpf"));
                    frequencia.setAluno(aluno);

                    frequencia.setDataEntrada(rs.getObject("frq_data_entrada", LocalDate.class));
                    frequencia.setHoraEntrada(rs.getObject("frq_hora_entrada", LocalTime.class));

                    frequencias.add(frequencia);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao gerar relatório de frequência: " + e.getMessage(), e);
        }

        return frequencias;
    }
}