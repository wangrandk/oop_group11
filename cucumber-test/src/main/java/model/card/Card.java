package model.card;

import java.net.URL;

import model.tile.Robot;

//main card class, which will be extended by card types(MoveOne,RotateLeft,...)

public abstract class Card {
	private String card;
	private final int points;
	String cardmessage;
	private URL cardImage;
	
	public String getCard() {
		return this.card;
	}
	
	public void setCard(String c) {
		this.card = c;
	}
	
	public abstract void setAction(Robot r);
	
	public int getpoints() {
		return points;
	}
	
	//assign a name to a card(mov1, move2,...)
	//assign points to a card
	public Card(String name, int points) {
		this.card= name;   
		this.points=points;  
	}
	
	//returns card message, and tells console what to print
	public String getMessage() {     
		return cardmessage;
	}
	
	public String getCardImage() {
		return null;
	}

	public String getCardImagePick() {
		return null;
	}
	
	public String getCardImagePickRollover() {
		return null;
	}
	
}
