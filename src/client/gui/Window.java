package client.gui;

import java.awt.geom.RoundRectangle2D;

import com.formdev.flatlaf.FlatLightLaf;

public class Window extends javax.swing.JFrame {

    public Window() {        
        setFrame();
    }    

    private void setFrame() {
        FlatLightLaf.setup();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
    }

    public void start() {
        this.pack();
        this.setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
