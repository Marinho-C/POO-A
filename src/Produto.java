public class Produto{
    private String codigoBarras;
    private String descricao;
    private double preco;
    private int estoque;
    
    
    public Produto (String codigoBarras, String descricao, double preco, int estoque){
        this.codigoBarras = codigoBarras;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getCodigoBarras(){
        return this.codigoBarras;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean diminuirEstoque(int quantidade) {
        if (quantidade <= 0) {
            return false; 
        }
        if (quantidade > this.estoque) {
            return false; 
        }
        this.estoque -= quantidade;
        return true;
    }

    @Override
    public String toString(){
       return "Codigo de Barras: " + getCodigoBarras() + "\nDescrição do Produto: " + getDescricao() + "\nPreço: " + getPreco() + "\nEstoque: " + getEstoque();
    }




}
