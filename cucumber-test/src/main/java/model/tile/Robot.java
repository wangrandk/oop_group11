package model.tile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import decks.Deck;
import decks.SubDeck;
import model.card.*;
import utilities.GameSettings;
import utilities.Position;


//when round is over, call 1 by 1 card to execute, and remove from a robot hand *future
public class Robot extends Tile {
	
	String name;
	Robot robot;
	Position position;
	GameSettings.Orientation orientation = GameSettings.Orientation.EAST;
	
	private int movAmount;    // new variable
	
	
	public Robot(int x, int y) {
	    this.position = new Position(x, y);
	}
	

	public int getmovAmount() {   // read from a card how many steps 
		return this.movAmount;
	}
	
	public void setmovAmount(int movAmount) {    // move 1,2, or 3
		this.movAmount = movAmount;
	}
	
	
	
	
	
	public GameSettings.Orientation getOrientation() {   // get orientation from a card (or initial one(east))
		return this.orientation;
	}
	
	public void setOrientation(String string) {  // rotate robot to wanted orientation
		this.orientation = string;
	}
	
	public void setPosition(Position position) {
		this.position = position;   
	}
	
	public Position getPosition() {
		return this.position;
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
	
	public void UpdatePosition() {    
		if( getOrientation() == GameSettings.Orientation.NORTH) {
	    	Robot.x = Robot.y  + this.movAmount;
	    }
	    if(getOrientation() == GameSettings.Orientation.WEST) {
	    	Robot.x = Robot.x - this.movAmount;   //+-1 replaced with movAmount (so that it can be 1,2,3)
	    }
	    if( getOrientation() ==GameSettings.Orientation.SOUTH) {
	    	Robot.y = Robot.y - this.movAmount;
	    }
	    if( getOrientation() == GameSettings.Orientation.EAST) {
	    	Robot.x = Robot.x + this.movAmount;
	    }
	} 								//FIX! Create new method for orientation
		
	public void UpdateOrientation(Card card) {
		if( card.getCard().equals("RotateLeft")) {
			card.setAction(this);
		}
		
	    if( card.getCard().equals("RotateRight")) {
	    	card.setAction(this);
	    }
	    
	    if( card.getCard().equals("UTurn")) {   //== changed to .equals
	    	card.setAction(this);
	    }

	}
	
	
	public static void main(String[] args) {
		Robot r = new Robot(3,1);
		System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
		r.UpdatePosition();
		System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
	}
}
