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

	
	public gamePanel() throws IOException {
		setLayout(null);
		setSize(1000,1000);
		boardView = new boardView(board);
		controlView = new controlView();
		add(boardView);
		add(controlView);
		revalidate();
		repaint();
		
	}
	
	public Player getPlayer() {
        return player;
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

	//////////////////////////////////////////////////////////////////////////////////////7
	public boardView getBoardView() {
		return this.boardView;
	}

	public controlView getControlView() {
		return this.controlView;
	}

}
