package utilities;

public class IllegalActionException extends Exception {
	public IllegalActionException(String msg) {
        super(msg);
        
        //every time you want to raise an exception, depending on type of error, do the following...
        //throw new IllegalActionException("Your piece already occupies this spot."); ,or any other built-in java exceptions
    }
}
