package model.cards;

import model.tile.Robot;

public class RotateRight extends Card {
	public RotateRight(int points) {
		super("RotateRight",points);
	}
	
	
	
	
	String cardmessage = "Rotated Right";
	
	@Override
	public void setAction(Robot robot) {
		switch(robot.getOrientation()) {
		
		case "N":
			robot.setOrientation("E");
			break;
		
		case "W":
			robot.setOrientation("N");
			break;
			
		case "S":
			robot.setOrientation("W");
			break;
			
		case "E":
			robot.setOrientation("S");
			break;
			
		default:
			System.out.println("~ Don't know robot now orientation ~");
		}   //robot.(method for orientation)
		//setdirection ako je rotate
	}
}
