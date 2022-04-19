package model;

import model.board.Board;
import model.board.EasyBoard;
import model.card.Deck;
import model.card.MoveOne;
import model.card.RotateLeft;
import model.main.Player;
import model.tile.Robot;
import utilities.Position;

public class Game {

	public static void main(String[] args) {
		
		RotateLeft rotateLeft = new RotateLeft(610);
		MoveOne moveOne = new MoveOne(601);
		Deck deck = Deck.getInstance(); 	// because subdeck in robot constructor cannot be filled without main deck
		Robot robot = new Robot();
		Board board = new EasyBoard();
		Player player1 = new Player();
		Player player2 = new Player();
		
		System.out.println(player1.getRobot());

		player1.setRobot(robot);
		board.setTile(robot, new Position(0,0));
		System.out.println(player1.getRobot());
		
		System.out.println(robot.getPosition().toString());

		moveOne.setAction(robot);
		
		System.out.println(robot.getPosition().toString());

		

	}

}
