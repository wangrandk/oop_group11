package model.main;
 
import java.util.ArrayList;

import model.card.*;
import model.tile.Robot;
import model.tile.Tile;
import utilities.GameSettings;
import utilities.Position;
import utilities.GameSettings.PlayerStatus;
import utilities.IllegalActionException;

/*
 * Player mimics the status of what a real-world player would have
*/
//
public class Player {
	private boolean isReady = false;
	private boolean isCardsChangeable;
	private boolean isYourTurn = false;
	Player player;

	private int life = 3;
	
	private GameSettings.PlayerStatus playerStatus = GameSettings.PlayerStatus.ALIVE;	
	
	private final int playerID;
	private static int countPlayerId = 1;
	private Robot robot;
	boolean handFull;
	private int handSize = 5;
 
	
	 
	private ArrayList<Card> subdeck = new ArrayList<Card>(); //  Each round
	private ArrayList<Card> hand = new ArrayList<Card>(); // Each turn
	public static ArrayList<Player> players = new ArrayList<Player>(); // Each turn
	
	private boolean subdeckFull = true;

	
	public Player(){
		this.playerID = countPlayerId;
		countPlayerId++;
		this.setHand(generateEmptyHand());
		players.add(this);
	} 
	
	public ArrayList<Card> generateEmptyHand(){
		ArrayList<Card> emptyHand = new ArrayList<Card>();
		for (int i = 0; i < handSize; i++) {            	
        	emptyHand.add(new EmptyCard(0));
        }
		return emptyHand;	
	}
	public ArrayList<Card> generateEmptySubDeck(){
		ArrayList<Card> emptySubDeck = new ArrayList<Card>();
		for (int i = 0; i < 9; i++) {            	
			emptySubDeck.add(new EmptyCard(0));
        }
		return emptySubDeck;	
	}
	
	
    /**
     * Decreases life by one.
     * Tests if the player will die after loosing the life.
     */
    public void looseLife() {
        this.life --;
        if (this.life <= 0) {
        	setPlayerStatus(GameSettings.PlayerStatus.DEAD);
            System.out.println(this.robot.getName() + " is now Kaput and lost");
        }
    }
    
    public int getLife() {
		return this.life;
	}
    
    // Increase the player's life by one, with below than 3.
    public void increaseLife() {
    	if (this.getLife() < 3 ) {
    		this.life++;
		}
    }


	public void setLife(int life) {
		this.life = life;
	}

    
	/*
	 * Player Card Handling. 
	*/
	public void checkFullHand() {
		for (Card card : this.getHand()) {
			if (card instanceof EmptyCard) {
				this.handFull = false;
				this.subdeckFull = false;
				break;
			}
			else {
				this.handFull = true;
			}
		}
	
	}
	public void checkFullSubdeck() {
		for (Card card : this.getSubdeck()) {
			if (card instanceof EmptyCard) {
				this.subdeckFull = false;
				break;
			}
			else {
				this.subdeckFull = true;
				this.handFull = false;
			}
		}
	
	}
    
    //Restrict that no more than 5 cards can be in your hand
    public void fiveToHand(Card card) throws IllegalActionException {   
    	this.checkFullHand();
    	if (card instanceof EmptyCard) {
    		// do nothing
    	}
    	else {
    		if (this.handFull == false) {
    			    			
    			// Loop through the hand to add the the in order
    			for (Card handCard : this.hand) {
    				// When it encounter an EmptyCard, add the card from the subdeck in that position
    				if (handCard instanceof EmptyCard) {
    					// Replaces (removes) the card from the subdeck, and add an empty card
    					this.subdeck.set(this.subdeck.indexOf(card), new EmptyCard(0));
    					
    					//Replaces the card from the subdeck, in the specific.
    					this.hand.set(this.hand.indexOf(handCard), card);
    					    					
    					break;
    				}
    			}
    			
    			
    			
//    			Card removedHand;
//    			int removedCardSubdeck = this.subdeck.indexOf(card);
//    			removedHand = this.getHand().get(0);
//    			
//    			this.subdeck.remove(card);
//    			this.subdeck.add(removedCardSubdeck,removedHand);
//    			
//    			this.hand.remove(removedHand);
//    			this.hand.add(card);
    		}
    		
    	}
	
	}
    
