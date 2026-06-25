package client.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import Utils.FileUtil;
import client.gui.components.CustomButton;
import net.miginfocom.swing.MigLayout;

class HeaderDecorator extends JPanel {

    public HeaderDecorator() {
        this.setLayout(new MigLayout("", "[grow][pref]10[pref]", ""));       
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
        
        var closeButton = new CustomButton(FileUtil.getIcon("ExitIcon.png"));
        closeButton.setCircular(20, "#ff3d33", "#812c28");
        closeButton.addActionListener(e -> {
            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(closeButton);
            window.dispose();
            System.exit(0);
        });

        var minimizeButton = new CustomButton(FileUtil.getIcon("MinimizeIcon.png"));
        minimizeButton.setCircular(20, "#36e036", "#296d21b0");
        minimizeButton.addActionListener(e -> {
            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(minimizeButton);
            window.setState(Frame.ICONIFIED);
        });

        this.add(closeButton, "cell 2 0, al right, w 20!, h 20!");
        this.add(minimizeButton, "cell 1 0, al right, w 20!, h 20!");
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