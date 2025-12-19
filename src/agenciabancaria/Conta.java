package agencia_bancaria;

import javax.swing.JOptionPane;

public class Conta {  
        private int numeroConta;
        private double saldo;
    
    
        public Conta(int numeroConta, double saldo) {
            this.numeroConta = numeroConta;
            this.saldo = saldo;
        }
    
    
    
        public int getNumeroConta() {
            return numeroConta;
        }
    
        public double getSaldo() {
            return saldo;
        }
    
        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
    
    
        public void depositar(double valor) {
            if (valor > 0) {
                setSaldo(getSaldo() + valor);
                JOptionPane.showMessageDialog(null, "Seu depósito foi realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar o depósito.");
            }
        }
    
    
    
        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                setSaldo(getSaldo() - valor);
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente ou valor inválido.");
            }
        }
    
    
        public void transferir(double valor, Conta destino) {
            if (valor > 0 && valor <= saldo) {
                this.saldo -= valor;
                destino.saldo += valor;
                JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência.");
            }
        }
    
    
        @Override
        public String toString() {
            return "Número da Conta: " + numeroConta +
                   "\nSaldo: R$ " + saldo;
        }
    
}
