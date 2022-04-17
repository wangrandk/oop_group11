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
	
	// movAmount changes according to the card.
	private int movAmount = 0;  
	
	
	public Robot(int x, int y) {
	    this.position = new Position(x, y);
	}
	
	// Get X from the robot's position
	public int getX() {
		return this.getPosition().getX();
	}
	
	// Get X from the robot's position
	public int getY() {
		return this.getPosition().getY();
	}
	
	
	

	public int getmovAmount() {   // read from a card how many steps 
		return this.movAmount;
	}
	
	public void setmovAmount(int movAmount) {    // move 1,2, or 3
		this.movAmount = movAmount;
	}
	
	
	public GameSettings.Orientation getOrientation() { 
		return this.orientation;
	}
	
	public void setOrientation(GameSettings.Orientation orientation) {
		this.orientation = orientation;
	}
	
	
	public void setPosition(Position position) {
		this.position = position;   
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	/*
	 * movAmount will be determined by the card
	*/
	public void UpdatePosition() {    
		if( getOrientation() == GameSettings.Orientation.NORTH) {
	    	Robot.y = Robot.y  + this.movAmount;
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
