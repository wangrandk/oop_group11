package model.board;

import model.tile.Tile;
import model.tile.TileFactory;
import utilities.GameSettings;
import utilities.Position;

public abstract class Board {
	
	private final Tile [][] board;
	private String difficulty;
	
	
	// Constructor
	public Board(){
        this.board = new Tile[GameSettings.NUM_COLS][GameSettings.NUM_ROWS];
	}
	
	// Populates the board depending on the game settings.
	 void populateBoard(int[][] boardSettings) {
	        for (int col = 0; col < GameSettings.NUM_COLS; col++) {
	            for (int row = 0; row < GameSettings.NUM_ROWS; row++) {
	                board[col][row] = TileFactory.getInstance().generateTile(boardSettings[row][col]);
	            }
	        }
	    }
	
	// Set Title on a specific position of the Board
	public void setTile(Tile tile, Position position) {
		board[position.getX()][position.getY()] = tile;
	}
	
	// Get the Tile from a specific position
	public Tile getTile(Position position) {
		return board[position.getX()][position.getY()];
	}
	
	
	
}
