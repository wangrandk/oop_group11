import static org.junit.Assert.assertEquals;

import cucumbertest.Robot;
import decks.Deck;
import decks.SubDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitionSubdeck {

	Deck deck = new Deck();
	SubDeck subdeck = new SubDeck();
	int deckSize;
	int subdeckSize;
	int handSize;
	Robot robot= new Robot(0, 0);
	
	
	@Given("an empty subdeck")
	public void an_empty_subdeck() {
	    assertEquals(SubDeck.subdeck.size(), 0);
	}

	@When("{int} cards are randomly assigned from deck to a subdeck")
	public void cards_are_randomly_assigned_from_deck_to_a_subdeck(Integer int1) {
		deckSize = deck.deck.size();  
	    deck.nineTosubdeck();
	}

	@Then("subdeck receives {int} cards")
	public void subdeck_receives_cards(Integer int1) {
		assertEquals(SubDeck.subdeck.size(), 9);
	}

	@Then("deck is reduced")
	public void deck_is_reduced() {
	    assertEquals(deck.deck.size(),deckSize-9);
	}
}
