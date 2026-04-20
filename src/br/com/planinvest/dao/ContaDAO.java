package br.com.planinvest.dao;

import br.com.planinvest.factory.ConnectionFactory;
import br.com.planinvest.model.Conta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe DAO responsável por acessar o banco de dados para a entidade Conta
public class ContaDAO {

    // Método responsável por inserir uma conta no banco de dados
    public void insert(Conta conta) {

        // SQL de inserção com os campos da tabela CONTA
        String sql = "INSERT INTO CONTA " +
                "(ID_CONTA, NR_CONTA, NM_CONTA, TP_CONTA, NM_INSTITUICAO, " +
                "VAL_SALDO_INICIAL, DT_CRIACAO, ST_ATIVA, USUARIO_ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Abre a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Prepara o comando SQL para execução
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Preenche os valores nos campos do SQL
            stmt.setInt(1, conta.getIdConta());
            stmt.setString(2, ""); // número da conta opcional
            stmt.setString(3, conta.getNmConta());
            stmt.setString(4, conta.getTpConta());
            stmt.setString(5, conta.getNmInstituicao());
            stmt.setDouble(6, conta.getValSaldoInicial());
            stmt.setDate(7, new java.sql.Date(conta.getDtCriacao().getTime()));
            stmt.setString(8, conta.getStAtiva());
            stmt.setInt(9, conta.getIdUsuario());

            // Executa o INSERT no banco
            stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso!");

            // Fecha os recursos
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Trata erros de banco de dados
            System.out.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    // Método responsável por consultar todas as contas do banco de dados
    public List<Conta> getAll() {

        // SQL de consulta de todos os registros da tabela CONTA
        String sql = "SELECT * FROM CONTA";

        // Lista que armazenará os objetos retornados do banco
        List<Conta> contas = new ArrayList<>();

        try {
            // Abre a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Prepara e executa o comando SELECT
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Percorre os resultados e cria objetos Conta
            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("ID_CONTA"),
                        rs.getInt("USUARIO_ID_USUARIO"),
                        rs.getString("NM_CONTA"),
                        rs.getString("TP_CONTA"),
                        rs.getString("NM_INSTITUICAO"),
                        rs.getDouble("VAL_SALDO_INICIAL"),
                        rs.getDate("DT_CRIACAO"),
                        rs.getString("ST_ATIVA")
                );
                contas.add(conta);
            }

            System.out.println("Total de contas encontradas: " + contas.size());

            // Fecha os recursos
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Trata erros de banco de dados
            System.out.println("Erro ao consultar contas: " + e.getMessage());
        }

        return contas;
    }
}