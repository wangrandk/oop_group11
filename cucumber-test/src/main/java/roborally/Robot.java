package roborally;
import java.util.Arrays;
import java.util.List;


public class Robot  extends Position {
	private  int nx; 
	private  int ny;
	List<String> orientation = Arrays.asList("N","W","S","E");
	private String CurrentOrient = this.orientation.get(0);
	Position p;
	public Robot(int x, int y) {
	    super(x,y);
	}
	
	private int life = 3;
	private boolean isYourTurn;
	
	public boolean isLifeNull() {
		if(this.getLife() != 0) {
			return false;
		}
		return true;
	}
	
	public void setTurnStatus(boolean isYourTurn) {
		this.isYourTurn = isYourTurn;
	}
	
	public boolean getTurnStatus() {
		return this.isYourTurn;
	}
	
	public int getLife() {
		return this.life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	
	public String getOrientation() {
		return this.CurrentOrient;
	}
	
	public ResponseMessage setOrientation(String orient) {
		this.CurrentOrient = orient ;
		ResponseMessage response = new ResponseMessage();
	    response.setMessage("Orientation is: "+ this.CurrentOrient);
	    return response;
	}
	
	public  void setPosition(int x, int y) {
		this.x = x;
	    this.y = y;	   
	}
	
	public void getPosition() {
		this.x = this.getX();
		this.y = this.getY();
		
		//return this.x + this.y; 
		System.out.println("  X is: "  + this.x + " Y is: " + this.y);
	}
	public boolean isValidPosition(Position newPosition) {
	    this.nx = newPosition.x; 
	    this.ny = newPosition.y; 
		if(Position.isEmpty(this.nx, this.ny) == true ) {
			return true;
		}
		return false;
	}

	public  boolean move(Position newPosition) {
		if(isLifeNull() == false && isYourTurn == true && isValidPosition(newPosition)== true) {
			return true;
		}
		return false;
		
	}
	public void UpdatePosition(Position position) {    
	   /* if(move(position) == true && getOrientation() =="N") {
	    	Robot.x = position.getX();
	    	Robot.y = position.getY() + 1;
	    }
	    if(move(position) == true && getOrientation() =="W") {
	    	Robot.x = position.getX() - 1;
	    	Robot.y = position.getY();
	    }
	    if(move(position) == true && getOrientation() =="S") {
	    	Robot.x = position.getX();
	    	Robot.y = position.getY() - 1;
	    }
	    if(move(position) == true && getOrientation() =="E") {
	    	Robot.x = position.getX() + 1;
	    	Robot.y = position.getY();
	    }*/
	}
	public ResponseMessage UpdatePosition() { 
		ResponseMessage response = new ResponseMessage();
		if( getOrientation() =="N") {
	    	this.x = this.x;
	    	this.y = this.y  + 1;
	    	response.setMessage("x: "+ this.x + ", y: " + this.y);
	    }
	    if(getOrientation().equals("W")) {
	    	this.x = this.x - 1;
	    	this.y = this.y;
	    	response.setMessage("x: "+ this.x + ", y: " + this.y);
	    }
	    if( getOrientation() =="S") {
	    	this.x = this.x;
	    	this.y = this.y - 1;
	    	response.setMessage("x: "+ this.x + ", y: " + this.y);
	    }
	    if( getOrientation() =="E") {
	    	this.x = this.x + 1;
	    	this.y = this.y;
	    	response.setMessage("x: "+ this.x + ", y: " + this.y);
	    }
		return response;
	}
	
	public ResponseMessage RotateLeft() {
		ResponseMessage response = new ResponseMessage();
		if( getOrientation() =="N") {
	    	this.CurrentOrient = "W";
	    	response.setMessage("Orientation is: "+ this.CurrentOrient);
	    } 
		else if(getOrientation() =="W") {
			this.CurrentOrient = "S";
			response.setMessage("Orientation is: "+ this.CurrentOrient);
		}
		else if(getOrientation() =="S") {
			this.CurrentOrient = "E";
			response.setMessage("Orientation is: "+ this.CurrentOrient);
		}
		else if(getOrientation() =="E") {
			this.CurrentOrient = "N";
			response.setMessage("Orientation is: "+ this.CurrentOrient);
		}
		return response;
	}
	
	public ResponseMessage RotateRight() {
		ResponseMessage response = new ResponseMessage();
		if( getOrientation() =="N") {
	    	this.CurrentOrient = "E";
	    	response.setMessage("Orientation is: "+ this.CurrentOrient);
	    } 
		else if(getOrientation() =="W") {
			this.CurrentOrient = "N";
			response.setMessage("Orientation is: "+ this.CurrentOrient);
		}
		else if(getOrientation() =="S") {
			this.CurrentOrient = "W";
			response.setMessage("Orientation is: "+ this.CurrentOrient);
		}
		else if(getOrientation() =="E") {
			this.CurrentOrient = "S";
			response.setMessage("Orientation is: "+ this.CurrentOrient);
		}
		return response;
	}
		
	
		public static void main(String[] args) {
			Robot r = new Robot(3,1);
			System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
			r.UpdatePosition();
			System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
			/**/
		}
}
