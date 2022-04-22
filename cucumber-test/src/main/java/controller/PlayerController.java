package controller;


import model.Game;
import model.main.Player;
import model.tile.Robot;

public class PlayerController {
	
	Player player;
	Robot robot;
	Game game;
	
	public PlayerController(Game game) {
		//this.game=game
		//this.view=view
		
	}
	
	public void playerLosesLife(Player player) {
		player.looseLife();
		//update view: (ex. change from 3->2)
		
	}
	
	
}
