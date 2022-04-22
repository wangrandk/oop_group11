package controller;


import model.Game;
import model.board.Board;
import model.main.Player;
import model.tile.Robot;

public class RobotController {
	
	private Robot robot;
	private Board board;
	private Player player;
	private Game game;
	
	public RobotController(Game game) {
		//this.game=game
		//this.view=view
	}
	
	public void updateRobotPosition(Robot robot) {
		Board.moveRobot(robot);
		//update the view
	}
	
	public void updateRobotOrientation(Robot robot) {
		Board.UpdateOrientation(robot);
		//update the view
	}
	
}
