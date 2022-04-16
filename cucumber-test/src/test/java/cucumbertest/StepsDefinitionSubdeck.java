package cucumbertest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import decks.Deck;
import decks.SubDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tile.Robot;

public class StepsDefinitionSubdeck {

	Deck deck = new Deck();
	SubDeck subdeck = new SubDeck();
	int deckSize;
	int subdeckSize;
	int handSize;
	Robot robot;
	
	
	@Given("an empty subdeck")
	public void an_empty_subdeck() {
	    assertNull(robot);		//robot not yet initialized so robot and subdeck is empty
	}

	@When("{int} cards are randomly assigned from deck to a subdeck")
	public void cards_are_randomly_assigned_from_deck_to_a_subdeck(Integer int1) {
		deckSize = Deck.deck.size();  
	    robot = new Robot(0,0);		//new robot is made and 9 cards are assigned to its subdeck
	}

	@Then("subdeck receives {int} cards")
	public void subdeck_receives_cards(Integer int1) {
		assertEquals(robot.subdeck.size(), 9);
	}

	@Then("deck is reduced")
	public void deck_is_reduced() {
	    assertEquals(Deck.deck.size(),deckSize-9);
	}
}
