package cucumbertest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cucumbertest.Board;
import decks.SubDeck;
import subcards.Card;

class Position {
	protected static int x;
	protected static int y;
	//protected static boolean isEmpty = true;

    public Position(int x, int y) {
        Position.x = x;
        Position.y = y;
    }
 
    public static int getX() {
        return Position.x;
    }

    public static int getY() {
        return Position.y;
    }
    //need to define what is empty
    public static boolean isEmpty(int x,int y) {
    	return true;
    }
}


//when round is over, call 1 by 1 card to execute, and remove from a robot hand *future
public class Robot  extends Position {

	private  int nx; 
	private  int ny;
	List<String> orientations = Arrays.asList("N","W","S","E");
	public ArrayList<Card> hand = new ArrayList<Card>();   
	
	private String orientation;
	public Position p;
	public Robot(int x, int y) {
	    super(x,y);
	    this.orientation = "E";  //automatically assigned to east
	}
	
	private int life = 3;
	public boolean isYourTurn;
	
	private int movAmount;    // new variable
	
	public int getmovAmount() {   // read from a card how many steps 
		return this.movAmount;
	}
	
	public void setmovAmount(int movAmount) {    // move 1,2, or 3
		this.movAmount = movAmount;
	}
	
	public void setBehaviour(Card card) {
		switch(card.getCard()) {
			case "Move1":
				this.movAmount = 1;
				return;
			case "Move2":
				this.movAmount = 2;
				return;
			case "Move3":
				this.movAmount = 3;
				return;
			case "RotateLeft":
				return;
				// TODO update orientation
			case "RotateRight":
				return;
				// TODO update orientation
			case "UTurn":
				return;
				// TODO update orientation
		}
	}
	
	public boolean isLifeNull() {
		if(this.getLife() != 0) {
			return false;
		}
		return true;
	}
	
	public void setTurnStatus(boolean isYourTurn) {
		this.isYourTurn = isYourTurn;
	}
	
	public boolean getTurnStatus() {
		return this.isYourTurn;
	}
	
	public void giveCard(Card card) {    //restrict that no more than 5 cards can be in you hand
		if (this.hand.size() < 5) {
			this.hand.add(card);
			SubDeck.subdeck.remove(card);
			//remove card from a subdeck 
		}
		else {System.out.println("You've already played all your cards!");}
	}
	
	public void replayCard(Card card) {
		this.hand.remove(card);   //moves selected card back to a subdeck
		SubDeck.subdeck.add(card);
		//add to a subdeck
		
	}
	
	
	
	public int getLife() {
		return this.life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	
	public String getOrientation() {   // get orientation from a card (or initial one(east))
		return this.orientation;
	}
	
	public void setOrientation(String string) {  // rotate robot to wanted orientation
		this.orientation = string;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
	    this.y = y;	   
	}
	
	public void getPosition() {
		this.x = Position.getX();
		this.y = Position.getY();
		
		//return this.x + this.y; 
		System.out.println("  X is: "  + this.x + " Y is: " + this.y);
	}
	public boolean isValidPosition(Position newPosition) {
	    this.nx = newPosition.x; 
	    this.ny = newPosition.y; 
		if(Position.isEmpty(this.nx, this.ny) == true ) {
			return true;
		}
		return false;
	}

	public  boolean move(Position newPosition) {
		if(isLifeNull() == false && isYourTurn == true && isValidPosition(newPosition)== true) {
			return true;
		}
		return false;
		
	}
	public void UpdatePosition(Position position) {    
	   /* if(move(position) == true && getOrientation() =="N") {
	    	Robot.x = position.getX();
	    	Robot.y = position.getY() + 1;
	    }
	    if(move(position) == true && getOrientation() =="W") {
	    	Robot.x = position.getX() - 1;
	    	Robot.y = position.getY();
	    }
	    if(move(position) == true && getOrientation() =="S") {
	    	Robot.x = position.getX();
	    	Robot.y = position.getY() - 1;
	    }
	    if(move(position) == true && getOrientation() =="E") {
	    	Robot.x = position.getX() + 1;
	    	Robot.y = position.getY();
	    }*/
	}
	public void UpdatePosition() {    
		if( getOrientation() =="N") {
	    	Robot.y = Robot.y  + this.movAmount;
	    }
	    if(getOrientation() =="W") {
	    	Robot.x = Robot.x - this.movAmount;   //+-1 replaced with movAmount (so that it can be 1,2,3)
	    }
	    if( getOrientation() =="S") {
	    	Robot.y = Robot.y - this.movAmount;
	    }
	    if( getOrientation() =="E") {
	    	Robot.x = Robot.x + this.movAmount;
	    }
	}
		
	
		public static void main(String[] args) {
			Robot r = new Robot(3,1);
			System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
			r.UpdatePosition();
			System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
		}
}
