package br.com.planinvest.model;


public class Main {

    public static void main(String[] args) {
        //Iniciando Sistema
        System.out.println("Sistema Plan+Invest iniciado");

        //Criando objetos das classes com seus respectivos atributos
        Conta conta = new Conta(1, 1500.00, "Corrente");
        Usuario usuario = new Usuario(1, "jose", "jose@email.com");
        MetaFinanceira meta = new MetaFinanceira(1, 5000.00, "Reserva de emergência");
        Transacao transacao = new Transacao(1, 250.00, "Depósito");
        Login login = new Login(1, "jose", "jose@email.com", "jose123", "senha123"); // herda de Usuario

        // Invocando os métodos das classes criadas
        conta.consultarSaldo();
        usuario.cadastrarUsuario();
        meta.criarMeta();
        transacao.registrarTransacao();
        login.realizarLogin();
        login.validarUsuario();

    }

}