 // Put back the card from HAND to SUBDECK
 	public void replayCard(Card card) {
 	
 		this.checkFullSubdeck();
 		
 		if (card instanceof EmptyCard) {
 			// don't transfer the card from the subdeck to the Hand
 		}
 		else {
 			if (this.isSubdeckFull() == false) { // if the subDeck is not full
    			for (Card subDeckCard : this.subdeck) {
    				// When it encounter an EmptyCard, add the card from the subdeck in that position
    				if (subDeckCard instanceof EmptyCard) {
    					// Replaces (removes) the card from the hand, and add an empty card
    					this.hand.set(this.hand.indexOf(card), new EmptyCard(0));
    					
    					//Replaces the card from the subdeck, in the specific.
    					for (Card subdeckCard : this.getSubdeck()) {
    						if (subdeckCard instanceof EmptyCard) {
    	    					this.subdeck.set(this.getSubdeck().indexOf(subdeckCard),card);
    	    					break;

    						}
    					}
    					break;
    				}
    			}
 				
 				
// 				int removedCardHand; // index from the removed card from the hand
// 				Card removedSubdeck;
// 				removedCardHand = this.hand.indexOf(card);
// 				removedSubdeck = this.getSubdeck().get(0);
// 				
// 				this.hand.remove(card);
// 				this.hand.add(removedCardHand,new EmptyCard(0));
// 				
// 				this.subdeck.remove(removedSubdeck);
// 				this.subdeck.add(card);
 			}
 			 
 		}
 	
 		
 		//add to a subdeck
 	}
    
    
    
    
    public boolean isHandFull() {
		return this.handFull;
	}
    
    
    // Counts the number of empty cards in a player's hand.
	public int getHandNumNonEmptyCards() {
		int nonEmptyCards = 0;
		
		for (Card card : this.hand) {
			if(card instanceof EmptyCard) {
				
			}
			else {
				nonEmptyCards ++;
			}
			
		}
		
		return nonEmptyCards;
	}
	
	public int getSubDeckNumNonEmptyCards() {
		int nonEmptyCards = 0;
		
		for (Card card : this.subdeck) {
			if(card instanceof EmptyCard) {
			}
			else {
				nonEmptyCards ++;
			}
			
		}
		
		return nonEmptyCards;
	}
	
	
	
    
	public Robot getRobot() {
		return this.robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public boolean canPlay() {
		if(this.getPlayerStatus() == GameSettings.PlayerStatus.ALIVE) {
			return true;
		}
		return false;
	}
    
    public GameSettings.PlayerStatus getPlayerStatus() {
		return this.playerStatus;
	}

	public void setPlayerStatus(GameSettings.PlayerStatus playerStatus) {
    	this.playerStatus = playerStatus;
    }
    
    public boolean isYourTurn() {
		return isYourTurn;
	}

	public void setYourTurn(boolean isYourTurn) {
		this.isYourTurn = isYourTurn;
	}

	public ArrayList<Card> getSubdeck() {
		return this.subdeck;
	}

	public void setSubdeck(ArrayList<Card> subdeck) {
		this.subdeck = subdeck;
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public void doObstacleAction(String obstacleAction) {
		switch(obstacleAction) {
		
		case "Pit":
			this.player.looseLife();
		}
		
	}

	public boolean isSubdeckFull() {
		return this.subdeckFull;
	}

	public int getPlayerID() {
		return this.playerID;
	}

	public void set(Card card, EmptyCard emptyCard) {
		card = emptyCard;
		
	}

	public boolean isReady() {
		return this.isReady;
	}

	public void setReady(boolean isReady) {
		this.checkFullHand();
		if (this.isHandFull()) {
			this.isCardsChangeable = false;
			
			this.isReady = isReady;
		}
		
	}

    public static boolean isAllPlayersReady() {
    	int countNumReadyPlayers = 0;
    	for (Player player : Player.players) {
    		if (player.isReady) {
    			countNumReadyPlayers++;
    		}
    		
    	}
    	if (countNumReadyPlayers == Player.players.size()) {
    		return true;
    	}return false;
    }

	public boolean isCardsChangeable() {
		return this.isCardsChangeable;
	}

	public void setCardsChangeable(boolean isCardsChangeable) {
		this.isCardsChangeable = isCardsChangeable;
	}
}
