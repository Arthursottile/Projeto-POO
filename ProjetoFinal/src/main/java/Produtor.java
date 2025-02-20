// ARTHUR ALOYSIO SOTTILE SERRARENS

public class Produtor extends Pessoa {
    private int quantidadeAlbunsProduzidos;

    public Produtor(String nome, int idade) {
        super(nome, idade);
        this.quantidadeAlbunsProduzidos = 0;
    }

    public int getQuantidadeAlbunsProduzidos() { return quantidadeAlbunsProduzidos; }
    public void setQuantidadeAlbunsProduzidos(int quantidadeAlbunsProduzidos) { this.quantidadeAlbunsProduzidos = quantidadeAlbunsProduzidos; }

    @Override
    public String toString() {
        return super.toString() + ", Produtor, Álbuns Produzidos: " + quantidadeAlbunsProduzidos;
    }
}
