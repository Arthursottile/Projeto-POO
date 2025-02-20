// ARTHUR ALOYSIO SOTTILE SERRARENS

import javax.swing.*;
import java.awt.*;

public class FormCadastroIntegrante extends JFrame {
    private JTextField txtNome, txtIdade, txtAlbuns, txtGeneroOutro;
    private JComboBox<String> cbTipo, cbGenero;
    private GradientButton btnSalvar, btnCancelar;

    public FormCadastroIntegrante() {
        setTitle("Cadastro de Integrantes");
        setSize(350, 350);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        txtNome = new JTextField(15);
        add(txtNome, gbc);

        // Idade
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Idade:"), gbc);
        gbc.gridx = 1;
        txtIdade = new JTextField(5);
        add(txtIdade, gbc);

        // Tipo
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        cbTipo = new JComboBox<>(new String[]{"Cantor", "Produtor", "Agente"});
        cbTipo.addActionListener(e -> toggleCamposExtras());
        add(cbTipo, gbc);

        // Gênero Musical (Com opção "Outro")
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Gênero Musical:"), gbc);
        gbc.gridx = 1;
        cbGenero = new JComboBox<>(new String[]{"Rock", "Pop", "Rap", "Funk", "Sertanejo", "Eletrônico", "Outro"});
        cbGenero.addActionListener(e -> toggleGeneroOutro());
        add(cbGenero, gbc);

        // Campo para inserir outro gênero musical
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Outro Gênero:"), gbc);
        gbc.gridx = 1;
        txtGeneroOutro = new JTextField(15);
        txtGeneroOutro.setEnabled(false);
        add(txtGeneroOutro, gbc);

        // Quantidade de Álbuns
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Álbuns Lançados:"), gbc);
        gbc.gridx = 1;
        txtAlbuns = new JTextField(5);
        add(txtAlbuns, gbc);

        // Botões com Gradiente Roxo
        JPanel panelButtons = new JPanel();
        btnSalvar = new GradientButton("Salvar", new Color(138, 43, 226), new Color(75, 0, 130)); // Roxo claro → Roxo escuro
        btnSalvar.addActionListener(e -> salvarIntegrante());
        panelButtons.add(btnSalvar);

        btnCancelar = new GradientButton("Cancelar", new Color(255, 69, 0), new Color(178, 34, 34)); // Laranja → Vermelho escuro
        btnCancelar.addActionListener(e -> dispose());
        panelButtons.add(btnCancelar);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(panelButtons, gbc);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void toggleCamposExtras() {
        boolean isCantor = cbTipo.getSelectedItem().equals("Cantor");
        cbGenero.setEnabled(isCantor);
        txtAlbuns.setEnabled(isCantor);
        toggleGeneroOutro();
    }

    private void toggleGeneroOutro() {
        boolean isOutro = cbGenero.getSelectedItem().equals("Outro");
        txtGeneroOutro.setEnabled(isOutro);
    }

    private void salvarIntegrante() {
        String nome = txtNome.getText();
        String idadeStr = txtIdade.getText();
        String tipo = (String) cbTipo.getSelectedItem();

        if (!nome.isEmpty() && !idadeStr.isEmpty()) {
            try {
                int idade = Integer.parseInt(idadeStr);
                Pessoa integrante;

                if (tipo.equals("Cantor")) {
                    String genero = (String) cbGenero.getSelectedItem();
                    if (genero.equals("Outro")) {
                        genero = txtGeneroOutro.getText();
                    }

                    int albuns = Integer.parseInt(txtAlbuns.getText());
                    Cantor cantor = new Cantor(nome, idade, genero);
                    cantor.setQuantidadeAlbuns(albuns);
                    integrante = cantor;
                } else if (tipo.equals("Produtor")) {
                    integrante = new Produtor(nome, idade);
                } else {
                    integrante = new Agente(nome, idade);
                }

                BDIntegrantes.getInstance().addIntegrante(integrante);
                JOptionPane.showMessageDialog(this, "Integrante cadastrado com sucesso!");
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade e álbuns devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
