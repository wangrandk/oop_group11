package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.AccessException;
import java.util.ArrayList;

import model.board.*;
import model.card.Card;
import model.card.Deck;
import model.card.EmptyCard;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Pit;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.IllegalActionException;
import utilities.Position;

import javax.imageio.ImageIO;
import javax.swing.*;



public class controlView extends JPanel implements ActionListener {
	
	private JPanel controlPanel;
	private JPanel handPanel;
	private JPanel deckPanel;
	public static Player player;
	private static ArrayList<Card> deck = Deck.getInstance().getDeck();;
    Button[] handCard = new Button[5];
    Button[] subCard = new Button[9];
    public static Board board;
    private Button readyButton;
    private JLabel livesLabel;
    private JLabel playerNameLabel;
    private Button nextTurnButton;
    private JLabel robotImage;
 

    public static ArrayList<Card> subdeck1 = new SubDeck(deck).getSubdeck();
    
    public static Robot playerRobot = (Robot) Board.getTile(new Position(1,4));
	

	
	public controlView(Player player, Board board) throws IOException {
		this.board = board;
		this.player = player;
		setLayout(null);
		
		setLocation(0,66*12+5);
		
		ArrayList <Card> fakeSubdeck = new ArrayList<Card>();
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));
		fakeSubdeck.add(new EmptyCard(0));


		
		player.setSubdeck(subdeck1);

		
		
		ArrayList <Card> fakeHand = new ArrayList<Card>();
		ArrayList <Card> emptyHand = new ArrayList<Card>();

		
		fakeHand.add(player.getSubdeck().get(0));
		fakeHand.add(player.getSubdeck().get(1));
		fakeHand.add(player.getSubdeck().get(2));
		fakeHand.add(player.getSubdeck().get(3));
		fakeHand.add(player.getSubdeck().get(4));
		emptyHand.add(player.getSubdeck().get(5));

	
		
//		player.setHand(emptyHand);
		
		
	    controlPanel = new StyledJPanel(null);
	    handPanel = new StyledJPanel(new GridLayout(1,5));
	    deckPanel = new StyledJPanel(new GridLayout(9,1));
	    handPanel.setSize(64*15/2,175);
        controlPanel.setSize((64*15)/6*2,175);
        deckPanel.setSize((64*15)/6,175);
        
        handPanel.setLocation(5,0);
        deckPanel.setLocation(64*15/2,0);
        controlPanel.setLocation(64*15/2+(64*15)/6,0);
        
        player.setRobot(playerRobot);

        
        
        readyButton = new Button("menu_buttons/start_btn.png","menu_buttons/start_btn_hover.png");
        readyButton.addActionListener(this);
        readyButton.setSize(50,30);
        readyButton.setLocation(35,135);
        controlPanel.add(readyButton);
        
        nextTurnButton = new Button("menu_buttons/start_btn.png","menu_buttons/start_btn_hover.png");
        nextTurnButton.addActionListener(this);
        nextTurnButton.setSize(50,30);
        nextTurnButton.setLocation(110,135);
        controlPanel.add(nextTurnButton);
        
        livesLabel = new JLabel();
        livesLabel.setSize(64,20);
        livesLabel.setLocation(5,20);
        if (player.getLife() == 3) {
        	livesLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("view/threelives.png")));
        }
        else if (player.getLife() == 2) {
        	livesLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("view/twolives.png")));

        }
        else if (player.getLife() == 1) {
        	livesLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("view/onelife.png")));

        }
        controlPanel.add(livesLabel);
        
        robotImage = new JLabel();
        robotImage.setIcon(new ImageIcon(player.getRobot().getImage()));
        robotImage.setSize(40,40);
        robotImage.setLocation(270,10);
        controlPanel.add(robotImage);

 
    	for (int i = 0; i<handCard.length; i++){
//    		if (player.getHand().size() == 0) {
//    			handCard[i] = new Button("hidden.png");
//	            handPanel.add(handCard[i]);
//    		}
    		
    		
//    		if (player.getHand().size() == 1) {
//    			handCard[i] = new Button(player.getHand().get(i).getCardImage());
//	            handPanel.add(handCard[i]);
//    		}
    		

    		handCard[i] = new Button(player.getHand().get(i).getCardImage());
        	handCard[i].addActionListener(this);
            handPanel.add(handCard[i]);
    		}
    			
    	
        			
        	
        	
          
    	for (int i =0; i<(1*9); i++){
    		subCard[i] = new Button(player.getSubdeck().get(i).getCardImagePick());
        	subCard[i].addActionListener(this);
            deckPanel.add(subCard[i]);
    	}
        
        setSize(1000,250);
        add(handPanel);
        add(deckPanel);
        add(controlPanel);

        
		
		
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0;i<subCard.length;i++) {
			if (e.getSource() == subCard[i]) {
				
				try {
					player.fiveToHand(player.getSubdeck().get(i));
					GUI.showGame(player, board);

				} catch (IllegalActionException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				

			}
			
			
		}
		for (int i=0;i<handCard.length;i++) {
			if (e.getSource() == handCard[i]) {
				
				try {
					player.replayCard(player.getHand().get(i));
					GUI.showGame(player, board);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == nextTurnButton) {
			playerRobot.setPosition(new Position(1,4));
			playerRobot.setSpawnPosition(new Position(1,4));


			for (int i = 0; i < player.getHand().size();i++) {
				Card cardMovement = player.getHand().get(i);
				
				
				
				cardMovement.setAction(playerRobot);
				Board.doObstacleAction(playerRobot, player);
				try {
					GUI.showGame(player, board);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			

		}
		
		
			
	}
}

	
	


