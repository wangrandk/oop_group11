package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class MoveTwo extends Card {
	
	private URL cardImage = this.getClass().getClassLoader().getResource("view/move2.png");
	private URL cardImagePick = this.getClass().getClassLoader().getResource("view/move2_pick.png");

	public MoveTwo(int points) {
		super("Move2",points);
	}
	
	
	
	
	String cardmessage = "Moved 2 tiles";
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(2);
		Board.moveRobot(robot);
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
