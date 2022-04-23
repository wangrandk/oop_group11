package controller;

import model.Game;

public class AppController {
//methods we should use: loadGame(), newGame/round(), isGameRunning() and its opposite, closeGame(), victory(),
// 
	
	private Game game;

	public AppController(Game game) {
        this.game = game;
    }
}
