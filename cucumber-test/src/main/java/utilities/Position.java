package utilities;

public class Position {
	protected static int x;
	protected static int y;
	//protected static boolean isEmpty = true;

    public Position(int x, int y) {
        Position.x = x;
        Position.y = y;
    }
 
    public int getX() {
        return Position.x;
    }

    public int getY() {
        return Position.y;
    }
    //need to define what is empty
    public static boolean isEmpty(int x,int y) {
    	return true;
    }
}
