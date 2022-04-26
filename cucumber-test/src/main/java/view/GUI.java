package view;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import view.gamePanel;
import model.board.Board;
import model.board.EasyBoard;
import model.main.Player;
import model.tile.Robot;
import utilities.Position;
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
    private final static ArrayList<gamePanel> gamePanels = new ArrayList<>();
    private final static JTabbedPane tabbedPane = new JTabbedPane();
    
//    static Player p1 = new Player();
//    static Player p2 = new Player();


    

//	
	public GUI() throws IOException {
		

		mainframe = new mainframe();
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
	
//	public void addGamePanels(Board board) throws IOException {
//		for (Player player : Player.players) {
//			gamePanels.add(new gamePanel(player,board));
//		}
//	}
//	
//	public void creatTabs() {
//		for (gamePanel panel : gamePanels) {
//			tabbedPane.addTab(panel.getPlayer().getRobot().getName(),panel);
//		}
//	}
	
	public static void showGame(ArrayList<Player> players,Board board) throws IOException {
//		p1.setRobot((Robot) Board.getTile(new Position(1,4)));
//		p2.setRobot((Robot) Board.getTile(new Position(1,6)));
//		mainframe.setPreferredSize(new Dimension(1000,1000));
		mainframe.setLayout(null);
		mainframe.setLayout(new BorderLayout());
		JTabbedPane tabbedPane = new JTabbedPane();
		
		for (Player player : players) {
			gamePanels.add(new gamePanel(player,board));
		}
		
		for (gamePanel panel : gamePanels) {
			tabbedPane.add(panel.getPlayer().getRobot().getName(),panel);
		}

		if (isChooseMap == true) {
			mainframe.remove(chooseMap);
			isChooseMap = false;

			
		}
		else {
			mainframe.remove(tabbedPane);
		}
		


//		tabbedPane.add("GamePanel",gamePanel);
//		tabbedPane.add("GamePanel",chooseMap);

		mainframe.add(tabbedPane);
		mainframe.pack();
		mainframe.revalidate();

		mainframe.repaint();



	}
	
	
}
		
	

