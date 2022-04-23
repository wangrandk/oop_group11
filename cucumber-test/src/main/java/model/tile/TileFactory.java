package model.tile;

public class TileFactory {
	
	private static TileFactory instance;

    private TileFactory() {}
    
    // Singleton -> This guarentess that we just create one instance
    public static TileFactory getInstance() {
        if(instance == null){
            instance = new TileFactory();
        }
        return instance;
    }
    
    
    /*
	 * Blank (0)
	 * POSITIVE: (1 - 10)
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
    public Tile generateTile(int tileCategory) {
        Tile tile = null;
        
        switch(tileCategory) {
        	// Blank Tile
        	case 0:
        		tile = new BlankTile();
        		break;
        	// First CheckPoint
//        	case 1:
//        		tile = new FirstCheckPoint();  DONT
//        		break;
//        	case 2:
//        		tile = new SecondCheckPoint();     DONT
//        		break;
//        	case 3:
//        		tile = new FinalCheckPoint();
//        		break;
        	case 4:
        		tile = new Robot();
        		break;
//        	case 5:
//        		tile = new HealPlayer();
//        		break;
//        	case 6:
//        		tile = new ConveyorBeltForwardOne();
//        		break;
//        	// Pit
        	case 11:
        		tile = new Pit();
        		break;
        	case 12:
        		tile = new Wall();
        		break;
//        	case 13:
//        		tile = new AlcoholicOil();
//        		break;
        	default:
        		tile = new Pit();
        		break;
        }
		return tile;
    	
    }
}
