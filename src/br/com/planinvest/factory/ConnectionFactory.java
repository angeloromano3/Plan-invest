package br.com.planinvest.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe responsável por gerenciar a conexão com o banco de dados Oracle
public class ConnectionFactory {

    // URL de conexão com o banco Oracle da FIAP
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    // Usuário do banco de dados
    private static final String USER = "rm567274";

    // Senha do banco de dados
    private static final String PASSWORD = "fiap26";

    // Método que abre e retorna a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
