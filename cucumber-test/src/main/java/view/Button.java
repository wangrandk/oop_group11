package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;


class Button extends JButton {

    
    public Button (String normal){
        this.setIcon(createIcon(this.getClass().getClassLoader().getResource("view/" + normal)));
        styleButton();
    }

    
    public Button (String normal, String hover){
        this(normal);
        this.setRolloverIcon(createIcon(this.getClass().getClassLoader().getResource("view/" + hover)));
    }

    
    private ImageIcon createIcon(URL url){
        BufferedImage bi;
        try {
            bi = ImageIO.read(url);
            return new ImageIcon(bi);
        } catch(java.io.IOException e){
            System.out.println("Image could not be read");
        }
        return null;
    }

    private void styleButton(){
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }
}
