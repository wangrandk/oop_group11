package controller;

import model.Game;

public class AppController {
	//AppController class will initialize whole application;
		private GameController gameController;

		public AppController() {
	        initGameController();
		}

	    private void initGameController() {
	        if (gameController == null) {
	            gameController = new GameController();
	        } else {
	            System.out.println("Game is already running");
	        }
	    }
		
	}
