package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados,
 * fornecendo métodos para estabelecer a comunicação com o sistema.
 *
 * @author Wendel
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/academia";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Método responsável por estabelecer e retornar uma conexão com o banco de dados.
     *
     * @return objeto Connection com a conexão ativa
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}