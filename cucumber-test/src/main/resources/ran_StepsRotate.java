package cucumbertest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import roborally.Robot;
import roborally.Position;
import static org.junit.Assert.assertEquals;

public class ran_StepsRotate {
		  Robot robot = new Robot(3,1);
	//Successful rotate #1(Movement of a robot)  Time elapsed: 0.006 sec  <<< ERROR!
	//io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
	//You can implement these steps using the snippet(s) below:
		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
			 robot.setTurnStatus(true);
		}
		@When("orientation is N")
		public void orientation_is_n() {
			robot.setOrientation("N"); 
		}
		@When("rotate to the left")
		public void rotate_to_the_left() {
		    robot.RotateLeft();
		}
		@Then("orientation is west")
		public void orientation_is_west() {
			assertEquals("W", robot.getOrientation());
		}

		/*
		Successful rotate #2(Movement of a robot)  Time elapsed: 0.005 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is N")
		public void orientation_is_n() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the right")
		public void rotate_to_the_right() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is east")
		public void orientation_is_east() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}


		Successful rotate #3(Movement of a robot)  Time elapsed: 0.007 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is W")
		public void orientation_is_w() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the left")
		public void rotate_to_the_left() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is south")
		public void orientation_is_south() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}


		Successful rotate #4(Movement of a robot)  Time elapsed: 0.005 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is W")
		public void orientation_is_w() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the right")
		public void rotate_to_the_right() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is north")
		public void orientation_is_north() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}


		Successful rotate #5(Movement of a robot)  Time elapsed: 0.007 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is S")
		public void orientation_is_s() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the left")
		public void rotate_to_the_left() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is east")
		public void orientation_is_east() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}


		Successful rotate #6(Movement of a robot)  Time elapsed: 0.007 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is S")
		public void orientation_is_s() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the right")
		public void rotate_to_the_right() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is west")
		public void orientation_is_west() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}


		Successful rotate #7(Movement of a robot)  Time elapsed: 0.004 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is E")
		public void orientation_is_e() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the left")
		public void rotate_to_the_left() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is north")
		public void orientation_is_north() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}


		Successful rotate #8(Movement of a robot)  Time elapsed: 0.006 sec  <<< ERROR!
		io.cucumber.junit.UndefinedStepException: The step 'IsYourTurn status is true' and 3 other step(s) are undefined.
		You can implement these steps using the snippet(s) below:

		@Given("IsYourTurn status is true")
		public void is_your_turn_status_is_true() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("orientation is E")
		public void orientation_is_e() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("rotate to the right")
		public void rotate_to_the_right() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("orientation is south")
		public void orientation_is_south() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		*/
}
