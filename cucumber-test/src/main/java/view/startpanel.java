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
	private JButton newGame;
	private JButton exitGame;
	private Image imageBG;
	private JPanel buttonPanel;
	

	
	public startpanel() throws IOException {
	    buttonPanel = new StyledJPanel(new GridLayout(2,1));
        buttonPanel.setSize(new Dimension(150,100));
        setLayout(null);
        imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
        newGame = new Button("start_btn.png","start_btn_hover.png");
        newGame.addActionListener(this);
        exitGame = new Button("exit_btn.png","exit_btn_hover.png");
        exitGame.addActionListener(this);
        buttonPanel.add(newGame);
        buttonPanel.add(exitGame);
        add(buttonPanel);
        buttonPanel.setLocation(675, 450);

        
		
		
		
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			GUI.showChooseMap();
			}
		else if (e.getSource() == exitGame) {
			System.exit(1);
		}
		}
}
	
	


