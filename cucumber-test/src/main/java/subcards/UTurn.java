package subcards;

import cucumbertest.Robot;

public class UTurn extends Card {
	public UTurn(int points) {
		super("UTurn",points);
	}
	
	
	
	
	String cardmessage = "U Turned";
	
	@Override
	public void setAction(Robot robot) {
		robot.setOrientation("E");
		robot.UpdatePosition();   //robot.(method for orientation)
		//setdirection ako je rotate
	}
}
