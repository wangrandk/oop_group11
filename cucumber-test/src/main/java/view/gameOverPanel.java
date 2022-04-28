package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.main.Player;
import utilities.GameSettings;



public class gameOverPanel extends JPanel {
	private JLabel messageLabel;
	private Image imageBG;
	private JPanel messagePanel;
	String bg = GameSettings.BACKGROUND;

	

	
	public gameOverPanel(Player player) throws IOException {
	    messagePanel = new JPanel(null) {
	    	protected void paintComponent(Graphics g)
	        {
	            g.setColor( getBackground() );
	            g.fillRect(0, 0, getWidth(), getHeight());
	            super.paintComponent(g);
	        }
	    };
	    messagePanel.setOpaque(false); // background of parent will be painted first
	    messagePanel.setBackground( new Color(38, 159, 55, 175) );
	    messagePanel.setSize(600,400);
        setLayout(null);
        imageBG = ImageIO.read(this.getClass().getClassLoader().getResource(bg));
        
        
        messageLabel = new JLabel("<html>Congratulations " + player.getRobot().getName() + "!! <br> You have conquered the game of RoboRally this time. <br> The Game is over! <br> Restart the application to play again.",JLabel.CENTER);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Impact",Font.PLAIN,26));

        messageLabel.setSize(600,400);
        messageLabel.setLocation(0, 0);

        
        messagePanel.add(messageLabel);
        messagePanel.setLocation(200, 300);
        add(messagePanel);

        
		
		
		
	}

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	
}
	
	


