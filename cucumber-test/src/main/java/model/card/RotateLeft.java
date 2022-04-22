package model.card;

import model.board.Board;
import model.tile.Robot;

public class RotateLeft extends Card {
	
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

