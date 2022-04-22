package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class RotateLeft extends Card {
	
	private URL rotateLeftImage = this.getClass().getClassLoader().getResource("view/maps/rotate_left.png");
	private URL rotateLeftPick = this.getClass().getClassLoader().getResource("view/maps/rotate_left_pick.png");
	private URL rotateLeftRollover = this.getClass().getClassLoader().getResource("view/maps/rotate_left_pick_rollover.png");
	
	
	private final String cardRotation = "Left";
	String cardmessage = "Rotated Left";

	public RotateLeft(int points) {
		super("RotateLeft",points);
	}
	
	@Override
	public void setAction(Robot robot) {
		robot.setCardRotation(cardRotation);
		Board.UpdateOrientation(robot);

	}	
	
	
}

