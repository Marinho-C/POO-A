package agencia_bancaria;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AgenciaBancaria {

    static ArrayList<Conta> contas = new ArrayList<>();
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {
        menuInicial();
    }

//Menuzito
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
            case 1 -> menuGerente();
            case 2 -> operacoes();
            case 3 -> System.exit(0);
            default -> menuInicial();
        }
    }

    public static void menuGerente() {
        criarConta();
        menuInicial();
    }



    public static void criarConta() {

        int numeroConta = gerarNumeroConta();
        String nome = JOptionPane.showInputDialog("Nome do cliente: ");
        int senha = lerSenha();

        double saldoInicial;
        do {
            saldoInicial = Double.parseDouble(
                JOptionPane.showInputDialog("Saldo inicial (maior que zero): ")
            );
        } while (saldoInicial <= 0);

        Conta conta = new Conta(numeroConta, saldoInicial);
        Pessoa pessoa = new Pessoa(nome, senha, numeroConta);

        contas.add(conta);
        pessoas.add(pessoa);

        JOptionPane.showMessageDialog(null,
            "Conta criada com sucesso!\n\n" +
            "Cliente: " + nome +
            "\nConta: " + numeroConta +
            "\nSaldo: R$ " + saldoInicial
        );
    }





//Aqui nossa Policia Federal (PF) 

    public static void operacoes() {
        int opcao = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Operações\n\n" +
                "2 - Depositar\n" +
                "3 - Sacar\n" +
                "4 - Transferir\n" +
                "5 - Listar Conta\n" +
                "6 - Voltar"
            )
        );

        switch (opcao) {
            case 2 -> depositar();
            case 3 -> sacar();
            case 4 -> transferir();
            case 5 -> listar();
            case 6 -> menuInicial();
            default -> operacoes();
        }
    }


    public static Conta encontrarConta(int numero) {
        for (Conta c : contas)
            if (c.getNumeroConta() == numero)
                return c;
        return null;
    }

    public static Pessoa encontrarPessoa(int numero) {
        for (Pessoa p : pessoas)
            if (p.getNumeroConta() == numero)
                return p;
        return null;
    }





    public static void depositar() {
        int nc = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
        Conta conta = encontrarConta(nc);

        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Infelizmente, conta não encontrada");
            return;
        }

        double valor = Double.parseDouble(
            JOptionPane.showInputDialog("Valor do depósito: ")
        );

        if (conta.depositar(valor)) {
            JOptionPane.showMessageDialog(null,
                "Depósito realizado com sucesso!\n" +
                "Saldo atual: R$ " + conta.getSaldo()
            );
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
        }
          operacoes();
    }



    public static void sacar() {

    int nc = Integer.parseInt(
        JOptionPane.showInputDialog("Número da conta: ")
    );

    Conta conta = encontrarConta(nc);

    if (conta == null) {
        JOptionPane.showMessageDialog(null, "Infelizmente, conta não encontrada");
        operacoes();
        return;
    }

    double valor = Double.parseDouble(
        JOptionPane.showInputDialog(
            "Saldo disponível: R$ " + conta.getSaldo() +
            "\n\nDigite o valor do saque:"
        )
    );

    if (conta.sacar(valor)) {
        JOptionPane.showMessageDialog(null,
            "Saque realizado com sucesso!\n" +
            "Valor sacado: R$ " + valor +
            "\nSaldo restante: R$ " + conta.getSaldo()
        );
    } else {
        JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
    }

    operacoes();
}



    public static void transferir() {

        int origem = Integer.parseInt(JOptionPane.showInputDialog("Conta origem"));
        int destino = Integer.parseInt(JOptionPane.showInputDialog("Conta destino"));

        Conta contaOrigem = encontrarConta(origem);
        Conta contaDestino = encontrarConta(destino);

        if (contaOrigem == null || contaDestino == null) {
            JOptionPane.showMessageDialog(null, "Conta inválida");
            return;
        }

        JOptionPane.showMessageDialog(null,
            "Saldo disponível: R$ " + contaOrigem.getSaldo()
        );

        double valor = Double.parseDouble(
            JOptionPane.showInputDialog("Valor da transferência: ")
        );

        if (contaOrigem.transferir(valor, contaDestino)) {
            JOptionPane.showMessageDialog(null,
                "Transferência realizada com sucesso!\n" +
                "Origem: " + origem +
                "\nDestino: " + destino +
                "\nValor: R$ " + valor
            );
        } else {
            JOptionPane.showMessageDialog(null, "Transferência inválida!");
        }
          operacoes();
    }




    public static void listar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
        Conta conta = encontrarConta(numero);
        Pessoa pessoa = encontrarPessoa(numero);

        if (conta != null && pessoa != null) {
            JOptionPane.showMessageDialog(null,
                "Cliente: " + pessoa.getNome() +
                "\nConta: " + conta.getNumeroConta() +
                "\nSaldo: R$ " + conta.getSaldo()
            );
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
          operacoes();
    }



    public static int gerarNumeroConta() {
        int numero;
        do {
            numero = (int)(Math.random() * 90000) + 10000;
        } while (encontrarConta(numero) != null);
        return numero;
    }

    public static int lerSenha() {
        while (true) {
            try {
                String s = JOptionPane.showInputDialog("Senha (OBRIGATÓRIO: 6 dígitos)");
                if (s.length() != 6) throw new Exception();
                return Integer.parseInt(s);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Senha inválida!");
            }
        }
    }
}
