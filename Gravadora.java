// Arthur Aloysio Sottile Serrarens a2601338

public class Gravadora {
    private String nome;
    private String endereco;
    private Cantor cantor;
    private Produtor produtor;
    private Album album;

    public Gravadora(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }
}
