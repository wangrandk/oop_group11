package model.tile;

import model.main.Player;
import utilities.Position;

public abstract class Tile {
	
	private Position position;
	private boolean hasRobotAndAnotherTile;
	
	public Tile() {};
	
	public Tile(Position position) {
		this.position = position;
	}
	

	public void doAction(Robot robot, Player player) {
	}


	public boolean isHasRobotAndAnotherTile() {
		return this.hasRobotAndAnotherTile;
	}

	public void setHasRobotAndAnotherTile(boolean hasRobotAndAnotherTile) {
		this.hasRobotAndAnotherTile = hasRobotAndAnotherTile;
	}

	public void setPosition(int x, int y) {
		this.position = new Position(x, y);
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}


	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

}
