package br.com.planinvest.dao;

import br.com.planinvest.model.MetaFinanceira;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaFinanceiraDAO {

    public void insert(MetaFinanceira meta) {
        String sql = "INSERT INTO META (ID_META, NM_META, VL_OBJETO, VL_ACUMULADO, DT_INICIO, DT_PRAZO, ST_META, DS_META, USUARIO_ID_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, meta.getIdMeta());
            stmt.setString(2, meta.getNmMeta());
            stmt.setDouble(3, meta.getVlObjeto());
            stmt.setDouble(4, meta.getVlAcumulado());
            stmt.setDate(5, new java.sql.Date(meta.getDtInicio().getTime()));
            stmt.setDate(6, new java.sql.Date(meta.getDtPrazo().getTime()));
            stmt.setString(7, meta.getStMeta());
            stmt.setString(8, meta.getDsMeta());
            stmt.setInt(9, meta.getIdUsuario());

            stmt.executeUpdate();
            System.out.println("Meta inserida com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir meta: " + e.getMessage());
        }
    }

    public List<MetaFinanceira> getAll() {
        String sql = "SELECT * FROM META";
        List<MetaFinanceira> metas = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MetaFinanceira meta = new MetaFinanceira(
                        rs.getInt("ID_META"),
                        rs.getInt("USUARIO_ID_USUARIO"),
                        rs.getString("NM_META"),
                        rs.getDouble("VL_OBJETO"),
                        rs.getDouble("VL_ACUMULADO"),
                        rs.getDate("DT_INICIO"),
                        rs.getDate("DT_PRAZO"),
                        rs.getString("ST_META"),
                        rs.getString("DS_META")
                );
                metas.add(meta);
            }

            System.out.println("Total de metas encontradas: " + metas.size());

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar metas: " + e.getMessage());
        }

        return metas;
    }
}