package model.tile;

import java.net.URL;

import utilities.Position;

public class BlankTile extends Tile{
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/blank.png");
	
	
	
	
	
	
	@Override
	public URL getImage() {
		return tileImage;
	}

	

}
