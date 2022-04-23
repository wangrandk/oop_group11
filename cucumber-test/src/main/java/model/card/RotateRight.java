package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;
import utilities.GameSettings;


public class RotateRight extends Card {
	
	private URL cardImage = this.getClass().getClassLoader().getResource("view/rotate_right.png");
	private URL cardImagePick = this.getClass().getClassLoader().getResource("view/rotate_right_pick.png");
	
	
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
	public URL getCardImage() {
		return cardImage;
	}
	
	@Override
	public URL getCardImagePick() {
		return cardImagePick;
	}
	
}
