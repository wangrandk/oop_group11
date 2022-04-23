package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class MoveThree extends Card {
	
	private URL cardImage = this.getClass().getClassLoader().getResource("view/move3.png");
	private URL cardImagePick = this.getClass().getClassLoader().getResource("view/move3_pick.png");
	
	public MoveThree(int points) {
		super("Move3",points);
	}
	
	
	String cardmessage = "Moved 3 tiles";
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(3);
		Board.moveRobot(robot);
		//setdirection ako je rotate
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
