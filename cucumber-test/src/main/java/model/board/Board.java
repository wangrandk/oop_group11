package model.board;

import model.card.Card;
import model.main.Player;
import model.tile.BlankTile;
import model.tile.Pit;
import model.tile.Robot;
import model.tile.Tile;
import model.tile.TileFactory;
import utilities.GameSettings;
import utilities.Position;
import java.util.ArrayList;


public abstract class Board {

	public static Tile[][] board;

	// Constructor
	public Board() {
		board = new Tile[GameSettings.NUM_COLS][GameSettings.NUM_ROWS];
	}

	// Populates the board depending on the game settings.
	void populateBoard(int[][] boardSettings) {
		for (int col = 0; col < GameSettings.NUM_COLS; col++) {
			for (int row = 0; row < GameSettings.NUM_ROWS; row++) {
				board[col][row] = TileFactory.getInstance().generateTile(boardSettings[row][col]);
				// Sets the Position to the corresponding place in the board.
				board[col][row].setPosition(col, row);
			}
		}
	}

	// Set Title on a specific position of the Board
	public static void setTile(Tile tile, Position position) {
		// Check the new Position
		board[position.getX()][position.getY()] = tile;
		
		// Set the tile to the old position.
		tile.setPosition(position);
	}
	
	// Set Title on a specific position of the Board
	public static void setTile(Tile tile) {
			// Check the new Position
			board[tile.getPosition().getX()][tile.getPosition().getY()] = tile;
		}
		

	// Get the Tile from a specific position
	public static Tile getTile(Position position) {
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
	

	
	// Move the robot on the board to the new robots position. 
	public static void doObstacleAction(Robot robot, Player player) {
		// Depending on the Type of Tile, it will do an action on the Player and Robot.
		Board.getTile(robot.getPosition()).doAction(robot, player);

	}	
	 
	// Updates the Position property of the robot.
	public static void moveRobot(Robot robot){
		
		// Store the initial position of the robot, before the movement
		// So we can use it later to update the previous tile.
		robot.setInitialPosition(robot.getPosition());
		Position newPosition = new Position(0,0);

		// Updates the current position of the robot.
		if (robot.getOrientation() == GameSettings.Orientation.NORTH) {
			newPosition = new Position(robot.getX(), robot.getY() - robot.getmovAmount());
		}
			
		else if (robot.getOrientation() == GameSettings.Orientation.WEST) {
			newPosition =  new Position(robot.getX() - robot.getmovAmount(), robot.getY());
		}
		else if (robot.getOrientation() == GameSettings.Orientation.SOUTH) {
			newPosition = new Position(robot.getX(), robot.getY() + robot.getmovAmount());
			
		}
		else if (robot.getOrientation() == GameSettings.Orientation.EAST) {
			newPosition = new Position(robot.getX() + robot.getmovAmount(), robot.getY());
		}
		
		// If the new position is out of bounds, set the position to the initial position
		if (newPosition.getY() >= GameSettings.NUM_ROWS || 
			newPosition.getY() < 0 ||
			newPosition.getX() >= GameSettings.NUM_COLS ||
			newPosition.getX() < 0) {
			robot.setPosition(robot.getInitialPosition());
		}
		else {
			robot.setPosition(newPosition);
		}
		
			
		
	}

	//updates robot's current orientation according to a type of received card
	public static void UpdateOrientation(Robot robot) {
		
		// IF robot has to rotate Right, get its orientation, and set a new orientation.
		if(robot.getCardRotation().equals("Right") ) {
			switch(robot.getOrientation()) {
			
			case NORTH:
				robot.setOrientation(GameSettings.Orientation.EAST);
				break;
			
			case WEST:
				robot.setOrientation(GameSettings.Orientation.NORTH);
				break;
				
			case SOUTH:
				robot.setOrientation(GameSettings.Orientation.WEST);
				break;
				
			case EAST:
				robot.setOrientation(GameSettings.Orientation.SOUTH);
				break;
			}

		}
		
		else if(robot.getCardRotation().equals("Left") ) {
							
				switch(robot.getOrientation()) {
				
				case NORTH:
					robot.setOrientation(GameSettings.Orientation.WEST);
					break;
				
				case WEST:
					robot.setOrientation(GameSettings.Orientation.SOUTH);
					break;
					
				case SOUTH:
					robot.setOrientation(GameSettings.Orientation.EAST);
					break;
					
				case EAST:
					robot.setOrientation(GameSettings.Orientation.NORTH);
					break;
				}	
			}
		
		else if(robot.getCardRotation().equals("UTurn")) {

			switch(robot.getOrientation()) {
					case NORTH:
						robot.setOrientation(GameSettings.Orientation.SOUTH);
						break;
					
					case WEST:
						robot.setOrientation(GameSettings.Orientation.EAST);
						break;
						
					case SOUTH:
						robot.setOrientation(GameSettings.Orientation.NORTH);
						break;
						
					case EAST:
						robot.setOrientation(GameSettings.Orientation.WEST);
						break;
			}   	
		}
		// Set image of the Robot for the new orientation.
		robot.setImage(robot.getOrientation());

	}	
}
