package model;

import model.main.Player;
import model.tile.Robot;

public class Game {

	public static void main(String[] args) {
		
		Player player = new Player();
		
		Robot robot =  new Robot();
		
		player.setRobot(robot);

		player.setLife(2);
		
		System.out.println(robot.getPlayer().getLife());
		

	}

}
