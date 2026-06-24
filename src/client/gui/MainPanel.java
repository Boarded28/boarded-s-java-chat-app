package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {

    private final Point WINDOW_SIZE = new Point(640, 400);

    public MainPanel() {
        setup();
    }

    private void setup() {
        this.setLayout(new MigLayout());
        this.setBackground(new Color(0.047f, 0.067f, 0.125f ));

        var header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setSize(10, 10);
        this.add(header, "span 3 0");
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_SIZE.x, WINDOW_SIZE.y);
    }
    
}
