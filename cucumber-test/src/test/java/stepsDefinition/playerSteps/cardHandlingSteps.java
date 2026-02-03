package stepsDefinition.playerSteps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import model.card.Card;
import model.card.Deck;
import model.card.SubDeck;
import model.main.Player;
import utilities.IllegalActionException;

public class cardHandlingSteps {
	
	Player player;
	Deck deck = Deck.getInstance();
	ArrayList<Card> subDeck; 
	
	@Given("A player with a subdeck")
	public void a_player_with_a_subdeck() {
		
		player = new Player();
		
		subDeck = new SubDeck(deck.getDeck()).getSubdeck();
		
		player.setSubdeck(subDeck);
	}

	@When("player chooses {int} cards")
	public void player_chooses_cards(Integer num_cards) throws IllegalActionException {
	    switch(num_cards) {
	    case 2:
	    	player.fiveToHand(player.getSubdeck().getFirst());
	    	player.fiveToHand(player.getSubdeck().get(1));
	    	break;
	    case 3:
	    	player.fiveToHand(player.getSubdeck().getFirst());
	    	player.fiveToHand(player.getSubdeck().get(1));
	    	player.fiveToHand(player.getSubdeck().get(2));
	    	break;
	    case 4:
	    	player.fiveToHand(player.getSubdeck().getFirst());
	    	player.fiveToHand(player.getSubdeck().get(1));
	    	player.fiveToHand(player.getSubdeck().get(2));
	    	player.fiveToHand(player.getSubdeck().get(3));
	    	break;
	    }
	    
	}

	@Then("player hand should have {int} cards")
	public void player_hand_should_have_cards(Integer num_cards) {
		  switch(num_cards) {
		    case 2:
		    	assertEquals(num_cards, (Integer)player.getHandNumNonEmptyCards());
		    	break;
		    case 3:
		    	assertEquals(num_cards, (Integer)player.getHandNumNonEmptyCards());

		    	break;
		    case 4:
		    	assertEquals(num_cards, (Integer)player.getHandNumNonEmptyCards());
		    	break;
		    }
	}

	@Then("player subdeck should have {int} cards")
	public void player_subdeck_should_have_cards(Integer num_cards_subdeck) {
		switch(num_cards_subdeck) {
	    case 7:
	    	assertEquals(num_cards_subdeck, (Integer)player.getSubDeckNumNonEmptyCards());
	    	break;
	    case 6:
	    	assertEquals(num_cards_subdeck, (Integer)player.getSubDeckNumNonEmptyCards());

	    	break;
	    case 5:
	    	assertEquals(num_cards_subdeck, (Integer)player.getSubDeckNumNonEmptyCards());
	    	break;
	    }
	}
	
	@Given("a player with a complete Hand")
	public void a_player_with_a_complete_hand() throws IllegalActionException {
    	player.fiveToHand(player.getSubdeck().getFirst());
    	player.fiveToHand(player.getSubdeck().get(1));
    	player.fiveToHand(player.getSubdeck().get(2));
    	player.fiveToHand(player.getSubdeck().get(3));
    	player.fiveToHand(player.getSubdeck().get(4));

	}

	@When("player selects {int} cards from the hand")
	public void player_selects_cards_from_the_hand(Integer num_cards) throws IllegalActionException {
		  switch(num_cards) {
		    case 1:
		    	player.replayCard(player.getHand().getFirst());
		    	break;
		    case 2:
		    	player.replayCard(player.getHand().getFirst());
		    	player.replayCard(player.getHand().get(1));
		    	break;
		    case 3:
		    	player.replayCard(player.getHand().getFirst());
		    	player.replayCard(player.getHand().get(1));
		    	player.replayCard(player.getHand().get(3));
		    	break;
		    }
	}

	@Then("player should have {int} cards in the hand")
	public void player_should_have_cards_in_the_hand(Integer num_cards_hand) {
		    assertEquals(num_cards_hand, (Integer)player.getHandNumNonEmptyCards());
		   
	}

	@Then("player should have {int} cards in the subdeck")
	public void player_should_have_cards_in_the_subdeck(Integer int1) {
	    assertEquals(int1, (Integer)player.getSubDeckNumNonEmptyCards());

	}
	
}
