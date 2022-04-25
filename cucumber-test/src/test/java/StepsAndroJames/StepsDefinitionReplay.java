package StepsAndroJames;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.card.Card;
import model.card.Deck;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;

public class StepsDefinitionReplay {
	
	ArrayList<Card> deck = Deck.getInstance().getDeck();
	ArrayList<Card> subdeck = new SubDeck(deck).getSubdeck();
	Player player = new Player();
	int deckSize;
	int subdeckSize;
	int handSize;
	
	Robot robot= new Robot();

	@Given("a subdeck")
	public void a_subdeck() {
	    subdeckSize = player.getSubdeck().size(); 
	}

	@Given("a hand of cards")
	public void a_hand_of_cards() {
		for (int i=0; i<5; i++) {
	    	Card card = player.getHand().get(0);
	    	robot.giveCard(card);
	    }
		handSize=robot.hand.size();
		subdeckSize=robot.subdeck.size();
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
		assertEquals(robot.subdeck.size(),subdeckSize+1);
	}
}
