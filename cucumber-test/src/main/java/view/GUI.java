package view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import model.board.Board;
import model.board.EasyBoard;
import model.main.Player;
import view.SelectPlayersPanel;

public class GUI {
	private static JFrame mainframe;
	private static startpanel startPanel;
    private static SelectPlayersPanel selectPlayersPanel;
    private static ChooseMap chooseMap;
    private static gamePanel gamePanel;
    private static controlView controlView;
    private static boardView boardView;
    private static Boolean isChooseMap;
    

//	
	public GUI() throws IOException {
		mainframe = new mainframe();
//		startGame();
		showStartPanel();
		}
	
	public void showStartPanel() throws IOException {
		startPanel = new startpanel();
		mainframe.add(startPanel);
		mainframe.revalidate();
		mainframe.repaint();
	}
	
	public static void showPlayersPanel() {
		selectPlayersPanel = new SelectPlayersPanel();
		mainframe.remove(startPanel);
		mainframe.revalidate();
		mainframe.repaint();
	}
	
	public static void showChooseMap() {
		chooseMap = new ChooseMap();
		mainframe.remove(startPanel);
		mainframe.add(chooseMap);
		mainframe.revalidate();
		mainframe.repaint();
		isChooseMap = true;
		
	}
	
	public static void showGame(Player player,Board board) throws IOException {
		mainframe.setPreferredSize(new Dimension(1000,1000));
		mainframe.setLayout(null);
		if (isChooseMap == true) {
			mainframe.remove(chooseMap);
			isChooseMap = false;

			
		}
		else {
			mainframe.remove(gamePanel);
		}
		

		gamePanel = new gamePanel(player,board);

		mainframe.add(gamePanel);
		mainframe.pack();
		mainframe.revalidate();

		mainframe.repaint();



	}
	
}
		
	

