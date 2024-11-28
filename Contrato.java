// Arthur Aloysio Sottile Serrarens a2601338

public class Contrato {
    private String dataInicio;
    private String dataFim;
    private double valor;
    private int numeroAlbuns;
    private Cantor cantor;
    private Gravadora gravadora;

    public Contrato(String dataInicio, String dataFim, double valor, int numeroAlbuns, Cantor cantor, Gravadora gravadora) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.numeroAlbuns = numeroAlbuns;
        this.cantor = cantor;
        this.gravadora = gravadora;
    }

    public boolean validarContrato() {
        return numeroAlbuns > 0 && valor > 0;
    }

    public void finalizarContrato() {
        this.dataFim = "Contrato finalizado";
    }
}
