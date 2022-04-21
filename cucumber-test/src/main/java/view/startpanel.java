package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;



public class startpanel extends JPanel implements ActionListener {
	private final JButton newGame;
	private final JButton exitGame;
	private Image imageBG;
	private final JPanel buttonPanel;
	

	
	public startpanel() {
	    buttonPanel = new StyledJPanel(new GridLayout(2,1));
        buttonPanel.setPreferredSize(new Dimension(150,100));
        try {
            imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("roborally_start.jpg could not be read");
        }        
        newGame = new Button("start_btn.png","start_btn_hover.png");
        newGame.addActionListener(this);
        exitGame = new Button("exit_btn.png","exit_btn_hover.png");
        exitGame.addActionListener(this);
        buttonPanel.add(newGame);
        buttonPanel.add(exitGame);
        buttonPanel.setLocation(425, 500);
        add(buttonPanel);
        
		
		
		
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(newGame)) {
//			GUI.showPlayersPanel();
		}
	}
	
		
}
	
	


