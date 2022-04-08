import cucumbertest.Board;
import cucumbertest.Robot;
import decks.Deck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import subcards.Card;
import subcards.MoveOne;
import subcards.MoveThree;
import subcards.MoveTwo;
import subcards.RotateLeft;
import subcards.RotateRight;
import subcards.UTurn;

public class StepsDefinitionRotation {
	
	Deck deck = new Deck();
	Robot robot = new Robot(0,0);
	Board board = new Board();
    Card card;
	
	@Given("robot orientation is {string}")
	public void robot_orientation_is(String string) {
		// instantiate card object based on card string
				if(string.equals("RotateLeft")) {
			    	card = new RotateLeft(500);
			    } else if(string.equals("RotateRight")) {
			    	card = new RotateRight(500);
			    } else if(string.equals("UTurn")) {
			    	card = new UTurn(500);
			    }
				
				System.out.println(card == null);
	}

	@When("robot is rotated")
	public void robot_is_rotated() {  //create something like UpdatePositiob(but for rotation in Robot)
	    robot.UpdateOrientation(card);       //call a new created method [James] done~
	}

	//@Then("robot orientation is {string}")
	//public void robot_new_orientation_is(String string) {
	   
	//}
	
	@Then("round is Done")
	public void round_is_done() {
	    robot.setTurnStatus(false);
	}
}
