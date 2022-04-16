package subcards;

import model.tile.Robot;

public class RotateLeft extends Card {
	public RotateLeft(int points) {
		super("RotateLeft",points);
	}
	
	
	
	
	String cardmessage = "Rotated Left";
	
	@Override
	public void setAction(Robot robot) {
		
		switch(robot.getOrientation()) {
		
		case "N":
			robot.setOrientation("W");
			break;
		
		case "W":
			robot.setOrientation("S");
			break;
			
		case "S":
			robot.setOrientation("E");
			break;
			
		case "E":
			robot.setOrientation("N");
			break;
			
		default:
			System.out.println("~ Don't know robot now orientation ~");
		}	
	}
}

