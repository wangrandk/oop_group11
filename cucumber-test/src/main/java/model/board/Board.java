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
		
		// Check which type of tile is in the Robot's new position		
		if (Board.getTile(robot.getPosition()) instanceof Pit) {
			// player looses life
			player.looseLife();
			
			// Robot return to the last check point
			robot.setPosition(robot.getCheckPoints().get(robot.getCheckPoints().size() - 1));
			
			// Move the robot on the board with to the new Position.
			Board.setTile(robot);
			
			// Update the board with the 
			Board.setTile(new BlankTile(), robot.getInitialPosition());
		}
		
//		switch(robot.getPosition()) {
//		case instanceof Pit:
//			if (robot.getCheckPoints().size() != 0) {
//				robot.setPosition(robot.getCheckPoints().get(robot.getCheckPoints().size() - 1));
//				
//			}
//			else {
//				robot.setPosition(null);
//			}
//		}
	}
	
	// Updates the Position property of the robot.
	public static void moveRobot(Robot robot) {
		// Store the initial position of the robot, before the movement.
		robot.setInitialPosition(robot.getPosition());
		
		// Updates the current position of the robot.
		if (robot.getOrientation() == GameSettings.Orientation.NORTH) {
			robot.setPosition(new Position(robot.getX(), robot.getY() + robot.getmovAmount()));
		}
		if (robot.getOrientation() == GameSettings.Orientation.WEST) {
			robot.setPosition(new Position(robot.getX() - robot.getmovAmount(), robot.getY()));
		}
		if (robot.getOrientation() == GameSettings.Orientation.SOUTH) {
			robot.setPosition(new Position(robot.getX(), robot.getY() - robot.getmovAmount()));
		}
		if (robot.getOrientation() == GameSettings.Orientation.EAST) {
			robot.setPosition(new Position(robot.getX() + robot.getmovAmount(), robot.getY()));
		}
	}

	/*
	 * Player {}
	 */
	public static void UpdateOrientation(Robot robot) {
		
		if(robot.getCardRotation() == "Right") {
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
				
			default:
				System.out.println("~ Don't know robot now orientation ~");
			}}
		
		if(robot.getCardRotation() == "Left") {
							
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
					
				default:
					System.out.println("~ Don't know robot now orientation ~");
				}	
			}
		
		if(robot.getCardRotation() == "UTurn") {

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
					default:
						System.out.println("~ Don't know robot now orientation ~");
			}   	
		}	
	}	
}
