package agencia_bancaria;

public class Conta {

    private int numeroConta;
    private double saldo;

    public Conta(int numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta destino) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta +
               "\nSaldo: R$ " + String.format("%.2f", saldo);
    }
}
