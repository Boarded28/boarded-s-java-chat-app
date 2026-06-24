package client;
public class ChatApp {
    public static void main(String[] args) {
        client.gui.Window w = new client.gui.Window();
        w.add(new client.gui.MainPanel());
        w.start();
    }    
}