package BoardTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import model.board.Board;
import model.board.EasyBoard;
import model.tile.Tile;
import utilities.Position;

public class TestBoard {
	
	
	Board board = new EasyBoard();
	
	
	@Test
	public void testIfReturnsAPosition() {
		Tile randomTile = board.getTile(new Position (0,0));
		
		assertNotNull(randomTile.getPosition());
		
	}
	
	@Test
	public void xShouldBe1YshouldBe2() {
		Tile randomTile = board.getTile(new Position (1,2));
		
		// Assert X
		assertEquals(1,randomTile.getPosition().getX());
		
		// Assert Y
		assertEquals(2,randomTile.getPosition().getY());
		
	}
	
	

}
