package model.card;

import java.net.URL;

import model.board.Board;
import model.tile.Robot;

public class MoveTwo extends Card {
	
	private URL cardImage = this.getClass().getClassLoader().getResource("view/maps/move2.png");
	//private URL move2ImagePick = this.getClass().getClassLoader().getResource("view/maps/move2_pick.png");
	//private URL move2ImageRollover = this.getClass().getClassLoader().getResource("view/maps/move2_pick_rollover.png");

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
}
