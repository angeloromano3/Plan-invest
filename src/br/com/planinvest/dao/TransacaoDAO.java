package br.com.planinvest.dao;

import br.com.planinvest.model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    public void insert(Transacao transacao) {
        String sql = "INSERT INTO TRANSACAO (ID_TRANSACAO, TP_TRANSACAO, VL_TRANSACAO, DT_EFETIVACAO, DS_TRANSACAO, TP_PAGAMENTO, FLG_RECORENTE, CONTA_ID_CONTA, CATEGORIA_ID_CATEGORIA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setString(2, transacao.getTpTransacao());
            stmt.setDouble(3, transacao.getVlTransacao());
            stmt.setDate(4, new java.sql.Date(transacao.getDtEfetivacao().getTime()));
            stmt.setString(5, transacao.getDsTransacao());
            stmt.setString(6, transacao.getTpPagamento());
            stmt.setString(7, transacao.getFlgRecorrente());
            stmt.setInt(8, transacao.getIdConta());
            stmt.setInt(9, 1);

            stmt.executeUpdate();
            System.out.println("Transação inserida com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir transação: " + e.getMessage());
        }
    }

    public List<Transacao> getAll() {
        String sql = "SELECT * FROM TRANSACAO";
        List<Transacao> transacoes = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

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
                        rs.getString("FLG_RECORENTE")
                );
                transacoes.add(transacao);
            }

            System.out.println("Total de transações encontradas: " + transacoes.size());

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar transações: " + e.getMessage());
        }

        return transacoes;
    }
}