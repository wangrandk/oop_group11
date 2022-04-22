package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class UTurn extends Card {
	
	private URL UTurnImage = this.getClass().getClassLoader().getResource("view/maps/u_turn.png");
	private URL UTurnPick = this.getClass().getClassLoader().getResource("view/maps/u_turn_pick.png");
	private URL UTurnRollover = this.getClass().getClassLoader().getResource("view/maps/u_turn_pick_rollover.png");
	
	
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
