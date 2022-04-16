package cucumbertest;

import cucumbertest.Robot;
import decks.Deck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import model.board.Board;
import subcards.Card;
import subcards.MoveOne;
import subcards.MoveThree;
import subcards.MoveTwo;
import subcards.RotateLeft;
import subcards.RotateRight;
import subcards.UTurn;
import io.cucumber.java.en.Then;



public class AndroStepsDefinition {
	Deck deck = new Deck();
	Robot robot = new Robot(0,0);
	Board board = new Board();
	Card card;
	
	@Given("card with {string}")
	public void card_with(String string) {
		// instantiate card object based on card string
		if(string.equals("Move1")) {
	    	card = new MoveOne(500);
	    } else if(string.equals("Move2")) {
	    	card = new MoveTwo(500);
	    } else if(string.equals("Move3")) {
	    	card = new MoveThree(500);
	    } else if(string.equals("RotateLeft")) {
	    	card = new RotateLeft(500);
	    } else if(string.equals("RotateRight")) {
	    	card = new RotateRight(500);
	    } else if(string.equals("UTurn")) {
	    	card = new UTurn(500);
	    }
	    //System.out.print(card.equals(null));
		// set next step for robot using given card
		card.setAction(robot);   
	    
	}
	
	@When("move {int} step forward")
	public void move_step_forward(Integer int1) {
		// robot.UpdatePosition();
	}
	
	@Then("round is Done")
	public void round_is_done() {
	    robot.setTurnStatus(false);
	}

	

	/*@Then("my turn is <False>")
	public void my_turn_is_false() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
}