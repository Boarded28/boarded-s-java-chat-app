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
        this.add(new HeaderDecorator(), "dock north, h 35!");
        this.add(new LoginScreen());
    }

    private void setup() {
        this.setLayout(new MigLayout("fill"));
        this.setBackground(new Color(0.087f, 0.097f, 0.175f));
    }

    public void setCurrentPanel() {
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_SIZE.x, WINDOW_SIZE.y);
    }
    
}
