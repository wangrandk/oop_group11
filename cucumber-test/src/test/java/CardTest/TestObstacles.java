package CardTest;

import org.junit.Test;

import model.board.Board;
import model.board.EasyBoard;
import model.card.Deck;
import model.main.Player;
import model.tile.Pit;
import model.tile.Robot;

public class TestObstacles {
	
	Player player = new Player();
	Pit pit = new Pit();
	Board board = new EasyBoard();
	Deck deck = Deck.getInstance();
	Robot robot = new Robot();

	@Test
	public void testPit(){
		player.setRobot(robot);
		
		// Pit will do an Action in both the player and the robot.
		pit.doAction(robot, player);
		
		
		// Player should loose lives and returned to 
//		pit.doAction(robot);
	}
	

}
