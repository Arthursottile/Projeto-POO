// ARTHUR ALOYSIO SOTTILE SERRARENS

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class FormEditarIntegrante extends JFrame {
    private JComboBox<String> cbNome, cbFeats;
    private JTextField txtNomeNovo, txtIdadeNova;
    private JButton btnSalvar, btnCancelar, btnAdicionarFeat, btnRemoverFeat;
    private JList<String> listFeats;
    private DefaultListModel<String> featsModel;

    public FormEditarIntegrante() {
        setTitle("Editar Integrante");
        setSize(400, 350);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Selecionar integrante
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Selecione o Integrante:"), gbc);
        gbc.gridx = 1;
        cbNome = new JComboBox<>(BDIntegrantes.getInstance().getListaNomes());
        cbNome.addActionListener(e -> carregarDadosIntegrante());
        add(cbNome, gbc);

        // Novo Nome
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Novo Nome:"), gbc);
        gbc.gridx = 1;
        txtNomeNovo = new JTextField(15);
        add(txtNomeNovo, gbc);

        // Nova Idade
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Nova Idade:"), gbc);
        gbc.gridx = 1;
        txtIdadeNova = new JTextField(5);
        add(txtIdadeNova, gbc);

        // Lista de Feats
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Feats:"), gbc);
        gbc.gridx = 1;
        featsModel = new DefaultListModel<>();
        listFeats = new JList<>(featsModel);
        JScrollPane scrollFeats = new JScrollPane(listFeats);
        scrollFeats.setPreferredSize(new Dimension(150, 60));
        add(scrollFeats, gbc);

        // Selecionar feat para adicionar
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Adicionar Feat com:"), gbc);
        gbc.gridx = 1;
        cbFeats = new JComboBox<>(BDIntegrantes.getInstance().getListaNomes());
        add(cbFeats, gbc);

        // Botões de Feats
        JPanel panelFeats = new JPanel();
        btnAdicionarFeat = new JButton("Adicionar Feat");
        btnAdicionarFeat.addActionListener(e -> adicionarFeat());
        panelFeats.add(btnAdicionarFeat);

        btnRemoverFeat = new JButton("Remover Feat");
        btnRemoverFeat.addActionListener(e -> removerFeat());
        panelFeats.add(btnRemoverFeat);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(panelFeats, gbc);

        // Botões de salvar e cancelar
        JPanel panelButtons = new JPanel();
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarAlteracoes());
        panelButtons.add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelButtons.add(btnCancelar);

        gbc.gridy = 6;
        add(panelButtons, gbc);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void carregarDadosIntegrante() {
        String nomeSelecionado = (String) cbNome.getSelectedItem();
        Pessoa p = BDIntegrantes.getInstance().buscarIntegrante(nomeSelecionado);
        if (p instanceof Cantor) {
            Cantor cantor = (Cantor) p;
            txtNomeNovo.setText(cantor.getNome());
            txtIdadeNova.setText(String.valueOf(cantor.getIdade()));

            // Atualiza a lista de feats
            featsModel.clear();
            for (String feat : cantor.getFeats()) {
                featsModel.addElement(feat);
            }
        }
    }

    private void adicionarFeat() {
        String nomeSelecionado = (String) cbNome.getSelectedItem();
        String featSelecionado = (String) cbFeats.getSelectedItem();
        Pessoa p = BDIntegrantes.getInstance().buscarIntegrante(nomeSelecionado);

        if (p instanceof Cantor && featSelecionado != null) {
            Cantor cantor = (Cantor) p;
            cantor.adicionarFeat(featSelecionado);
            featsModel.addElement(featSelecionado);
        }
    }

    private void removerFeat() {
        String nomeSelecionado = (String) cbNome.getSelectedItem();
        String featSelecionado = listFeats.getSelectedValue();
        Pessoa p = BDIntegrantes.getInstance().buscarIntegrante(nomeSelecionado);

        if (p instanceof Cantor && featSelecionado != null) {
            Cantor cantor = (Cantor) p;
            cantor.removerFeat(featSelecionado);
            featsModel.removeElement(featSelecionado);
        }
    }

    private void salvarAlteracoes() {
        JOptionPane.showMessageDialog(this, "Alterações salvas!");
        dispose();
    }
}
