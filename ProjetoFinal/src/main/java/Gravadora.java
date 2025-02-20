// ARTHUR ALOYSIO SOTTILE SERRARENS

public class Gravadora {
    private String nome;

    public Gravadora(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Gravadora: " + nome;
    }
}
