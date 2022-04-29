package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class MoveThree extends Card {
	

	private String cardImage = "move3.png";
	private String cardImagePick = "move3_pick.png";
	private String cardImagePickRollover = "move3_pick_rollover.png";

	//Constructor		
	public MoveThree(int points) {
		super("Move3",points);
	}
	 
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(3);
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
