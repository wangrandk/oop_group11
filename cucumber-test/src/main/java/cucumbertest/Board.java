package cucumbertest;

import model.tile.Tile;

public class Board {
	
	private Tile [][] board;
	private int [] boardSettings;
	
	
	private Board(String difficulty){
		
		switch(difficulty){  
	    //Case statements  
		    case "Easy": 
		    	boardSettings = 
		    	break;  
		    
		    case "Medium":
		    	
		    	break;
		    case "Hard":
		    	
		    	break;
	    }  
		
	}
	
	private void populateBoard() {
		
	}
	
	
	public void setTile(Tile tile, Position position) {
		board[position.getX()][position.getY()] = tile;
	}
	
	
	
}
