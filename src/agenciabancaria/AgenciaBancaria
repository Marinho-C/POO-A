package agencia_bancaria;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AgenciaBancaria {

    static ArrayList<Conta> contas = new ArrayList<>();
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {
        menuInicial();
    }

    public static void menuInicial() {

        int opcao = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Bem-vindo à Agência Bancária\n\n" +
                "1 - Gerente\n" +
                "2 - Pessoa Física\n" +
                "3 - Sair"
            )
        );

        switch (opcao) {
            case 1:
                menuGerente();
                break;
            case 2:
                operacoes();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                menuInicial();
        }
    }


    public static void menuGerente() {
        criarConta();
        menuInicial();
    }


    public static void criarConta() {

        int numeroConta = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o número da conta")
        );

        String nome = JOptionPane.showInputDialog("Nome do cliente");

        int senha = Integer.parseInt(
            JOptionPane.showInputDialog("Crie uma senha numérica")
        );

        double saldoInicial = Double.parseDouble(
            JOptionPane.showInputDialog("Saldo inicial")
        );

        Conta conta = new Conta(numeroConta, saldoInicial);
        Pessoa pessoa = new Pessoa(nome, senha, numeroConta);

        contas.add(conta);
        pessoas.add(pessoa);

        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
    }

// Aqui é PF (policia federal - pessoa fisica)
    public static void operacoes() {

        int opcao = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Selecione uma operação\n\n" +
                "2 - Depositar\n" +
                "3 - Sacar\n" +
                "4 - Transferir\n" +
                "5 - Listar Conta\n" +
                "6 - Sair da Conta"
            )
        );

        switch (opcao) {
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                menuInicial();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                operacoes();
        }
    }

    public static Conta encontrarConta(int numeroConta) {
        for (Conta c : contas) {
            if (c.getNumeroConta() == numeroConta) {
                return c;
            }
        }
        return null;
    }


    public static Pessoa encontrarPessoa(int numeroConta) {
        for (Pessoa p : pessoas) {
            if (p.getNumeroConta() == numeroConta) {
                return p;
            }
        }
        return null;
    }


    public static void depositar() {

        int nc = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o número da conta")
        );

        Conta conta = encontrarConta(nc);

        if (conta != null) {
            double valor = Double.parseDouble(
                JOptionPane.showInputDialog("Valor para depósito")
            );
            conta.depositar(valor);
            operacoes();
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
            operacoes();
        }
    }


    public static void sacar() {

        int nc = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o número da conta")
        );

        Conta conta = encontrarConta(nc);

        if (conta != null) {
            double valor = Double.parseDouble(
                JOptionPane.showInputDialog("Valor para saque")
            );
            conta.sacar(valor);
            operacoes();
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
            operacoes();
        }
    }


    public static void transferir() {

        int origem = Integer.parseInt(
            JOptionPane.showInputDialog("Conta de origem")
        );

        int destino = Integer.parseInt(
            JOptionPane.showInputDialog("Conta de destino")
        );

        Conta contaOrigem = encontrarConta(origem);
        Conta contaDestino = encontrarConta(destino);

        if (contaOrigem != null && contaDestino != null) {
            double valor = Double.parseDouble(
                JOptionPane.showInputDialog("Valor da transferência")
            );
            contaOrigem.transferir(valor, contaDestino);
            operacoes();
        } else {
            JOptionPane.showMessageDialog(null, "Conta inválida");
            operacoes();
        }
    }


    public static void listar() {

        int numeroConta = Integer.parseInt(
            JOptionPane.showInputDialog("Digite o número da sua conta")
        );

        Conta conta = encontrarConta(numeroConta);
        Pessoa pessoa = encontrarPessoa(numeroConta);

        if (conta != null && pessoa != null) {

            int senha = Integer.parseInt(
                JOptionPane.showInputDialog("Digite sua senha")
            );

            if (senha == pessoa.getSenha()) {
                JOptionPane.showMessageDialog(null, conta);
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
        }

        operacoes();
    }
}
