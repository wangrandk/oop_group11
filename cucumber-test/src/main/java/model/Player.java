package model;

import java.util.ArrayList;

import model.board.Board;
import model.tile.Robot;
import subcards.*;
	
public class Player {
	
	private boolean turnStatus = false;
	private int playerID;
	
	private Robot robot;
	private Board board;
	
	private ArrayList<Card> roundCards = new ArrayList<Card>(9);
	public ArrayList<Card> getRoundCards() {
		return roundCards;
	}

	public void setRoundCards(ArrayList<Card> roundCards) {
		this.roundCards = roundCards;
	}

	private ArrayList<Card> programmedCards = new ArrayList<Card>(5);
	
	
	
	public ArrayList<Card> getProgrammedCards() {
		return programmedCards;
	}

	public void setProgrammedCards(ArrayList<Card> programmedCards) {
		this.programmedCards = programmedCards;
	}

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
