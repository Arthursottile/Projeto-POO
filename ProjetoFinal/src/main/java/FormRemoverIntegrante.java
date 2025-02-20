// ARTHUR ALOYSIO SOTTILE SERRARENS

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormRemoverIntegrante extends JFrame {
    private JComboBox<String> cbIntegrantes;
    private JButton btnRemover;

    public FormRemoverIntegrante() {
        setTitle("Remover Integrante");
        setSize(350, 150);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Label e ComboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Escolha o Integrante:"), gbc);

        gbc.gridx = 1;
        cbIntegrantes = new JComboBox<>();
        carregarLista();
        add(cbIntegrantes, gbc);

        // Botão de Remover
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        btnRemover = new JButton("Remover");
        btnRemover.addActionListener(e -> removerIntegrante());
        add(btnRemover, gbc);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void carregarLista() {
        cbIntegrantes.removeAllItems(); // Limpa a lista antes de recarregar
        List<Pessoa> lista = BDIntegrantes.getInstance().getTodosIntegrantes();
        for (Pessoa p : lista) {
            cbIntegrantes.addItem(p.getNome());
        }
    }

    private void removerIntegrante() {
        String nome = (String) cbIntegrantes.getSelectedItem();
        if (nome != null) {
            BDIntegrantes.getInstance().removerIntegrante(nome);
            JOptionPane.showMessageDialog(this, "Integrante removido com sucesso!");
            carregarLista(); // Atualiza a lista para refletir a remoção
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum integrante selecionado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
