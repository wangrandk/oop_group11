package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class gamePanel extends JPanel {
	private boardView boardView;
	private controlView controlView;
	private Image imageBG;

	
	public gamePanel() throws IOException {
		setLayout(null);
		setSize(1000,1000);
        imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
		boardView = new boardView();
		controlView = new controlView();
		add(boardView);
		add(controlView);
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }

}
