// ARTHUR ALOYSIO SOTTILE SERRARENS

import javax.swing.*;
import java.awt.*;

public class GradientButton extends JButton {
    private Color color1;
    private Color color2;

    public GradientButton(String text, Color color1, Color color2) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        setContentAreaFilled(false);
        setOpaque(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g2);
    }
}
