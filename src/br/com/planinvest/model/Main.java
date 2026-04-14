package br.com.planinvest.model;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Iniciando Sistema
        System.out.println("Sistema Plan+Invest iniciado");

        // Criando objetos das classes com seus respectivos atributos
        Conta conta = new Conta(1, 1, "Nubank", "corrente", "Nubank", 1500.00, new Date(), "1");
        Usuario usuario = new Usuario(1, "jose", "jose@email.com");
        MetaFinanceira meta = new MetaFinanceira(1, 1, "Reserva de emergência", 5000.00, 0.00, new Date(), new Date(), "ativa", "Reserva para imprevistos");
        Transacao transacao = new Transacao(1, 1, 1, "receita", 250.00, new Date(), "Depósito", "pix", "0");
        Login login = new Login(1, "jose", "jose@email.com", "jose123", "senha123");

        // Invocando os métodos das classes criadas
        System.out.println("Conta criada: " + conta.getNmConta());
        System.out.println("Usuario criado: " + usuario.getNome());
        System.out.println("Meta criada: " + meta.getNmMeta());
        System.out.println("Transacao criada: " + transacao.getDsTransacao());
        System.out.println("Login criado: " + login.getUsuario());
    }
}