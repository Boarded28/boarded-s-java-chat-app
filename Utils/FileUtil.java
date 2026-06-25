package Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FileUtil {
        
    public static ImageIcon getIcon(String image) {
        var imageFile = new File("assets", image);
        if (!imageFile.exists()) {
            System.out.println("No image found: " + image);
            return null;
        }

        try {
            BufferedImage img = ImageIO.read(imageFile);
            return new ImageIcon(img);
        } catch (IOException e) {
            System.out.println("Error reading image: " + image);
            return null;
        }
    }
}
