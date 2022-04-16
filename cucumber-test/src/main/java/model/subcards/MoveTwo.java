package model.subcards;

import model.tile.Robot;

public class MoveTwo extends Card {

	public MoveTwo(int points) {
		super("Move2",points);
	}
	
	
	
	
	String cardmessage = "Moved 2 tiles";
	
	@Override
	public void setAction(Robot robot) {
		robot.setmovAmount(2);
		robot.UpdatePosition();
		//setdirection ako je rotate
	}
}
