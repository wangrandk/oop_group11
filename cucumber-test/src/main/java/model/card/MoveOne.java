package model.card;

import model.tile.Robot;

public class MoveOne extends Card {
	

	
	public MoveOne(int points) {
		super("Move1",points);
		
		//setAction method x1 (as we move only 1 tile here)
		//later: display png file according to a card
		
		cardmessage = "Moved 1 tile";
	}
	
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(1);
		robot.UpdatePosition();
		//setdirection ako je rotate
	}
}
