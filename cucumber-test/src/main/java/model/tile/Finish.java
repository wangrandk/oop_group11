package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;
import utilities.GameSettings;

public class Finish extends Tile{
	
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/finish.png");

	
	@Override
	public void doAction(Robot robot, Player player) {
		player.setPlayerStatus(GameSettings.PlayerStatus.WON);
	}

	
	@Override
	public URL getImage() {
		return tileImage;
	}
	
}
