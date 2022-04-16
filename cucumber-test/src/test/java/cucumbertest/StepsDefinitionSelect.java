package cucumbertest;
import static org.junit.Assert.assertEquals;

import decks.Deck;
import decks.SubDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tile.Robot;
import subcards.Card;

public class StepsDefinitionSelect {

	Deck deck = new Deck();
	SubDeck subdeck = new SubDeck();
	int deckSize;
	int subdeckSize;
	int handSize;
	Robot robot= new Robot(0, 0);
	
	@Given("a full subdeck")
	public void a_full_subdeck() {
	    subdeckSize = robot.subdeck.size();  //control if 5 cards is removed
	}

	@When("hand of cards is selected from a subdeck")
	public void hand_of_cards_is_selected_from_a_subdeck() {
	    for (int i=0; i<5; i++) {
	    	Card card = robot.subdeck.get(0);
	    	robot.giveCard(card);
	    }
	}

	@Then("hand is full")
	public void hand_is_full() {
	    assertEquals(robot.hand.size(),5);
	}

	@Then("subdeck is reduced")
	public void subdeck_is_reduced() {
	    assertEquals(robot.subdeck.size(),subdeckSize-5);
	}
}
