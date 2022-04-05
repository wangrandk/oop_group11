package subcards;

import cucumbertest.Robot;

//main card class, which will be extended by other variants(movement, orientation)

public abstract class Card {
	private String card;
	private final int points;
	String cardmessage;
	
	public String getCard() {
		return this.card;
		
	}
	
	public void setCard(String c) {
		this.card = c;
	}
	
	public void setAction(Robot robot) {
		
	}
	
	public int getpoints() {
		return points;
	}
	
	public Card(String name, int points) {
		this.card= name;    //assign a name to a card(mov1, move2,...)
		this.points=points;  //assign points to a card
	}
	
	
	public String getMessage() {     //returns cardmessage, and tells console what to print
		return cardmessage;
	}
	
	
}
