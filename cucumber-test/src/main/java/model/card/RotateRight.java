package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;
import utilities.GameSettings;


public class RotateRight extends Card {
	
	private URL rotateRightImage = this.getClass().getClassLoader().getResource("view/maps/rotate_right.png");
	private URL rotateRightPick = this.getClass().getClassLoader().getResource("view/maps/rotate_right_pick.png");
	private URL rotateRightRollover = this.getClass().getClassLoader().getResource("view/maps/rotate_right_pick_rollover.png");
	
	
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
