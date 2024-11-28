// Arthur Aloysio Sottile Serrarens a2601338

public class Cantor extends Pessoa {
    private int anoNascimento;

    public Cantor(String nome, int anoNascimento) {
        super(nome);
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }
}
