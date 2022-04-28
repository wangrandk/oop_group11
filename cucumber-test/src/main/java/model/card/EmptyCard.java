package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class EmptyCard extends Card {



	private String cardImage = "hidden.png";
	private String cardImagePick = "empty_pick.png";
	private String cardImagePickRollover = "empty_pick.png";

	
	
	public EmptyCard(int points) {
		super("Empty",0);
		
		//setAction method x1 (as we move only 1 tile here)
		//later: display png file according to a card
		
//		cardmessage = "Moved 1 tile";
	}
	
	
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(0);
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
