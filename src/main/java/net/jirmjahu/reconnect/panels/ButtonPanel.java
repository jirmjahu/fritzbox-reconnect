package net.jirmjahu.reconnect.panels;

import net.jirmjahu.reconnect.ReconnectHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        setLayout(new GridLayout(3, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton reconnectButton = new JButton("Start Reconnecting");
        JButton showAddressButton = new JButton("Show Current IP");
        JButton exitButton = new JButton("Exit");

        reconnectButton.addActionListener(e -> {
            if (ReconnectHandler.reconnect()) {
                JOptionPane.showMessageDialog(this, "Starting reconnect (It can take several seconds for your internet to come back)");
            } else {
                JOptionPane.showMessageDialog(this, "Reconnection failed");
            }
        });

        showAddressButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(URI.create("https://checkip.amazonaws.com/"));
            } catch (IOException ignored) {
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        reconnectButton.setPreferredSize(new Dimension(250, 50));
        showAddressButton.setPreferredSize(new Dimension(250, 50));
        exitButton.setPreferredSize(new Dimension(250, 50));

        add(reconnectButton);
        add(showAddressButton);
        add(exitButton);
    }
}
