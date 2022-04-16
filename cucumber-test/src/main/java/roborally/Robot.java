package roborally;
import java.util.Arrays;
import java.util.List;


public class Robot  extends Position {
	private  int nx; 
	private  int ny;
	List<String> orientation = Arrays.asList("N","W","S","E");
	private String CurrentOrient = this.orientation.get(0);
	Position p;
	private int life = 3;
	private boolean isYourTurn;
	
	public Robot(int x, int y) {
	    super(x,y);
	}

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
	
	public void setOrientation(String orient) {
		this.CurrentOrient = orient ;
		//ResponseMessage response = new ResponseMessage();
	    //response.setMessage("Orientation is: "+ this.CurrentOrient);
	    //return response;
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
	public void UpdatePosition() {    
	    if( getOrientation() =="N") {
	    	this.x = this.getX();
	    	this.y = this.getY() + 1;
	    }
	    if( getOrientation() =="W") {
	    	this.x = this.getX() - 1;
	    	this.y = this.getY();
	    }
	    if(getOrientation() =="S") {
	    	this.x = this.getX();
	    	this.y = this.getY() - 1;
	    }
	    if( getOrientation() =="E") {
	    	this.x = this.getX() + 1;
	    	this.y = this.getY();
	    }
	}
	/*
	public void UpdatePosition(Position position) {    
	    if(move(position) == true && getOrientation() =="N") {
	    	this.x = this.getX();
	    	this.y = this.getY() + 1;
	    }
	    if(move(position) == true && getOrientation() =="W") {
	    	this.x = this.getX() - 1;
	    	this.y = this.getY();
	    }
	    if(move(position) == true && getOrientation() =="S") {
	    	this.x = this.getX();
	    	this.y = position.getY() - 1;
	    }
	    if(move(position) == true && getOrientation() =="E") {
	    	this.x = position.getX() + 1;
	    	this.y = position.getY();
	    }
	}
	
	/*public ResponseMessage UpdatePosition() { 
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
	*/
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
/*
	public boolean equals(Object o) {	 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
 /*       if (!(o instanceof Robot)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        Robot r = (Robot) o;
         
        // Compare the data members and return accordingly
        return CurrentOrient.equals(r.CurrentOrient) 
        		//&& this.getX() == r.getX()
        		//&& this.getY() == r.getY()
        		;           
    } 
	*/
	
	public boolean equals(Object obj) {
		 if (obj instanceof Robot) {
			 return (
					 this.getX() == ((Robot) obj).getX() 
					 && 
					 this.getY() == ((Robot) obj).getY() 		
					 &&
					 this.CurrentOrient.equals(((Robot) obj).CurrentOrient) 
					 )
					 ;
		    }
	         return false;
	    	} 
		
	public String toString() {
		//return toString(i);
		return this.getX() + " : " + this.getY();
	}
	
		public static void main(String[] args) {
			Robot r = new Robot(3,1);
			System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
			r.UpdatePosition();
			System.out.println("  X is: "  + r.getX() + " Y is: " + r.getY());
			/**/
		}
}
