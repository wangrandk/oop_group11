package model.tile;

import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.board.Board;
import model.card.Card;
import model.card.EmptyCard;
import model.main.Player;

public class Beer extends Tile {
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/beer.png");

	
	@Override
	public void doAction(Robot robot, Player player) {
		// player's life stays the same
	
		// Creates a copy of the hand
		ArrayList <Card> playerHandNoEmptyCards = (ArrayList<Card>) player.getHand().clone();
		
		// removes the empty cards from the hand 
		Iterator<Card> itr = playerHandNoEmptyCards.iterator();
		while(itr.hasNext()) {
			Card card = itr.next();
			if (card instanceof EmptyCard) {
		        itr.remove();
		      }
		}
		
		// Shuffles the NON played cards
		Collections.shuffle(playerHandNoEmptyCards);
		
		// Set the new cards to the players hand.
		int j =0;
		for (int i = 0; i < player.getHand().size(); i++) {
			if (player.getHand().get(i) instanceof EmptyCard) {
			}
			
			else {
				player.getHand().set(i, playerHandNoEmptyCards.get(j));
				j++;
			}

		}
	
			
			

//	
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the board with the Blank Tile for the robot's intial position
		Board.setTile(new BlankTile(), robot.getInitialPosition());
		
}
	
	private int indexOf(Card cardHand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public URL getImage() {
		return tileImage;
	}

}
