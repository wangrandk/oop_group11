package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;
import utilities.Position;

public class Teleporter extends Tile {
	
private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/conveyorbelt.png");

	
	@Override
	public void doAction(Robot robot, Player player) {
		// Nothing happens to the player
		
		for(int i=0; i<Board.board.length; i++) {
	        for(int j=0; j<Board.board[i].length; j++) {
	            if (Board.board[i][j] instanceof TeleporterSpot) {
	        		robot.setPosition(Board.board[i][j].getPosition());
	        		break;
	            }
	        }
	    }
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot); 
		
		// Set all the teleport spots to Blank
		for(int i=0; i<Board.board.length; i++) {
	        for(int j=0; j<Board.board[i].length; j++) {
	            if (Board.board[i][j] instanceof Teleporter) {
	        		Board.setTile(new BlankTile(), Board.board[i][j].getPosition());
	            }
	        }
	    }
		
		// Set initial robot position to blank tile.
		Board.setTile(new BlankTile(), robot.getInitialPosition());

		
	}


	@Override
	public URL getImage() {
		return tileImage;
	}
	

}
