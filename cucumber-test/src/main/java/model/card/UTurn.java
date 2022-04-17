package model.card;

import model.board.Board;
import model.tile.Robot;

public class UTurn extends Card {
	
	private final String cardRotation = "UTurn";
	String cardmessage = "U Turned";

	
	public UTurn(int points) {
		super("UTurn",points);
	}
	

	@Override
	public void setAction(Robot robot) {
		robot.setCardRotation(cardRotation);
		Board.UpdateOrientation(robot);
	}
}
