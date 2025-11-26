public class Loja{

    private String nome;
    private String localizacao;
    private Produto[] produtos = new Produto[5];
    private double totalVendido = 0;

    public Loja(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public boolean cadastrarProduto(int indice, Produto p) {
        if (indice < 0 || indice >= 5) {
            return false; 
        }
        
        produtos[indice] = p;
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public Produto[] getProdutos() {
        return this.produtos; 
    }

    public double getTotalVendido() {
        return this.totalVendido;
    }

    public void adicionarVenda(double valor) {
        this.totalVendido += valor;
    }

    public String gerarRelatorioEstoque() {
        String rel = " Relatório da Loja \n";
        rel += "Loja: " + nome + "\n";
        rel += "Localização: " + localizacao + "\n\n";
        
        rel += "Produtos com estoque disponível:\n";

        for (int i = 0; i < produtos.length; i++) {
            Produto p = produtos[i];

            if (p != null && p.getEstoque() > 0) {
                rel += "\nProduto " + (i + 1) + ":\n";
                rel += p.toString() + "\n";
            }
        }

        rel += "\nTotal vendido até agora: R$ " + totalVendido;

        return rel;
    }
}
