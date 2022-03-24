import cucumbertest.Position;
import cucumbertest.Robot;

public class StepsDefinition {
	Robot robot = new Robot();
    //scenario move
	@Given("your robot life is not {int}")
	public void your_robot_life_is_not(Integer int1) {
	    
	    boolean notEqual = !robot.getLife().equals(int1);
	    System.out.println( notEqual ); //true
	}
	@Given("IsYourTurn status is true")
	public void is_your_turn_status_is_true() {
	    robot.setTurnStatus(true);
	}
	
	@Given("position x is {int} y is {int}")
	public void position_x_is_y_is(Integer int1, Integer int2) {
	   robot.setPosition(int1, int2);
	}

	@When("move  to a new position")
	public boolean move_to_a_new_position(Position newPosition) {
			if(robot.isLifeNull() == false && robot.isYourTurn == true && robot.isValidPosition(newPosition)== true) {
				return true;
			}
			return false;			
	}
	
	@When("orientation is West")
	public void orientation_is_west() {
		 robot.setOrientation() =="W"
	}
	@Then("position x is {int}  y is {int}")
	public void position_x_is_y_is(Integer int1, Integer int2) {
	    robot.setPosition(int1, int2);
	}
	@When("orientation is East")
	public void orientation_is_east() {
		robot.getOrientation() =="E"
	}
	@When("orientation is South")
	public void orientation_is_south() {
		robot.getOrientation() =="S"
	}

	//scenario rorate

	@Given("IsYourTurn status is true")
	public void is_your_turn_status_is_true() {
		 robot.getTurnStatus();
	}
	@When("orientation is North")
	public void orientation_is_north() {
	    
	}
	@When("rotate to the left")
	public void rotate_to_the_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("orientation is West")
	public void orientation_is_west() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("rotate to the right")
	public void rotate_to_the_right() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("orientation is East")
	public void orientation_is_east() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("orientation is West")
	public void orientation_is_west() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("orientation is South")
	public void orientation_is_south() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("orientation is North")
	public void orientation_is_north() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("orientation is South")
	public void orientation_is_south() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("orientation is East")
	public void orientation_is_east() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
