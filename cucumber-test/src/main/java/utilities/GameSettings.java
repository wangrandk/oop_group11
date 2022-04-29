package utilities;

import java.awt.Image;

import javax.imageio.ImageIO;

public class GameSettings {
	
	
	public static final int NUM_COLS = 15;
	public static final int NUM_ROWS = 12; 
	public static final int TILE_SIZE = 62;
	public static final String BACKGROUND = "view/background.jpeg";

	public enum Orientation {
	    NORTH,
	    WEST,
	    EAST,
	    SOUTH
	}
	
	public enum PlayerStatus{
		ALIVE,
		DEAD,
		WON,
		POWERDOWN
	}
}


