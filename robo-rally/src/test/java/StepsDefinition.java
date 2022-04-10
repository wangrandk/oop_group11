import cucumbertest.Robot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	Robot robot = new Robot(0,0);
    //scenario move
	@Given("your robot life is not {int}")
	public void your_robot_life_is_not(Integer int1) {
	    
	    boolean notEqual = !(robot.getLife() == (int1));
	    System.out.println( notEqual ); //true
	}
	
	@Given("IsYourTurn status is true")
	public void is_your_turn_status_is_true() {
	    robot.setTurnStatus(true);
	}
	
	@Given("position x is {int} y is {int}")
	public void position_x_is_y_is1(Integer int1, Integer int2) {
	   robot.setPosition(int1, int2);
	}

	
	@When("orientation is West")
	public void orientation_is_west() {
		 robot.setOrientation("W");
	}
	
	@Then("position x is {int}  y is {int}")
	public void position_x_is_y_is(Integer int1, Integer int2) {
	    robot.setPosition(int1, int2);
	}
	
	@When("orientation is East")
	public void orientation_is_east() {
		robot.setOrientation("E");
	}
	
	@When("orientation is South")
	public void orientation_is_south() {
		robot.setOrientation("S");
	}

	//scenario rorate

	@When("orientation is North")
	public void orientation_is_north() {
		robot.setOrientation("N");
	}


}
