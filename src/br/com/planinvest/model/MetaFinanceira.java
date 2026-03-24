package br.com.planinvest.model;

public class MetaFinanceira {

    // Atributos da meta financeira
    private int idMeta;
    private double valorMeta;
    private String descricao;

    // Construtor da classe MetaFinanceira
    public MetaFinanceira(int idMeta, double valorMeta, String descricao) {
        this.idMeta = idMeta;
        this.valorMeta = valorMeta;
        this.descricao = descricao;
    }

    // Métodos da meta financeira
    public void criarMeta() {
        System.out.println("Criando meta financeira");
    }

    public void acompanharMeta() {
        System.out.println("Acompanhando progresso da meta");
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public double getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(double valorMeta) {
        this.valorMeta = valorMeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}