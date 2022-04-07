package subcards;

import cucumbertest.Robot;

public class RotateLeft extends Card {
	public RotateLeft(int points) {
		super("RotateLeft",points);
	}
	
	
	
	
	String cardmessage = "Rotated Left";
	
	@Override
	public void setAction(Robot robot) {
		robot.setOrientation("E");
		robot.UpdatePosition();   //robot.(method for orientation)
		//setdirection ako je rotate
	}
}

