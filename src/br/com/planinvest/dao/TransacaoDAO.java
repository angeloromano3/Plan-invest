package br.com.planinvest.dao;

import br.com.planinvest.model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe DAO responsável por acessar o banco de dados para a entidade Transacao
public class TransacaoDAO {

    // Método responsável por inserir uma transação no banco de dados
    public void insert(Transacao transacao) {

        // SQL de inserção com os campos da tabela TRANSACAO
        String sql = "INSERT INTO TRANSACAO " +
                "(ID_TRANSACAO, TP_TRANSACAO, VL_TRANSACAO, DT_EFETIVACAO, " +
                "DS_TRANSACAO, TP_PAGAMENTO, FLG_RECORRENTE, " +
                "CONTA_ID_CONTA, CATEGORIA_ID_CATEGORIA) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Abre a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Prepara o comando SQL para execução
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Preenche os valores nos campos do SQL
            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setString(2, transacao.getTpTransacao());
            stmt.setDouble(3, transacao.getVlTransacao());
            stmt.setDate(4, new java.sql.Date(transacao.getDtEfetivacao().getTime()));
            stmt.setString(5, transacao.getDsTransacao());
            stmt.setString(6, transacao.getTpPagamento());
            stmt.setString(7, transacao.getFlgRecorrente());
            stmt.setInt(8, transacao.getIdConta());
            stmt.setInt(9, 1); // id categoria padrão

            // Executa o INSERT no banco
            stmt.executeUpdate();
            System.out.println("Transação inserida com sucesso!");

            // Fecha os recursos
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Trata erros de banco de dados
            System.out.println("Erro ao inserir transação: " + e.getMessage());
        }
    }

    // Método responsável por consultar todas as transações do banco de dados
    public List<Transacao> getAll() {

        // SQL de consulta de todos os registros da tabela TRANSACAO
        String sql = "SELECT * FROM TRANSACAO";

        // Lista que armazenará os objetos retornados do banco
        List<Transacao> transacoes = new ArrayList<>();

        try {
            // Abre a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Prepara e executa o comando SELECT
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Percorre os resultados e cria objetos Transacao
            while (rs.next()) {
                Transacao transacao = new Transacao(
                        rs.getInt("ID_TRANSACAO"),
                        rs.getInt("CONTA_ID_CONTA"),
                        1,
                        rs.getString("TP_TRANSACAO"),
                        rs.getDouble("VL_TRANSACAO"),
                        rs.getDate("DT_EFETIVACAO"),
                        rs.getString("DS_TRANSACAO"),
                        rs.getString("TP_PAGAMENTO"),
                        rs.getString("FLG_RECORRENTE")
                );
                transacoes.add(transacao);
            }

            System.out.println("Total de transações encontradas: " + transacoes.size());

            // Fecha os recursos
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Trata erros de banco de dados
            System.out.println("Erro ao consultar transações: " + e.getMessage());
        }

        return transacoes;
    }
}