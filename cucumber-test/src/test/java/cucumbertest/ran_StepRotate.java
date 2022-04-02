package cucumbertest;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import roborally.ResponseMessage;
import roborally.Robot;
import io.cucumber.java.en.Then;




public class ran_StepRotate {
	Robot robot = new Robot(3,2);
	ResponseMessage response;
	
	@When("start orientation is N")
	public void start_orientation_is_n() {
		response =robot.setOrientation("N"); 
		assertEquals(response.GetMessage(), "Orientation is: N");	
	}
	@When("rotate to the left from N")
	public void rotate_to_the_left_from_n() {
		 response = robot.RotateLeft();
	}
	
	@Then("end orientation is west from N")
	public void end_orientation_is_west_from_n() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: W");
	}
	
	@When("rotate to the right from N")
	public void rotate_to_the_right_from_n() {
		response = robot.RotateRight();
	}

	@Then("end orientation is east from N")
	public void end_orientation_is_east_from_n() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: E");
	}


	@When("start orientation is W")
	public void start_orientation_is_w() {
		response =robot.setOrientation("W"); 
		assertEquals(response.GetMessage(), "Orientation is: W");	
		assertEquals(response.GetMessage(), "Orientation is: " + robot.getOrientation());	
	}
	@When("rotate to the left from W")
	public void rotate_to_the_left_from_w() {
		response = robot.RotateLeft();
	}
	@Then("end orientation is south from W")
	public void end_orientation_is_south_from_w() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: S");
	}

	@When("rotate to the right from W")
	public void rotate_to_the_right_from_w() {
		response = robot.RotateRight();
	}
	@Then("end orientation is north from W")
	public void end_orientation_is_north_from_w() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: N");
	}


	@When("start orientation is S")
	public void start_orientation_is_s() {
		response =robot.setOrientation("S"); 
		assertEquals(response.GetMessage(), "Orientation is: S");	
		assertEquals(response.GetMessage(), "Orientation is: " + robot.getOrientation());	
	}
	@When("rotate to the left from S")
	public void rotate_to_the_left_from_s() {
		response = robot.RotateLeft();
	}
	@Then("end orientation is east from S")
	public void end_orientation_is_east_from_s() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: E");
	}

	@When("rotate to the right from S")
	public void rotate_to_the_right_from_s() {
		response = robot.RotateRight();
	}
	@Then("end orientation is west from S")
	public void end_orientation_is_west_from_s() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: W");
	}
	
		

	@When("start orientation is E")
	public void start_orientation_is_e() {
		response =robot.setOrientation("E"); 
		assertEquals(response.GetMessage(), "Orientation is: E");	
		assertEquals(response.GetMessage(), "Orientation is: " + robot.getOrientation());	
	}
	@When("rotate to the left from E")
	public void rotate_to_the_left_from_e() {
		response = robot.RotateLeft();
	}
	@Then("end orientation is north from E")
	public void end_orientation_is_north_from_e() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: N");
	}
	

	@When("rotate to the right from E")
	public void rotate_to_the_right_from_e() {
		response = robot.RotateRight();
	}
	@Then("end orientation is south from E")
	public void end_orientation_is_south_from_e() {
		assertEquals(response.GetMessage(),"Orientation is: "+ robot.getOrientation());
		assertEquals(response.GetMessage(),"Orientation is: S");
	}




}
