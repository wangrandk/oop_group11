package cucumbertest;

import model.tile.Tile;
import model.tile.TileFactory;
import utilities.GameSettings;

public class Board {
	
	private Tile [][] board;
	private int [][] boardSettings;
	private String difficulty;
	
	
	private Board(String difficulty){
		
		switch(difficulty){  
	    //Case statements  
		    case "Easy": 
		    	boardSettings = 
		    	break;  
		    
		    case "Medium":
		    	
		    	break;
		    case "Hard":
		    	
		    	break;
	    }  
		
	}
	
	// Populates the board depending on the game settings.
	 void populateBoard(int[][] boardSettings) {
	        for (int col = 0; col < GameSettings.NUM_COLS; col++) {
	            for (int row = 0; row < GameSettings.NUM_ROWS; row++) {
	                board[col][row] = TileFactory.getInstance().generateTile(boardSettings[row][col]);
	            }
	        }
	    }
	
	
	public void setTile(Tile tile, Position position) {
		board[position.getX()][position.getY()] = tile;
	}
	
	
	
}
