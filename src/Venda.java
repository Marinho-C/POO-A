public class Venda {

    private Produto produtos;
    private int quantidade;
    private double total;

    public Venda(Produto produtos, int quantidade) {
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.total = quantidade * produtos.getPreco();
    }

    public double getTotal() {
        return total;
    }

    public Produto getProduto() {
        return produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String gerarRelatorioVenda() {
        return " RELATÓRIO DA VENDA \n" +
               "\nProduto: " + produtos.getDescricao() + 
               "\nPreço unitário: R$ " + produtos.getPreco() + 
               "\nQuantidade: " + quantidade + 
               "\nTOTAL: R$ " + total ;
    }
}
