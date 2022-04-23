package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class UTurn extends Card {
	
	private URL cardImage = this.getClass().getClassLoader().getResource("view/u_turn.png");
	private URL cardImagePick = this.getClass().getClassLoader().getResource("view/u_turn_pick.png");
	
	
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
	
	@Override
	public URL getCardImage() {
		return cardImage;
	}
	
	@Override
	public URL getCardImagePick() {
		return cardImagePick;
	}
}
