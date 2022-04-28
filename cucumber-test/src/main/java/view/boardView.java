package view;

import java.awt.*;
import model.board.*;
import model.tile.Tile;
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
	
	private JPanel grid;
	int numCols = GameSettings.NUM_COLS;
	int numRows = GameSettings.NUM_ROWS;
	int tileSize = GameSettings.TILE_SIZE;
	
	

	
	public boardView() throws IOException {
		setLayout(null);
		setSize(tileSize*numCols,tileSize*numRows);
		setLocation(5,5);
	    grid = new StyledJPanel(new GridLayout(numRows,numCols));
        grid.setSize(tileSize*numCols,tileSize*numRows);
        for (int i =0; i<(numRows); i++){
            for (int j =0; j<numCols;j++) {
            	final JLabel label = new JLabel();
                label.setIcon(new ImageIcon(Board.getTile(new Position(j,i)).getImage()));
//                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grid.add(label);
            }
        }
        add(grid);       
		
		
		
	}
	
	public void update() {
		grid.revalidate();
	}
	
}
	
	


