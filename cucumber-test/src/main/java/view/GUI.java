package view;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import view.gamePanel;
import model.Game;
import model.board.Board;
import model.board.EasyBoard;
import model.main.Player;
import model.tile.Robot;
import utilities.EventList;
import utilities.IEventHandler;
import utilities.Position;
import view.SelectPlayersPanel;

public class GUI implements IEventHandler{
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
	private Game model;
    
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
	         /////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
    public void onEvent(EventList.Event evt, Object o, Object o2) {
        switch (evt) {

            case SHOW_GAMEPANEL:
			try {
				createGamePanels();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                createTabbedPane();
                showGamePanels();
                break;
            case NEW_ROUND:
                setGamePanelsForNewRound();
                break;
            case PICK_CARDS:
                newCardsForPlayer((Player) o);
                break;
            case NEW_TURN:
                setGamePanelsForNewTurn((int) o);
                break;
            case UPDATE_BOARD:
                for(gamePanel panel : gamePanels)
                    panel.getBoardView().update();
                break;
            case UPDATE_STATUS:
                for(gamePanel panel : gamePanels)
                    panel.getControlView().updateStatusView();
                break;
        }
    }

	private void setGamePanelsForNewTurn(int turnIndex) {
		for (gamePanel panel : gamePanels) {
            panel.getControlView().setTurnIndicator(turnIndex);
            panel.getControlView().setRegisterCardIconsNotChangeable();
            panel.getControlView().resetNewCardButtons();
            panel.getControlView().setDoneButtonEnabled(false);
            panel.getControlView().setNextTurnButtonEnabled(true);
            panel.getControlView().setPowerDownButtonEnabled(true);
        }
		
	}

	private void newCardsForPlayer(Player player) {
		for (gamePanel panel : gamePanels) {
            if (panel.getPlayer().getPlayerID() == player.getPlayerID()) {
                panel.getControlView().newCardsToPick();
                panel.getControlView().setRegisterCardIconsChangeable();
                panel.getControlView().setDoneButtonEnabled(true);
            }
        }
		
	}

	private void setGamePanelsForNewRound() {
		for (gamePanel panel : gamePanels) {
            panel.getControlView().setTurnIndicator(0);
            panel.getControlView().setRegisterCardIconsChangeable();
            panel.getControlView().resetRegisterCards();
            panel.getControlView().resetNewCardButtons();
            panel.getControlView().setNextTurnButtonEnabled(false);
            panel.getControlView().setPowerDownButtonEnabled(false);
        }
		
	}

	private void showGamePanels() {
		 mainframe.remove(chooseMap);   //is it taken from 'selectMapPanel'
	        mainframe.add(tabbedPane, BorderLayout.CENTER);
	        mainframe.revalidate();
	        mainframe.repaint();
		
	}

	private void createTabbedPane() {
		for (gamePanel panel : gamePanels) {
            tabbedPane.addTab(panel.getPlayer().getRobot().getName(),panel);
        }
		
	}

	private void createGamePanels() throws IOException {
		for (Player player : model.getPlayers()) {
            gamePanels.add(new gamePanel(player, model.getBoard()));
        }
		
	}
	
	
}
		
	

