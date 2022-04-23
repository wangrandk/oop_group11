package model.board;

public class FinalBoard extends Board {
	

    //16 X 12
	
	/*
	 * Blank (0)
	 * POSITIVE: (1 - 10)
	 *  - FirstCheckPoint(1):
	 *  - SecondCheckPoint(2):
	 *  - ThreeCheckPoint(3):
	 *  - RobotStarPosition(4)
	 * 	- Heal(5): Increase one Life
	 *  - ConveyorBelt(6): 
	 *  	 Move one tile extra.
	 * 	
	 * NEGATIVE (11 - 20)
	 * - Pit(11): It decrease one life of the player
	 * - Wall(12): It cannot pas through it (If there is wall on the NewPosition, dont't move) 
	 * - Beer(13): It messes up the order of the hand.
	 * 
	*/
    private final int[][] boardSettings = {   
    		{12,  12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,  12},
    		{12,  12, 11, 11,  0,  0,  0,  0,  0,  0,  0,  0, 11, 11,  12},
    		{12,  12, 11, 11,  6,  0,  0,  0,  0,  0, 12,  0, 11, 11,  12},
    		{12,  12,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6, 11,  5,  12},
    		{12,   4,  0, 12,  6,  5, 11, 12, 12, 11, 11,  6, 11,  0,  12},
    		{12,  12,  0, 12,  6, 11, 11, 11,  3, 11, 11,  6,  0,  0,  12},
    		{12,   4,  0, 12,  6, 11, 11, 13, 11, 11, 11,  6,  0,  0,  12},
    		{12,  12,  0, 12,  6, 11, 11, 12, 12, 11,  5,  6,  0,  0,  12},
    		{12,   0,  0,  0,  6,  6,  6,  6,  6,  6,  6,  6,  0,  0,  12},
    		{12,  12, 11, 11,  0,  0,  0,  0,  0,  0,  0,  0, 11, 11,  12},
    		{12,  12, 11, 11,  5,  0,  0,  0,  0,  0,  0,  0, 11, 11,  12},
    		{12,  12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,  12}};
    
    
	public FinalBoard() {
		super();
		populateBoard(boardSettings);
	}
		
	
	
	


}
