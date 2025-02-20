// ARTHUR ALOYSIO SOTTILE SERRARENS

import java.util.ArrayList;
import java.util.List;

public class Cantor extends Pessoa {
    private String generoMusical;
    private int quantidadeAlbuns;
    private List<String> feats; // Reflexividade (Relacionamento com outros cantores)

    public Cantor(String nome, int idade, String generoMusical) {
        super(nome, idade);
        this.generoMusical = generoMusical;
        this.quantidadeAlbuns = 0;
        this.feats = new ArrayList<>();
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getQuantidadeAlbuns() {
        return quantidadeAlbuns;
    }

    public void setQuantidadeAlbuns(int quantidadeAlbuns) {
        this.quantidadeAlbuns = quantidadeAlbuns;
    }

    public List<String> getFeats() {
        return feats;
    }

    public void adicionarFeat(String outroArtista) {
        if (!feats.contains(outroArtista) && !outroArtista.equals(this.getNome())) {
            feats.add(outroArtista);
        }
    }

    public void removerFeat(String outroArtista) {
        feats.remove(outroArtista);
    }

    @Override
    public String toString() {
        return super.toString() + ", Gênero: " + generoMusical + ", Álbuns: " + quantidadeAlbuns +
                ", Feats: " + feats.toString();
    }
}
