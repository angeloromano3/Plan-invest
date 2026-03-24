package br.com.planinvest.model;

public class Transacao {

    // Atributos da transação
    private int idTransacao;
    private double valor;
    private String tipo;

    // Construtor da classe Transacao
    public Transacao(int idTransacao, double valor, String tipo) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.tipo = tipo;
    }

    // Métodos da Transação
    public void registrarTransacao() {
        System.out.println("Registrando transação financeira");
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}