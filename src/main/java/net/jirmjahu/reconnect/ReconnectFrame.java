package net.jirmjahu.reconnect;

import com.formdev.flatlaf.FlatDarkLaf;
import net.jirmjahu.reconnect.panels.ButtonPanel;
import net.jirmjahu.reconnect.panels.TitlePanel;

import javax.swing.*;
import java.awt.*;

public class ReconnectFrame extends JFrame {

    public ReconnectFrame() {
        FlatDarkLaf.setup();
        JFrame frame = new JFrame("Reconnect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.add(new TitlePanel(), BorderLayout.NORTH);
        frame.add(new ButtonPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
