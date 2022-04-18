package StepsGiovanni;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.GameMaster;

public class GameMasterSteps {
	
	GameMaster gameMaster = new GameMaster();
	@Given("a GameMaster")
	
	public void a_game_master() {
	    //
	}

	@When("GameMaster creates a new player")
	public void game_master_creates_a_new_player() {
		gameMaster.createPlayer();
	}

	@Then("number of players should be bigger than {int}")
	public void number_of_players_should_be_bigger_than(Integer int1) {
		assertTrue(gameMaster.getPlayers().size() > int1);

	}
	
	@When("GameMaster starts the new game")
	public void game_master_starts_the_new_game() {
	    gameMaster.startGame(gameMaster.getPlayers());
	}

	@Then("A new Round is created")
	public void a_new_round_is_created() {
	    assertNotNull(gameMaster.getRound());
	}

	@Then("number of rounds should be increased by {int}")
	public void number_of_rounds_should_be_increased_by(Integer int1) {
	    assertEquals((Integer)gameMaster.getCountRounds(), int1);
	}
	
	@Then("a sub deck is passed for each of the players")
	public void a_sub_deck_is_passed_for_each_of_the_players() {
	    
	}
	
}
