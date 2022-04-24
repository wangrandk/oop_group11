package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.board.Board;
import model.main.Player;

public class gamePanel extends JPanel {
	private boardView boardView;
	private controlView controlView;
	private Image imageBG;
	private Player player;
	private Board board;

	
	public gamePanel(Player player, Board board) throws IOException {
		setLayout(null);
		setSize(1000,1000);
		boardView = new boardView(board);
		controlView = new controlView(player,board);
		add(boardView);
		add(controlView);
		revalidate();
		repaint();
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	
	public void update() {
		revalidate();
		repaint();
	}

}
