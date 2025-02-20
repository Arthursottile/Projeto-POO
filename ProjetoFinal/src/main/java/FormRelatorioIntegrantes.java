// ARTHUR ALOYSIO SOTTILE SERRARENS

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class FormRelatorioIntegrantes extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;

    public FormRelatorioIntegrantes() {
        setTitle("Relatório de Integrantes");
        setSize(600, 350);
        setLayout(new BorderLayout());

        // Criando modelo da tabela com a nova coluna "Feats"
        modelo = new DefaultTableModel(new String[]{"Nome", "Idade", "Tipo", "Feats"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botão de atualização
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> carregarDados());
        add(btnAtualizar, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        carregarDados();
    }

    private void carregarDados() {
        modelo.setRowCount(0); // Limpa a tabela antes de carregar novos dados
        List<Pessoa> lista = BDIntegrantes.getInstance().getTodosIntegrantes();
        
        for (Pessoa p : lista) {
            String feats = "-"; // Padrão para quem não é Cantor

            if (p instanceof Cantor) {
                Cantor cantor = (Cantor) p;
                if (!cantor.getFeats().isEmpty()) {
                    feats = cantor.getFeats().stream().collect(Collectors.joining(", "));
                }
            }

            modelo.addRow(new Object[]{p.getNome(), p.getIdade(), p.getClass().getSimpleName(), feats});
        }
    }
}
