package model.board;

public class EasyBoard extends Board {
	

    //16 X 12
	
	/*
	 * Blank (0)
	 * POSITIVE: (1 - 10)
	 * 	- Heal(5): Increase one Life
	 *  - ConveyorBelt(6): 
	 *  	 Move one tile extra.
	 *  - Finish (3)
	 * 	
	 * NEGATIVE (11 - 20)
	 * - Pit(11): It decrease one life of the player
	 * - Wall(12): It cannot pas through it (If there is wall on the NewPosition, dont't move) 
	 * - Beer(13): It messes up the order of the hand.
	 * 
	*/
	 private final int[][] boardSettings = {   
	    		{12, 12, 12,  12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},
	    		{12,  5,  0,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  12},
	    		{12,  0, 13,  11, 12,  0,  0,  0,  0,  0, 11,  0, 13,  0,  12},
	    		{12, 12,  0,  12,  0,  6,  6,  6,  6,  6,  0,  0,  0,  0,  12},
	    		{12,  4,  0,  12,  0,  6, 13,  0, 13,  6,  0,  0,  0,  0,  12},
	    		{12, 12,  0,  12,  0,  6,  0,  3,  0,  6,  0,  0,  0,  0,  12},
	    		{12,  4,  0,  12,  5,  6, 13,  0, 13,  6,  0,  0,  0,  0,  12},
	    		{12, 12,  0,  12,  0,  6,  6,  6,  6,  6,  0,  0,  0,  0, 12},
	    		{12,  0,  0,  11, 12,  0,  0,  0,  0,  0, 11,  0,  0,  0, 12},
	    		{12,  0, 13,   0,  0,  0,  0,  0,  0,  0,  0,  0, 13,  0,  12},
	    		{12,  5,  0,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  12},
	    		{12, 12, 12,  12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,  12}};
   
    
	public EasyBoard() {
		super();
		populateBoard(boardSettings);
	}
		
	
	
	


}
