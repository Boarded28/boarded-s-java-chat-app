package client.gui;

import javax.swing.JPanel;

import client.gui.components.CustomTextfield;
import net.miginfocom.swing.MigLayout;

public class LoginScreen extends JPanel {
    
    public LoginScreen() {
        this.setLayout(new MigLayout());
        this.setOpaque(false);

        var nameField = new CustomTextfield();
        nameField.setRoundedRect(100, 50, 30, "#ffffff", "#000000");
        this.add(nameField, "w 150!, east");
    }
}
