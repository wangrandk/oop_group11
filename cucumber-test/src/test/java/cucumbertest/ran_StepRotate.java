package cucumbertest;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import roborally.ResponseMessage;
import roborally.Robot;
import io.cucumber.java.en.Then;


public class ran_StepRotate {
	Robot robot = new Robot(3,2);

	@When("rotate to the left from N")
	public void rotate_to_the_left_from_n() {
		robot.setOrientation("N"); 
		assertEquals(robot.getOrientation(), "N");	
		robot.RotateLeft();
	}
	
	@Then("end orientation is west from N")
	public void end_orientation_is_west_from_n() {
		//assertEquals(robot.getOrientation(),"Orientation is: "+ robot.getOrientation());
		assertEquals(robot.getOrientation(),"W");
	}
	
	@When("rotate to the right from N")
	public void rotate_to_the_right_from_n() {
		robot.setOrientation("N"); 
		assertEquals(robot.getOrientation(), "N");
		robot.RotateRight();
	}

	@Then("end orientation is east from N")
	public void end_orientation_is_east_from_n() {
		assertEquals(robot.getOrientation(),"E");
	}


	@When("rotate to the left from W")
	public void rotate_to_the_left_from_w() {
		robot.setOrientation("W"); 
		assertEquals(robot.getOrientation(), "W");	
		robot.RotateLeft();	
	}

	@Then("end orientation is south from W")
	public void end_orientation_is_south_from_w() {
		assertEquals(robot.getOrientation(),"S");
	}

	@When("rotate to the right from W")
	public void rotate_to_the_right_from_w() {
		robot.setOrientation("W"); 
		assertEquals(robot.getOrientation(), "W");	
		robot.RotateRight();
	}
	@Then("end orientation is north from W")
	public void end_orientation_is_north_from_w() {
		assertEquals(robot.getOrientation(),"N");
	}

	@When("rotate to the left from S")
	public void rotate_to_the_left_from_s() {
		robot.setOrientation("S"); 
		assertEquals(robot.getOrientation(), "S");	
		robot.RotateLeft();
	}
	@Then("end orientation is east from S")
	public void end_orientation_is_east_from_s() {
		assertEquals(robot.getOrientation(),"E");
	}

	@When("rotate to the right from S")
	public void rotate_to_the_right_from_s() {
		robot.setOrientation("S"); 
		assertEquals(robot.getOrientation(), "S");	
		robot.RotateRight();
	}
	@Then("end orientation is west from S")
	public void end_orientation_is_west_from_s() {
		assertEquals(robot.getOrientation(),"W");
	}		

	@When("rotate to the left from E")
	public void rotate_to_the_left_from_e() {
		robot.setOrientation("E"); 
		assertEquals(robot.getOrientation(), "E");	
		robot.RotateLeft();
	}
	@Then("end orientation is north from E")
	public void end_orientation_is_north_from_e() {
		assertEquals(robot.getOrientation(),"N");
	}
	

	@When("rotate to the right from E")
	public void rotate_to_the_right_from_e() {
		robot.setOrientation("E"); 
		assertEquals(robot.getOrientation(), "E");	
		robot.RotateRight();
	}
	@Then("end orientation is south from E")
	public void end_orientation_is_south_from_e() {
		assertEquals(robot.getOrientation(),"S");
	}




}
