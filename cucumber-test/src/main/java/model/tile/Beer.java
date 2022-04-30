package model.tile;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import model.board.Board;
import model.card.Card;
import model.card.EmptyCard;
import model.main.Player;

public class Beer extends Tile {
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/beer.png");

	
	@Override
	public void doAction(Robot robot, Player player) {
		// player's life stays the same
		
		/**
		 * Loop through the players hand
		 * while 
		 */
		
		
		
		ArrayList <Card> playerHandNoEmptyCards = (ArrayList<Card>) player.getHand().clone();
		
		playerHandNoEmptyCards.removeIf(i -> i instanceof EmptyCard);
	
		
		int j =0;
		for (int i = 0; i < player.getHand().size(); i++) {
			if (player.getHand().get(i) instanceof EmptyCard) {
				j++;
			}
			
			else {
				player.getHand().set(i, playerHandNoEmptyCards.get(i-j));
			}
		}
		
	
			
			
			// Now cards are not Empty.
//			else if {
//				for (int i = 0; i < playerHandNoEmptyCards.size(); i++) {
//					player.getHand().set(indexOf(cardHand), playerHandNoEmptyCards.get(i));
//
//				}
//				break;
//			}
//		}
		
		
//		
//		// Shuffle the cards of the players hand.
//		Collections.shuffle(player.getHand());
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
