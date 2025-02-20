// ARTHUR ALOYSIO SOTTILE SERRARENS

public class Contrato {
    private String tipoContrato;
    private int duracaoMeses;

    public Contrato(String tipoContrato, int duracaoMeses) {
        this.tipoContrato = tipoContrato;
        this.duracaoMeses = duracaoMeses;
    }

    public String getTipoContrato() { return tipoContrato; }
    public int getDuracaoMeses() { return duracaoMeses; }

    @Override
    public String toString() {
        return "Contrato: " + tipoContrato + ", Duração: " + duracaoMeses + " meses";
    }
}
