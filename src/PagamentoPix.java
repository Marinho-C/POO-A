import javax.swing.JOptionPane;

public class PagamentoPix extends Pagamento {

    @Override
    public boolean processarPagamento(double valor) {
        JOptionPane.showMessageDialog(null,
            "Gerando QR CODE...\nPagamento via PIX aprovado!");
        return true;
    }
}
