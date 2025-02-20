// ARTHUR ALOYSIO SOTTILE SERRARENS

public class Agente extends Pessoa {
    private String empresa;

    public Agente(String nome, int idade) {
        super(nome, idade);
        this.empresa = "Desconhecida";
    }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    @Override
    public String toString() {
        return super.toString() + ", Agente, Empresa: " + empresa;
    }
}
