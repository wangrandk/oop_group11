package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;
import utilities.GameSettings;


public class RotateRight extends Card {

	private String cardImage = "rotate_right.png";
	private String cardImagePick = "rotate_right_pick.png";
	
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
	
	@Override
	public String getCardImage() {
		return cardImage;
	}
	
	@Override
	public String getCardImagePick() {
		return cardImagePick;
	}
	
}
