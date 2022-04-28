package stepsDefinition.boardSteps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.board.Board;
import model.board.EasyBoard;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.main.Player;

public class creationBoardSteps {
	
	Player player;
	Board board;
	
	@Given("A player")
	public void a_player() {
	    player = new Player();
	}

	@When("generate an Easy Board")
	public void generate_an_easy_board() {
	   board = new EasyBoard();
	}

	@Then("a easy board should be created")
	public void a_easy_board_should_be_created() {
	    assertEquals(true, board instanceof EasyBoard);
	    
	}
	
	@When("generate an Medium")
	public void generate_an_medium() {
	    board = new MediumBoard();
	}

	@Then("a medium board should be created")
	public void a_medium_board_should_be_created() {
	    assertEquals(true, board instanceof MediumBoard);

	}

	@When("generate an Hard Board")
	public void generate_an_hard_board() {
	    board = new FinalBoard();

	}

	@Then("a Hard Board should be created")
	public void a_hard_board_should_be_created() {
	    assertEquals(true, board instanceof FinalBoard);
	}

}
