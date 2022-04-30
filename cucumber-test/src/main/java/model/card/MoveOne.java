package model.card;

import java.net.URL;

import model.board.Board;
import model.exceptions.PositionNotValidException;
import model.tile.Robot;

public class MoveOne extends Card {

	private String cardImage = "move1.png";
	private String cardImagePick = "move1_pick.png";
	private String cardImagePickRollover = "move1_pick_rollover.png";

	
	
	//Constructor
	public MoveOne(int points) {
		super("Move1",points);
		
	}
	
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(1);
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
