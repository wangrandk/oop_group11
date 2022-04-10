import static org.junit.Assert.assertEquals;

import cucumbertest.Robot;
import decks.Deck;
import decks.SubDeck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import subcards.Card;

public class StepsDefinitionReplay {
	
	Deck deck = new Deck();
	SubDeck subdeck = new SubDeck();
	int deckSize;
	int subdeckSize;
	int handSize;
	Robot robot= new Robot(0, 0);

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
}
