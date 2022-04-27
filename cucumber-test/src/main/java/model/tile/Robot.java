package model.tile;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.card.*;
import model.main.Player;
import utilities.GameSettings;
import utilities.Position;


//when round is over, call 1 by 1 card to execute, and remove from a robot hand *future
public class Robot extends Tile {
	
	private String name;
	private Robot robot;
	public static int robotId = 1;
	private Position position;
	private Position initialPosition;
	private Player player;
	private GameSettings.Orientation orientation = GameSettings.Orientation.EAST;
	private Position spawnPosition;
	
	private URL tileImage;
	
	// TODO
	private URL orientationImage;

	
	public Robot() {
		
		if (robotId == 1) {
			this.name = "Hank";
			this.tileImage = this.getClass().getClassLoader().getResource("view/robots/hank.png");
		}
		if (robotId == 2) {
			this.name = "twitch";
			this.tileImage = this.getClass().getClassLoader().getResource("view/robots/twitch.png");
		}
		robotId = robotId + 1;
	}
 
	
	// movAmount changes according to the card.
	private int movAmount = 0;

	
	private String cardRotation = null;  
	
	public URL getImage() {
		return this.tileImage;
	}
	
	
	public Position getSpawnPosition() {
		return this.spawnPosition;
	}

	public void setSpawnPosition(Position spawnPosition) {
		this.spawnPosition = spawnPosition;
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}


	public String getName() {
		return this.name;
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

	@Override
	public void doAction(Robot robot, Player player) {
		// Nothing happens to the Player
		
		// Robot remains on the initial same position
		robot.setPosition(robot.getInitialPosition());
		
		// Nothing Changes on the board
		
		
	}

}
	
