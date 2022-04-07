package subcards;

import cucumbertest.Robot;

public class RotateRight extends Card {
	public RotateRight(int points) {
		super("RotateRight",points);
	}
	
	
	
	
	String cardmessage = "Rotated Right";
	
	@Override
	public void setAction(Robot robot) {
		robot.setOrientation("E");
		robot.UpdatePosition();   //robot.(method for orientation)
		//setdirection ako je rotate
	}
}
