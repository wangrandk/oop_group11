package model.board;

public class EasyBoard extends Board {
	

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
    		{11,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  3,  0},
    		{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
    		{ 4,  0,  0,  0,  6,  0,  1,  0,  0,  0, 12,  0,  0,  0,  0},
    		{12,  0,  0,  0,  0,  0, 11,  0, 11,  0,  0,  0, 11,  0,  0},
    		{ 4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 11,  0,  0},
    		{12,  0,  0,  6,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
    		{ 4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  11},
    		{12,  0,  0,  0,  0,  0,  0,  5,  0,  0,  0,  0,  0,  0,  0},
    		{ 4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
    		{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
    		{ 0,  0,  0,  0,  0,  0,  5,  0,  2,  0,  0,  0,  0,  0,  0},
    		{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}};
    
    
	public EasyBoard() {
		super();
		populateBoard(boardSettings);
	}

}
