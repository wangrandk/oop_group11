package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class RotateLeft extends Card {
	
	private String cardImage = "rotate_left.png";
	private String cardImagePick = "rotate_left_pick.png";
	private String cardImagePickRollover = "rotate_left_pick_rollover.png";

	
	private final String cardRotation = "Left";

	//Constructor
	public RotateLeft(int points) {
		super("RotateLeft",points);
	}
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(0);
		robot.setCardRotation(cardRotation);
		Board.UpdateOrientation(robot);
		Board.moveRobot(robot);
		
		
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

