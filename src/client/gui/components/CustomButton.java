package client.gui.components;

import javax.swing.Icon;
import javax.swing.JButton;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        init();
    }

    public CustomButton(Icon icon) {
        super(icon);
        init();
    }

    public CustomButton() {
        init();
    }


    private void init() {
        this.setFocusable(false);
        setShape(50, 50, 999, "#ffffff", "#000000");
    }

    public void setShape(int w, int h, int arc, String bg, String fg) {
        String style = String.format(
            "arc:%d; minimumWidth:%d; minimumHeight:%d; background:%s; foreground:%s; focusWidth:0; borderWidth:0;",
        arc, w, h, bg, fg);
        this.putClientProperty("FlatLaf.style", style);
        this.setPreferredSize(new java.awt.Dimension(w,h));
        this.revalidate();
        this.repaint();
    }
    
    public void setCircular(int diameter, String bg, String fg) {
        setShape(diameter, diameter, 999 , bg, fg);
    }

    public void setRoundedRect(int w, int h, int r, String bg, String fg) {
        setShape(w, h, r, bg, fg);
    }

    public void setSquare(int w, int h, String bg, String fg) {
        setShape(w, h, 0, bg, fg);
    }
}
