package br.com.planinvest.model;

import java.util.Date;

// Classe que representa uma meta financeira do usuário no sistema Plan+Invest
public class MetaFinanceira {
    // Atributos da meta financeira
    private int idMeta;
    private int idUsuario;
    private String nmMeta;
    private double vlObjeto;
    private double vlAcumulado;
    private Date dtInicio;
    private Date dtPrazo;
    private String stMeta;
    private String dsMeta;

    // Construtor da classe MetaFinanceira
    public MetaFinanceira(int idMeta, int idUsuario, String nmMeta, double vlObjeto,
                          double vlAcumulado, Date dtInicio, Date dtPrazo,
                          String stMeta, String dsMeta) {
        this.idMeta = idMeta;
        this.idUsuario = idUsuario;
        this.nmMeta = nmMeta;
        this.vlObjeto = vlObjeto;
        this.vlAcumulado = vlAcumulado;
        this.dtInicio = dtInicio;
        this.dtPrazo = dtPrazo;
        this.stMeta = stMeta;
        this.dsMeta = dsMeta;
    }
    // Getters e Setters para acessar e modificar os atributos
    public int getIdMeta() { return idMeta; }
    public void setIdMeta(int idMeta) { this.idMeta = idMeta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNmMeta() { return nmMeta; }
    public void setNmMeta(String nmMeta) { this.nmMeta = nmMeta; }

    public double getVlObjeto() { return vlObjeto; }
    public void setVlObjeto(double vlObjeto) { this.vlObjeto = vlObjeto; }

    public double getVlAcumulado() { return vlAcumulado; }
    public void setVlAcumulado(double vlAcumulado) { this.vlAcumulado = vlAcumulado; }

    public Date getDtInicio() { return dtInicio; }
    public void setDtInicio(Date dtInicio) { this.dtInicio = dtInicio; }

    public Date getDtPrazo() { return dtPrazo; }
    public void setDtPrazo(Date dtPrazo) { this.dtPrazo = dtPrazo; }

    public String getStMeta() { return stMeta; }
    public void setStMeta(String stMeta) { this.stMeta = stMeta; }

    public String getDsMeta() { return dsMeta; }
    public void setDsMeta(String dsMeta) { this.dsMeta = dsMeta; }
}