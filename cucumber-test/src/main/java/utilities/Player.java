package utilities;

import java.util.ArrayList;

import edu.chl.roborally.utilities.Constants;
import model.board.Board;
import model.card.*;
import model.tile.Robot;

/*
 * Player mimics the status of what a real-world player would have
*/
public class Player {
	
	private boolean isYourTurn = false;

	private int life = 3;
	private GameSettings.PlayerStatus playerStatus = GameSettings.PlayerStatus.ALIVE;
	
	
	private final int playerID;
	private static int countPlayerId = 1;
	private Robot robot;
	
	
	private ArrayList<Card> subdeck = new ArrayList<Card>(); //  Each round
	private ArrayList<Card> hand = new ArrayList<Card>(); // Each turn

	
	public Player(){
		this.playerID = countPlayerId;
		countPlayerId++;
	}
	
    /**
     * Decreases life by one.
     */
    private void loseLife() {
        this.life = life - 1;
        if (this.life <= 0) {
        	setPlayerStatus(GameSettings.PlayerStatus.DEAD);
            System.out.println(this.robot.getName() + " is now Kaput and lost");
        }
    }
    
	/*
	 * Player Card Handling. 
	*/
    
    //Restrict that no more than 5 cards can be in your hand
    public void fiveToHand(Card card) {    
		if (this.hand.size() != 5) {
			this.hand.add(card);
			this.subdeck.remove(card); //remove card from a subdeck
		}
		else {System.out.println("You've already selected all of your cards!");}
	}
    
    // Put back the card from HAND to SUBDECK
	public void replayCard(Card card) {
		this.hand.remove(card);   //moves selected card back to a subdeck
		this.subdeck.add(card);
		//add to a subdeck
	}
	
    
	public boolean canPlay() {
		if(this.getPlayerStatus() == GameSettings.PlayerStatus.ALIVE) {
			return true;
		}
		return false;
	}
    
    public GameSettings.PlayerStatus getPlayerStatus() {
		return playerStatus;
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
		return subdeck;
	}

	public void setSubdeck(ArrayList<Card> subdeck) {
		this.subdeck = subdeck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
    
}
