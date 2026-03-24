package br.com.planinvest.model;

public class Conta {

    // Atributos da conta
    private int idConta;
    private double saldo;
    private String tipoConta;

    // Construtor da classe Conta
    public Conta(int idConta, double saldo, String tipoConta) {
        this.idConta = idConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    // Métodos da conta "o que ela faz? consulta e atualiza saldo"
    public void consultarSaldo() {
        System.out.println("Consultando saldo da conta");
    }

    public void atualizarSaldo() {
        System.out.println("Atualizando saldo da conta");
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

}