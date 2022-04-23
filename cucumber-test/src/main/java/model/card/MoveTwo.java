package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class MoveTwo extends Card {
	
	private String cardImage = "move2.png";
	private String cardImagePick = "move2_pick.png";
	
	public MoveTwo(int points) {
		super("Move2",points);
	}
	
	
	
	
	String cardmessage = "Moved 2 tiles";
	
	@Override
	public String getCardImage() {
		return cardImage;
	}
	
	@Override
	public String getCardImagePick() {
		return cardImagePick;
	}

	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(2);
		Board.moveRobot(robot);
		
	}
}
