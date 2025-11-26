import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {

        Loja loja = null;
        int opcao = 0;

        while (opcao != 5) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "----- MENU -----\n" +
                "1 - Cadastrar Loja\n" +
                "2 - Cadastrar Produtos (5 itens)\n" +
                "3 - Realizar Venda\n" +
                "4 - Relatório\n" +
                "5 - Sair"
            ));

            if (opcao == 1) {
                String nome = JOptionPane.showInputDialog("Nome da loja:");
                String local = JOptionPane.showInputDialog("Localização da loja:");
                loja = new Loja(nome, local);
                JOptionPane.showMessageDialog(null, "Loja cadastrada com SUCESSO!");
            }

            else if (opcao == 2) {

                if (loja == null) {
                    JOptionPane.showMessageDialog(null, "Cadastre a loja primeiro!");
                } 
                else {
                    for (int i = 0; i < 5; i++) {
                        String cod = JOptionPane.showInputDialog("Produto " + (i+1) + " - Código:");
                        String desc = JOptionPane.showInputDialog("Descrição:");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
                        int est = Integer.parseInt(JOptionPane.showInputDialog("Estoque:"));

                        Produto p = new Produto(cod, desc, preco, est);
                        loja.cadastrarProduto(i, p);
                    }

                    JOptionPane.showMessageDialog(null, "Produtos cadastrados!");
                }
            }

            
            else if (opcao == 3) {

                if (loja == null) {
                    JOptionPane.showMessageDialog(null, "Cadastre a loja primeiro!");
                } 
                else {

                    Produto[] produtos = loja.getProdutos();
                    String lista = "Escolha o produto:\n";

                    for (int i = 0; i < 5; i++) {
                        if (produtos[i] != null) {
                            lista += i + " - " + produtos[i].getDescricao() + 
                                     " (Estoque: " + produtos[i].getEstoque() + ")\n";
                        }
                    }

                    int id = Integer.parseInt(JOptionPane.showInputDialog(lista));
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

                    if (produtos[id] != null && qtd <= produtos[id].getEstoque()) {

                        Venda v = new Venda(produtos[id], qtd);

                        int pg = Integer.parseInt(JOptionPane.showInputDialog(
                            "Forma de pagamento:\n1 - Pix\n2 - Cartão"
                        ));

                        Pagamento pagamento;
                        if (pg == 1) pagamento = new PagamentoPix();
                        else pagamento = new PagamentoCartao();

                        boolean ok = pagamento.processarPagamento(v.getTotal());

                        if (ok) {
                            produtos[id].diminuirEstoque(qtd);
                            loja.adicionarVenda(v.getTotal());
                            JOptionPane.showMessageDialog(null, v.gerarRelatorioVenda());
                        } else {
                            JOptionPane.showMessageDialog(null, "Pagamento NEGADO!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Produto INVÁLIDO ou estoque INSUFICIENTE!");
                    }
                }
            }

            else if (opcao == 4) {
                if (loja == null) {
                    JOptionPane.showMessageDialog(null, "CADASTRE a loja primeiro!");
                } 
                else {
                    JOptionPane.showMessageDialog(null, loja.gerarRelatorioEstoque());
                }
            }

            else if (opcao == 5) {
                JOptionPane.showMessageDialog(null, "Encerrando...");
            }

            else {
                JOptionPane.showMessageDialog(null, "Opção INVÁLIDA!");
            }
        }
    }
}
