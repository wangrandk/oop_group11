package model.board;

import model.tile.Robot;
import model.tile.Tile;
import model.tile.TileFactory;
import utilities.GameSettings;
import utilities.Position;

public abstract class Board {
	
	private final Tile [][] board;
	
	
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
	
	
	// Verifies if the movement is valid 
//	public boolean isValidPosition(Position newPosition) {
//	    this.nx = newPosition.x; 
//	    this.ny = newPosition.y; 
//		if(Position.isEmpty(this.nx, this.ny) == true ) {
//			return true;
//		}
//		return false;
//	}
	
	
	

	public void moveRobot(Robot robot) {
		if( robot.getOrientation() == GameSettings.Orientation.NORTH) {
	    	robot.setPosition(new Position(robot.getX(), robot.getY() + robot.getmovAmount()));
	 	  }
	    if(robot.getOrientation() == GameSettings.Orientation.WEST) {
	    	Robot.x = Robot.x - this.movAmount;   //+-1 replaced with movAmount (so that it can be 1,2,3)
	    }
	    if( robot.getOrientation() ==GameSettings.Orientation.SOUTH) {
	    	Robot.y = Robot.y - this.movAmount;
	    }
	    if( robot.getOrientation() == GameSettings.Orientation.EAST) {
	    	Robot.x = Robot.x + this.movAmount;
	    }
	}

	
	
}
