// Arthur Aloysio Sottile Serrarens a2601338

public class Album {
    private String titulo;
    private int anoLancamento;
    private int faixas;
    private String genero;
    private Gravadora gravadora;
    private Produtor produtor;

    public Album(String titulo, int anoLancamento, int faixas, String genero, Gravadora gravadora) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = faixas;
        this.genero = genero;
        this.gravadora = gravadora;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public String exibirInformacoes() {
        return "Titulo: " + titulo + "\nAno: " + anoLancamento + "\nFaixas: " + faixas +
               "\nProdutor: " + produtor.getNome() + "\nGenero: " + genero;
    }
}
