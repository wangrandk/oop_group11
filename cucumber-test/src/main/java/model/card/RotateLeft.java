package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class RotateLeft extends Card {
	
	private URL cardImage = this.getClass().getClassLoader().getResource("view/rotate_left.png");
	private URL cardImagePick = this.getClass().getClassLoader().getResource("view/rotate_left_pick.png");
	
	
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
	
	@Override
	public URL getCardImage() {
		return cardImage;
	}
	
	@Override
	public URL getCardImagePick() {
		return cardImagePick;
	}
	
	
}

