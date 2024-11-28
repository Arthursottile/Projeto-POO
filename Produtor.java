// Arthur Aloysio Sottile Serrarens a2601338

public class Produtor extends Pessoa {
    private int anoNascimento;

    public Produtor(String nome, int anoNascimento) {
        super(nome);
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }
}
