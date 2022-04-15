package model;

import java.util.ArrayList;

import model.card.Card;
import model.tile.Robot;
	
public class Player {
	
	private boolean turnStatus = false;
	private int playerID;
	
	private Robot robot;
	private Board board;
	
	private ConsoleMessage response = new ConsoleMessage();
	private ArrayList<Card> roundHand = new ArrayList<Card>(9);
	private ArrayList<Card> turnHand;

	
	public void setID(Integer playerID) {
		
		this.playerID = playerID;
	}

	public void setTurnStatus(boolean turnStatus) {
		this.turnStatus = turnStatus;
		
	}
	
	public boolean getTurnStatus() {
		return this.turnStatus;
		
	}



}
