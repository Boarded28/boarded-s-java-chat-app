package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {

    private final Point WINDOW_SIZE = new Point(640, 400);    

    public MainPanel() {        
        setup();        
    }

    private void setup() {
        this.setLayout(new MigLayout("fill"));
        this.setBackground(new Color(0.047f, 0.067f, 0.125f));
        var header = new HeaderDecorator();
        this.add(header, "dock north, h 35!");
    }

    class HeaderDecorator extends JPanel {
        HeaderDecorator() {            
            this.setOpaque(false);
            this.addMouseMotionListener(new MouseMotionAdapter() {
                private Point clickPoint;
                private Point mouse;
                @Override
                public void mouseMoved(MouseEvent e) {
                    clickPoint = e.getPoint();
                }
                @Override
                public void mouseDragged(MouseEvent e) {
                    var window = (JFrame) SwingUtilities.getWindowAncestor(HeaderDecorator.this);
                    mouse = e.getLocationOnScreen();
                    window.setLocation(mouse.x - clickPoint.x, mouse.y - clickPoint.y);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setPaint(new Color(0f, 0f, 0f, 0.20f));
            g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0));
            g2d.dispose();
            super.paintComponent(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_SIZE.x, WINDOW_SIZE.y);
    }
    
}
