// NetBeans 12.0
// ARTHUR ALOYSIO SOTTILE SERRARENS

import javax.swing.*;
import java.awt.*;

public class FormPrincipal extends JFrame {
    private JMenuBar menuBar; // Variável global para evitar erro

    public FormPrincipal() {
        setTitle("MFK Records - Gerenciamento de Integrantes");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Criando a barra de menus
        menuBar = new JMenuBar();
        JMenu menuGerenciar = new JMenu("Gerenciar");
        JMenuItem itemCadastro = new JMenuItem("Cadastrar Integrante");
        JMenuItem itemEdicao = new JMenuItem("Editar Integrante");
        JMenuItem itemRemocao = new JMenuItem("Remover Integrante");
        JMenuItem itemRelatorio = new JMenuItem("Relatório");

        itemCadastro.addActionListener(e -> new FormCadastroIntegrante().setVisible(true));
        itemEdicao.addActionListener(e -> new FormEditarIntegrante().setVisible(true));
        itemRemocao.addActionListener(e -> new FormRemoverIntegrante().setVisible(true));
        itemRelatorio.addActionListener(e -> new FormRelatorioIntegrantes().setVisible(true));

        menuGerenciar.add(itemCadastro);
        menuGerenciar.add(itemEdicao);
        menuGerenciar.add(itemRemocao);
        menuGerenciar.add(itemRelatorio);
        menuBar.add(menuGerenciar);

        // Adicionando a barra de menus
        setJMenuBar(menuBar);

        // Criando um painel para os botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Criando botões com gradiente roxo
        GradientButton btnCadastro = new GradientButton("Cadastrar Integrante", new Color(123, 31, 162), new Color(81, 45, 168));
        GradientButton btnEdicao = new GradientButton("Editar Integrante", new Color(33, 150, 243), new Color(30, 136, 229));
        GradientButton btnRemocao = new GradientButton("Remover Integrante", new Color(244, 67, 54), new Color(229, 57, 53));
        GradientButton btnRelatorio = new GradientButton("Relatório", new Color(255, 152, 0), new Color(251, 140, 0));

        // Ações dos botões
        btnCadastro.addActionListener(e -> new FormCadastroIntegrante().setVisible(true));
        btnEdicao.addActionListener(e -> new FormEditarIntegrante().setVisible(true));
        btnRemocao.addActionListener(e -> new FormRemoverIntegrante().setVisible(true));
        btnRelatorio.addActionListener(e -> new FormRelatorioIntegrantes().setVisible(true));

        // Adicionando os botões ao painel
        panel.add(btnCadastro);
        panel.add(btnEdicao);
        panel.add(btnRemocao);
        panel.add(btnRelatorio);

        // Criando um título na parte superior
        JLabel lblTitulo = new JLabel("Bem-vindo ao MFK Records!", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Adicionando os componentes ao Frame
        add(lblTitulo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPrincipal().setVisible(true));
    }
}
