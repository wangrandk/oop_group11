package controller;

import java.io.IOException;
import view.GUI;
import view.GameLaunch;

public class AppController {
	//AppController class will initialize whole application;
	public static void main(String[] args) throws IOException {
		new GameLaunch();
	    new GUI();	
	}			
}
