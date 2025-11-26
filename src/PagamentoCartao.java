import javax.swing.JOptionPane;

public class PagamentoCartao extends Pagamento {

    @Override
    public boolean processarPagamento(double valor) {
        JOptionPane.showMessageDialog(null,
            "Verificando AUTORIZAÇÃO do cartão...");

        JOptionPane.showMessageDialog(null,
            "Pagamento no cartão LIBERADO!");

        return true;
    }
}
