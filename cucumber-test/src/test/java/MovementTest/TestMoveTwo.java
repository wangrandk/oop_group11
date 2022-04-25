package MovementTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.board.BlankBoard;
import model.board.Board;
import model.card.Deck;
import model.card.MoveOne;
import model.card.MoveTwo;
import model.main.Player;
import model.tile.Pit;
import model.tile.Robot;
import utilities.Position;

public class TestMoveTwo {
	
	/**
	 * Robot cannot jump over obstacles.
	 * If there is a Pit in (1,0), AND Robot is on (0,0), If move two, it should die anyways.
	 */
	
	Deck deck = Deck.getInstance();
	Board board = new BlankBoard();
	Player player = new Player();	
	Robot robot = new Robot();
	MoveTwo move2 = new MoveTwo(610);
	MoveOne move1 = new MoveOne(610);
	Position initialPosition;

	
	@Test
	public void robotShouldDieIfThereIsAPitonItsWay() {
		
	
	}
}
