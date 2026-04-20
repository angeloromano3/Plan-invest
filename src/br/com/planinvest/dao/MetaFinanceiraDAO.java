package br.com.planinvest.dao;

import br.com.planinvest.factory.ConnectionFactory;
import br.com.planinvest.model.MetaFinanceira;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe DAO responsável por acessar o banco de dados para a entidade MetaFinanceira
public class MetaFinanceiraDAO {

    // Método responsável por inserir uma meta financeira no banco de dados
    public void insert(MetaFinanceira meta) {

        // SQL de inserção com os campos da tabela META
        String sql = "INSERT INTO META " +
                "(ID_META, NM_META, VL_OBJETO, VL_ACUMULADO, " +
                "DT_INICIO, DT_PRAZO, ST_META, DS_META, USUARIO_ID_USUARIO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Abre a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Prepara o comando SQL para execução
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Preenche os valores nos campos do SQL
            stmt.setInt(1, meta.getIdMeta());
            stmt.setString(2, meta.getNmMeta());
            stmt.setDouble(3, meta.getVlObjeto());
            stmt.setDouble(4, meta.getVlAcumulado());
            stmt.setDate(5, new java.sql.Date(meta.getDtInicio().getTime()));
            stmt.setDate(6, new java.sql.Date(meta.getDtPrazo().getTime()));
            stmt.setString(7, meta.getStMeta());
            stmt.setString(8, meta.getDsMeta());
            stmt.setInt(9, meta.getIdUsuario());

            // Executa o INSERT no banco
            stmt.executeUpdate();
            System.out.println("Meta inserida com sucesso!");

            // Fecha os recursos
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Trata erros de banco de dados
            System.out.println("Erro ao inserir meta: " + e.getMessage());
        }
    }

    // Método responsável por consultar todas as metas financeiras do banco de dados
    public List<MetaFinanceira> getAll() {

        // SQL de consulta de todos os registros da tabela META
        String sql = "SELECT * FROM META";

        // Lista que armazenará os objetos retornados do banco
        List<MetaFinanceira> metas = new ArrayList<>();

        try {
            // Abre a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();

            // Prepara e executa o comando SELECT
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Percorre os resultados e cria objetos MetaFinanceira
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

            // Fecha os recursos
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Trata erros de banco de dados
            System.out.println("Erro ao consultar metas: " + e.getMessage());
        }

        return metas;
    }
}