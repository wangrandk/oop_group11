package model.tile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.card.*;
import model.main.Player;
import utilities.GameSettings;
import utilities.Position;


//when round is over, call 1 by 1 card to execute, and remove from a robot hand *future
public class Robot extends Tile {
	
	String name;
	Robot robot;
	Position position;
	Position initialPosition;
	Player player;
	GameSettings.Orientation orientation = GameSettings.Orientation.EAST;
	private ArrayList<Position> checkPoints = new ArrayList<Position>();

	
	// movAmount changes according to the card.
	private int movAmount = 0;

	private String obstacleAction;
	
	private String cardRotation = null;  
	
	
	
	
	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}

	public ArrayList<Position> getCheckPoints() {
		return checkPoints;
	}

	public void setCheckPoints(ArrayList<Position> checkPoints) {
		this.checkPoints = checkPoints;
	}
	
	public void addCheckPoint(Position position) {
		this.checkPoints.add(position);
	}

	public String getObstacleAction() {
		return obstacleAction;
	}

	public void setObstacleAction(String obstacleAction) {
		this.obstacleAction = obstacleAction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void setCardRotation(String cardRotation) {
		this.cardRotation  = cardRotation;
	}
	
	public String getCardRotation() {
		return this.cardRotation;
	}



}
	
