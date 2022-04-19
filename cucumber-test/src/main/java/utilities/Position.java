package utilities;
 
public class Position {
	private int x;
	private int y;
	//protected static boolean isEmpty = true;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
   
    //need to define what is empty
    public static boolean isEmpty(int x,int y) {
    	return true;
    }
    
    @Override
    public String toString() {
        return "X=" + this.x + " Y=" + this.y;
    }
    
    

}
