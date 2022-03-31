package cucumbertest;

import static org.junit.Assert.assertEquals;

import decks.Deck;
import decks.SubDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import subcards.Card;

public class StepsDefinitionCard {
	
	Deck deck = new Deck();
	SubDeck subdeck = new SubDeck();
	int deckSize;
	int subdeckSize;
	int handSize;
	Robot robot= new Robot(0, 0);
	
	@Given("a full subdeck")
	public void a_full_subdeck() {
	    deck.nineTosubdeck();
	    subdeckSize = SubDeck.subdeck.size();  //control if 5 cards is removed
	}

	@When("hand of cards is selected from a subdeck")
	public void hand_of_cards_is_selected_from_a_subdeck() {
	    for (int i=0; i<5; i++) {
	    	Card card = SubDeck.subdeck.get(0);
	    	robot.giveCard(card);
	    }
	}

	@Then("hand is full")
	public void hand_is_full() {
	    assertEquals(robot.hand.size(),5);
	}

	@Then("subdeck is reduced")
	public void subdeck_is_reduced() {
	    assertEquals(SubDeck.subdeck.size(),subdeckSize-5);
	}
	
	@Given("a subdeck")
	public void a_subdeck() {
		deck.nineTosubdeck();
	    subdeckSize = SubDeck.subdeck.size(); 
	}

	@Given("a hand of cards")
	public void a_hand_of_cards() {
		for (int i=0; i<5; i++) {
	    	Card card = SubDeck.subdeck.get(0);
	    	robot.giveCard(card);
	    }
		handSize=robot.hand.size();
		subdeckSize=SubDeck.subdeck.size();
	}

	@When("card is deselected")
	public void card_is_deselected() {
	    Card card = robot.hand.get(0);  //returns card from hand to subdeck
	    robot.replayCard(card);
	}

	@Then("hand of cards is decreased")
	public void hand_of_cards_is_decreased() {
	    assertEquals(robot.hand.size(),handSize-1);
	}

	@Then("subdeck is increased")
	public void subdeck_is_increased() {
		assertEquals(SubDeck.subdeck.size(),subdeckSize+1);
	}
	
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
