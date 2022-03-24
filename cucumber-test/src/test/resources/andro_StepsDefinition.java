import io.cucumber.java.en.Given
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;



public class andro_StepsDefinition {
	Robot robot = new Robot(0,0);
	Board board = new Board();
	Card card = new Card();
	
	@Given("card with {string}")
	public void card_with(String string) {
	    card.setCard(string);  //name of a card, depending on a name move xyz
	    if(card.getCard() == "MOVE1") {
	    	robot.setmovAmount(1);
	    }
	    
	    if(card.getCard() == "MOVE2") {
	    	robot.setmovAmount(2);
	    }
	    
	    if(card.getCard() == "MOVE3") {
	    	robot.setmovAmount(3);
	    }
	    
	    
	}

	
	@When("move {int} step forward")
	public void move_step_forward(Integer int1) {
		robot.UpdatePosition();
		
		
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
