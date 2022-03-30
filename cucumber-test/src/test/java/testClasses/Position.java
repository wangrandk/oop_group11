package testClasses;

public class Position {
	protected  int x;
	protected  int y;
	//protected static boolean isEmpty = true;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public  int getX() {
        return this.x;
    }

    public  int getY() {
        return this.y;
    }
    public void  setX(int x) {
         this.x=x;
    }

    public void setY(int y) {
         this.y =y;
    }
    //need to define what is empty
    public static boolean isEmpty(int x,int y) {
    	return true;
    }
}
