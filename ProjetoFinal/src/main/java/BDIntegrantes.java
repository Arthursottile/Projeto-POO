// ARTHUR ALOYSIO SOTTILE SERRARENS

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BDIntegrantes {
    // MÉTODO SINGLETON
    private static BDIntegrantes instance;
    private List<Pessoa> integrantes;

    private BDIntegrantes() {
        this.integrantes = new ArrayList<>();
    }

    public static BDIntegrantes getInstance() {
        if (instance == null) {
            instance = new BDIntegrantes();
        }
        return instance;
    }

    // Adicionar Integrante
    public void addIntegrante(Pessoa p) {
        if (p != null && !integrantes.contains(p)) {
            integrantes.add(p);
        }
    }

    // Buscar Integrante pelo Nome
    public Pessoa buscarIntegrante(String nome) {
        for (Pessoa p : integrantes) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    // Atualizar Integrante
    public void atualizarIntegrante(String nomeAntigo, String nomeNovo, int novaIdade) {
        Pessoa p = buscarIntegrante(nomeAntigo);
        if (p != null) {
            p.setNome(nomeNovo);
            p.setIdade(novaIdade);
        }
    }

    // Remover Integrante
    public void removerIntegrante(String nome) {
        integrantes.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    // Obter Lista de Nomes de TODOS os Integrantes
    public String[] getListaNomes() {
        return integrantes.stream().map(Pessoa::getNome).toArray(String[]::new);
    }

    // Obter Lista de Nomes SOMENTE de Cantores
    public String[] getListaCantores() {
        List<String> nomes = integrantes.stream()
                .filter(p -> p instanceof Cantor)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());

        return nomes.toArray(new String[0]);
    }

    // Obter Lista de Todos os Integrantes para Relatórios
    public List<Pessoa> getTodosIntegrantes() {
        return new ArrayList<>(integrantes);
    }

    // Verificar se um nome já existe no sistema
    public boolean nomeExiste(String nome) {
        return integrantes.stream().anyMatch(p -> p.getNome().equalsIgnoreCase(nome));
    }

    // Exibir Todos os Integrantes no Console (Para Debug)
    public void exibirTodos() {
        for (Pessoa p : integrantes) {
            System.out.println(p);
        }
    }
}
