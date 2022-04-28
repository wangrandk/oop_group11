package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;
import utilities.GameSettings;


public class RotateRight extends Card {

	private String cardImage = "rotate_right.png";
	private String cardImagePick = "rotate_right_pick.png";
	private String cardImagePickRollover = "rotate_right_pick_rollover.png";

	
	private final String cardRotation = "Right";
	String cardmessage = "Rotated Right";


	
	public RotateRight(int points) {
		super("RotateRight",points);
	}
	
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(0);
		Board.moveRobot(robot);
		robot.setCardRotation(cardRotation);
		Board.UpdateOrientation(robot);

	}
	
	@Override
	public String getCardImage() {
		return cardImage;
	}
	
	@Override
	public String getCardImagePick() {
		return cardImagePick;
	}

	@Override
	public String getCardImagePickRollover() {
		return cardImagePickRollover;
	}
	
}
