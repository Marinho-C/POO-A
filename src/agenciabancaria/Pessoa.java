package agencia_bancaria;

public class Pessoa {
        private String nome;
        private int senha;
        private int numeroConta;
    
        public Pessoa(String nome, int senha, int numeroConta) {
            this.nome = nome;
            this.senha = senha;
            this.numeroConta = numeroConta;
        }
    
        public String getNome() {
            return nome;
        }
    
        public int getSenha() {
            return senha;
        }
    
        public int getNumeroConta() {
            return numeroConta;
        }

    
}
