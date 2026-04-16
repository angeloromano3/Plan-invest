package br.com.planinvest.model;

import java.util.Date;
// Classe que representa uma transação financeira do usuário no sistema Plan+Invest
public class Transacao {

    // Atributos da trasacao
    private int idTransacao;
    private int idConta;
    private int idUsuario;
    private String tpTransacao;
    private double vlTransacao;
    private Date dtEfetivacao;
    private String dsTransacao;
    private String tpPagamento;
    private String flgRecorrente;

    //Construtor da classe Transacao
    public Transacao(int idTransacao, int idConta, int idUsuario, String tpTransacao,
                     double vlTransacao, Date dtEfetivacao, String dsTransacao,
                     String tpPagamento, String flgRecorrente) {
        this.idTransacao = idTransacao;
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.tpTransacao = tpTransacao;
        this.vlTransacao = vlTransacao;
        this.dtEfetivacao = dtEfetivacao;
        this.dsTransacao = dsTransacao;
        this.tpPagamento = tpPagamento;
        this.flgRecorrente = flgRecorrente;
    }
    // Getters e Setters para acessar e modificar os atributos
    public int getIdTransacao() { return idTransacao; }
    public void setIdTransacao(int idTransacao) { this.idTransacao = idTransacao; }

    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getTpTransacao() { return tpTransacao; }
    public void setTpTransacao(String tpTransacao) { this.tpTransacao = tpTransacao; }

    public double getVlTransacao() { return vlTransacao; }
    public void setVlTransacao(double vlTransacao) { this.vlTransacao = vlTransacao; }

    public Date getDtEfetivacao() { return dtEfetivacao; }
    public void setDtEfetivacao(Date dtEfetivacao) { this.dtEfetivacao = dtEfetivacao; }

    public String getDsTransacao() { return dsTransacao; }
    public void setDsTransacao(String dsTransacao) { this.dsTransacao = dsTransacao; }

    public String getTpPagamento() { return tpPagamento; }
    public void setTpPagamento(String tpPagamento) { this.tpPagamento = tpPagamento; }

    public String getFlgRecorrente() { return flgRecorrente; }
    public void setFlgRecorrente(String flgRecorrente) { this.flgRecorrente = flgRecorrente; }
}