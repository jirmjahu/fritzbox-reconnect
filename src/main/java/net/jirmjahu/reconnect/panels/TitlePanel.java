package net.jirmjahu.reconnect.panels;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    public TitlePanel() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Reconnect", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(titleLabel, BorderLayout.CENTER);
    }
}
