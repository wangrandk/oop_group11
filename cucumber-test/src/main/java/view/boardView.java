package view;

import java.awt.*;
import model.board.*;
import utilities.GameSettings;
import utilities.Position;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;



public class boardView extends JPanel {
	
	private Image imageBG;
	private JPanel board;
	int numCols = GameSettings.NUM_COLS;
	int numRows = GameSettings.NUM_ROWS;
	private EasyBoard easyBoard;
	
	

	
	public boardView() throws IOException {
		easyBoard = new EasyBoard();
		
	    board = new StyledJPanel(new GridLayout(numRows,numCols));
        board.setSize(1490,750);
        setLayout(null);
        imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
        board.setLocation(5, 5);
        for (int i =0; i<(numCols); i++){
            for (int j =0; j<numRows;j++) {
            	final JLabel label = new JLabel();
                label.setIcon(new ImageIcon(easyBoard.getTile(new Position(i,j)).getImage()));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                board.add(label);
            }
        }
        add(board);

        
		
		
		
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
}
	
	


