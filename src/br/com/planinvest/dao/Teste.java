package br.com.planinvest.dao;

import br.com.planinvest.model.Conta;
import br.com.planinvest.model.MetaFinanceira;
import br.com.planinvest.model.Transacao;

import java.util.Date;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        ContaDAO contaDAO = new ContaDAO();
        MetaFinanceiraDAO metaDAO = new MetaFinanceiraDAO();
        TransacaoDAO transacaoDAO = new TransacaoDAO();

        // ===== INSERT CONTAS =====
        System.out.println("=== Inserindo Contas ===");
        contaDAO.insert(new Conta(1, 1, "Nubank", "corrente", "Nubank", 1500.00, new Date(), "1"));
        contaDAO.insert(new Conta(2, 1, "Itaú", "poupança", "Itaú", 3000.00, new Date(), "1"));
        contaDAO.insert(new Conta(3, 1, "Bradesco", "corrente", "Bradesco", 500.00, new Date(), "1"));
        contaDAO.insert(new Conta(4, 1, "Inter", "carteira", "Inter", 200.00, new Date(), "1"));
        contaDAO.insert(new Conta(5, 1, "Caixa", "poupança", "Caixa", 1000.00, new Date(), "1"));

        // ===== GETALL CONTAS =====
        System.out.println("\n=== Consultando Contas ===");
        List<Conta> contas = contaDAO.getAll();
        for (Conta c : contas) {
            System.out.println("ID: " + c.getIdConta() + " | Nome: " + c.getNmConta() + " | Tipo: " + c.getTpConta() + " | Saldo: " + c.getValSaldoInicial());
        }

        // ===== INSERT METAS =====
        System.out.println("\n=== Inserindo Metas ===");
        metaDAO.insert(new MetaFinanceira(1, 1, "Viagem", 5000.00, 0.00, new Date(), new Date(), "ativa", "Viagem para o nordeste"));
        metaDAO.insert(new MetaFinanceira(2, 1, "Notebook", 3500.00, 500.00, new Date(), new Date(), "ativa", "Notebook novo"));
        metaDAO.insert(new MetaFinanceira(3, 1, "Reserva", 10000.00, 2000.00, new Date(), new Date(), "ativa", "Reserva de emergência"));
        metaDAO.insert(new MetaFinanceira(4, 1, "Carro", 30000.00, 5000.00, new Date(), new Date(), "ativa", "Carro popular"));
        metaDAO.insert(new MetaFinanceira(5, 1, "Celular", 2000.00, 800.00, new Date(), new Date(), "ativa", "iPhone ou Samsung"));

        // ===== GETALL METAS =====
        System.out.println("\n=== Consultando Metas ===");
        List<MetaFinanceira> metas = metaDAO.getAll();
        for (MetaFinanceira m : metas) {
            System.out.println("ID: " + m.getIdMeta() + " | Nome: " + m.getNmMeta() + " | Objetivo: " + m.getVlObjeto() + " | Status: " + m.getStMeta());
        }

        // ===== INSERT TRANSACOES =====
        System.out.println("\n=== Inserindo Transações ===");
        transacaoDAO.insert(new Transacao(1, 1, 1, "receita", 1500.00, new Date(), "Salário", "pix", "0"));
        transacaoDAO.insert(new Transacao(2, 1, 1, "despesa", 200.00, new Date(), "Supermercado", "débito", "0"));
        transacaoDAO.insert(new Transacao(3, 1, 1, "despesa", 150.00, new Date(), "Conta de luz", "boleto", "1"));
        transacaoDAO.insert(new Transacao(4, 1, 1, "despesa", 50.00, new Date(), "Streaming", "crédito", "1"));
        transacaoDAO.insert(new Transacao(5, 1, 1, "receita", 300.00, new Date(), "Freelance", "pix", "0"));

        // ===== GETALL TRANSACOES =====
        System.out.println("\n=== Consultando Transações ===");
        List<Transacao> transacoes = transacaoDAO.getAll();
        for (Transacao t : transacoes) {
            System.out.println("ID: " + t.getIdTransacao() + " | Tipo: " + t.getTpTransacao() + " | Valor: " + t.getVlTransacao() + " | Descrição: " + t.getDsTransacao());
        }
    }
}