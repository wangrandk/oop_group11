package utilities;

public class GameSettings {
	
	
	public static final int NUM_COLS = 15;
	public static final int NUM_ROWS = 12;

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
		POWERDOWN,
		KAPUT
	}
}


