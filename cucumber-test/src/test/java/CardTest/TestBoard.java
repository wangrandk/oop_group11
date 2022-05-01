package CardTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.board.Board;
import model.board.EasyBoard;
import model.card.Deck;
import model.main.Player;
import model.tile.BlankTile;
import model.tile.Pit;
import model.tile.Robot;
import model.tile.Tile;
import utilities.Position;

public class TestBoard {
	
	Player player = new Player();
	Pit pit = new Pit();
	Board board = new EasyBoard();
	Deck deck = Deck.getInstance();
	Robot robot = new Robot();

	
	@Test
	public void pitOnEasyBoardPosition00(){
		
		assertEquals(true, board.getTile(new Position(0,0)) instanceof Tile);
		
	}
	@Test
	
	public void blankOnEasyBoardPosition10(){
		// Should return false because it has a blankTile
		assertEquals(false, board.getTile(new Position(1,0)) instanceof BlankTile);
	
		
	}
	
	@Test
	public void notPitOnEasyBoardPosition10(){
		// Should return true because it has a blankTile
		assertEquals(false, board.getTile(new Position(1,0)) instanceof Pit);
	}
	
	

}
