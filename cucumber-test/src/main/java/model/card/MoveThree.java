package model.card;

import model.board.Board;
import model.tile.Robot;

public class MoveThree extends Card {
	
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
	
}
