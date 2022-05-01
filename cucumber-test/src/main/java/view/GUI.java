package view;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import controller.GameLaunch;
import view.gamePanel;
import model.Game;
import model.board.Board;
import model.board.EasyBoard;
import model.main.Player;
import model.tile.Robot;
import utilities.EventList;
import utilities.GameSettings;
import utilities.IEventHandler;
import utilities.Position;
import utilities.EventList.Event;

public class GUI implements IEventHandler {
	private static JFrame mainframe;
	private static startpanel startPanel;
    private static ChooseMap chooseMap;
    private static gamePanel gamePanel;
    private static controlView controlView;
    private static boardView boardView;
    private static Boolean isChooseMap;
    private final static ArrayList<gamePanel> gamePanels = new ArrayList<>();
    private static JTabbedPane tabbedPane;
	private static JPanel gameOverPanel;
	private static int tileSize = GameSettings.TILE_SIZE;
	private static int numCols = GameSettings.NUM_COLS;

//	
	public GUI() throws IOException {
		
		EventList.getInstance().register(this);
		mainframe = new mainframe();
		//showStartPanel();
		EventList.getInstance().publish(EventList.Event.SHOW_GAMEPANEL, null, null);	
		}
	
	public void showStartPanel() throws IOException {
		startPanel = new startpanel();
		mainframe.add(startPanel);
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
	
	
	public static void showGame(Player player) throws IOException {	
		

		if (isChooseMap == true) {
			
			mainframe.setPreferredSize(new Dimension(tileSize*numCols+30,1000));
			mainframe.setLayout(new BorderLayout());
			GameLaunch.setRobots();

			mainframe.remove(chooseMap);
			isChooseMap = false;
			tabbedPane = new JTabbedPane();

			for (Player p : Player.players) {
				gamePanels.add(new gamePanel(p));
			}
			
			for (gamePanel panel : gamePanels) {
				tabbedPane.add(panel.getPlayer().getRobot().getName(),panel);
			}
			mainframe.pack();

		}
		else {
			mainframe.remove(tabbedPane);
			tabbedPane = new JTabbedPane();


			gamePanels.clear();
			
			for (Player p : Player.players) {
				gamePanels.add(new gamePanel(p));
			}
			
			for (gamePanel panel : gamePanels) {
				tabbedPane.add(panel.getPlayer().getRobot().getName(),panel);
			}
			tabbedPane.setSelectedIndex(Player.players.indexOf(player));

		}

//		tabbedPane.add("GamePanel",gamePanel);
//		tabbedPane.add("GamePanel",chooseMap);
		mainframe.add(tabbedPane);
		mainframe.revalidate();

	}
	
	public static void showGameOverPanel(Player player) throws IOException {
		mainframe.setPreferredSize(new Dimension(tileSize*numCols+30,1000));
		gameOverPanel = new gameOverPanel(player);
		mainframe.add(gameOverPanel);
		mainframe.revalidate();
	}
	
	
	         /////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////	
//	@Override
    public void onEvent(EventList.Event evt, Object o, Object o2) {
//    		  if (EventList.Event.MAP_SELECTED == evt) {
//    			  showChooseMap();
//    		  }	
        switch (evt) {

            case SHOW_GAMEPANEL:
			try {
				showStartPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                break;
        }
    }
}		
	

