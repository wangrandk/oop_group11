package CardTest;
import static org.junit.Assert.*;

import org.junit.Test;

import decks.Deck;
import model.tile.Robot;

public class TestGiveCard {
	
	Deck deck = Deck.getInstance();
	Robot robot = new Robot(0,0);
	

	@Test
	public void testGiveCard() {			
		int subdeckSize = robot.subdeck.size();  //initalize subdeck
		int handSize = robot.hand.size();                 //initialize hand
		
		assertEquals(robot.subdeck.size(),9);		   //give value to subdeck
		assertEquals(robot.hand.size(),0);  
		
		robot.giveCard(robot.subdeck.get(0));		
		assertEquals(robot.subdeck.size(), subdeckSize-1);		  
		assertEquals(robot.hand.size(), handSize+1);		
				
	}

	
}