package cucumbertest;
import decks.Deck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.board.Board;
import model.tile.Robot;
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
		robot.setOrientation(string);
	}

	@When("robot is rotated")
	public void robot_is_rotated() {  //create something like UpdatePositiob(but for rotation in Robot)
	    //card.setAction(robot);       //call a new created method [James] done~
	}

	//@Then("robot orientation is {string}")
	//public void robot_new_orientation_is(String string) {
	   
	//}
	
	@Then("round is over")
	public void round_is_over() {
	    robot.setTurnStatus(false);
	}
}
