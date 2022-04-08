package subcards;

import cucumbertest.Robot;

public class UTurn extends Card {
	public UTurn(int points) {
		super("UTurn",points);
	}
	
	
	
	
	String cardmessage = "U Turned";
	
	@Override
	public void setAction(Robot robot) {
		switch(robot.getOrientation()) {
		
		case "N":
			robot.setOrientation("S");
			break;
		
		case "W":
			robot.setOrientation("E");
			break;
			
		case "S":
			robot.setOrientation("N");
			break;
			
		case "E":
			robot.setOrientation("W");
			break;
			
		default:
			System.out.println("~ Don't know robot now orientation ~");
		}   //robot.(method for orientation)
		//setdirection ako je rotate
	}
}
