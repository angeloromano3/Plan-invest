package br.com.planinvest.model;

import java.util.Date;

public class Conta {

    private int idConta;
    private int idUsuario;
    private String nmConta;
    private String tpConta;
    private String nmInstituicao;
    private double valSaldoInicial;
    private Date dtCriacao;
    private String stAtiva;

    public Conta(int idConta, int idUsuario, String nmConta, String tpConta,
                 String nmInstituicao, double valSaldoInicial, Date dtCriacao, String stAtiva) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.nmConta = nmConta;
        this.tpConta = tpConta;
        this.nmInstituicao = nmInstituicao;
        this.valSaldoInicial = valSaldoInicial;
        this.dtCriacao = dtCriacao;
        this.stAtiva = stAtiva;
    }

    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNmConta() { return nmConta; }
    public void setNmConta(String nmConta) { this.nmConta = nmConta; }

    public String getTpConta() { return tpConta; }
    public void setTpConta(String tpConta) { this.tpConta = tpConta; }

    public String getNmInstituicao() { return nmInstituicao; }
    public void setNmInstituicao(String nmInstituicao) { this.nmInstituicao = nmInstituicao; }

    public double getValSaldoInicial() { return valSaldoInicial; }
    public void setValSaldoInicial(double valSaldoInicial) { this.valSaldoInicial = valSaldoInicial; }

    public Date getDtCriacao() { return dtCriacao; }
    public void setDtCriacao(Date dtCriacao) { this.dtCriacao = dtCriacao; }

    public String getStAtiva() { return stAtiva; }
    public void setStAtiva(String stAtiva) { this.stAtiva = stAtiva; }
}