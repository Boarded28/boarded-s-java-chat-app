package client.gui.components;

import javax.swing.JTextField;

public class CustomTextfield extends JTextField {
    
    public CustomTextfield(String text) {
        super(text);
        init();
    }

    public CustomTextfield() {
        init();
    }

    private void init() {
        setRoundedRect(0, 0, 0, "#ffffff", "#000000");
    }

    public void setShape(int w, int h, int arc, String bg, String fg) {
        var style = String.format("borderwidth:0; " +
        "focusWidth:0; " + 
        "placeholderForeground:#0000003d; " +
        "minimumWidth:%d; " + 
        "minimumHeight:%d; " + 
        "arc:%d", 
        w, h, arc);
        this.putClientProperty("FlatLaf.style", style);
    }

    public void setRoundedRect(int w, int h, int r, String bg, String fg) {
        setShape(w, h, r, bg, fg);
    }

    public void setSquare(int w, int h, String bg, String fg) {
        setShape(w, h, 0, bg, fg);
    }
}
