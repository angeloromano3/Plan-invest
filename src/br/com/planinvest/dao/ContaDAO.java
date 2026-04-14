package br.com.planinvest.dao;

import br.com.planinvest.model.Conta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void insert(Conta conta) {
        String sql = "INSERT INTO CONTA (ID_CONTA, NR_CONTA, NM_CONTA, TP_CONTA, NM_INSTITUICAO, VAL_SALDO_INICIAL, DT_CRIACAO, ST_ATIVA, USUARIO_ID_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, conta.getIdConta());
            stmt.setString(2, "");
            stmt.setString(3, conta.getNmConta());
            stmt.setString(4, conta.getTpConta());
            stmt.setString(5, conta.getNmInstituicao());
            stmt.setDouble(6, conta.getValSaldoInicial());
            stmt.setDate(7, new java.sql.Date(conta.getDtCriacao().getTime()));
            stmt.setString(8, conta.getStAtiva());
            stmt.setInt(9, conta.getIdUsuario());

            stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    public List<Conta> getAll() {
        String sql = "SELECT * FROM CONTA";
        List<Conta> contas = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

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

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar contas: " + e.getMessage());
        }

        return contas;
    }
}