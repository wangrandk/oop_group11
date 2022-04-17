package model.card;

import model.board.Board;
import model.tile.Robot;
import utilities.GameSettings;


public class RotateRight extends Card {
	
	 private final String cardRotation = "Right";
	String cardmessage = "Rotated Right";


	
	public RotateRight(int points) {
		super("RotateRight",points);
	}
	
	
	@Override
	public void setAction(Robot robot) {
		robot.setCardRotation(cardRotation);
		Board.UpdateOrientation(robot);

	}
	
}
