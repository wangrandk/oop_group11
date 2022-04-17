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
    
    
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Position)) {
            return false;
        }

    }
    
}
