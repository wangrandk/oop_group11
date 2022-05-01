package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
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
import model.tile.Tile;
import utilities.EventList;
import utilities.GameSettings;
import utilities.IEventHandler;
import utilities.IllegalActionException;
import utilities.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import controller.GameLaunch;




public class controlView extends JPanel implements ActionListener,IEventHandler {
	
	int numCols = GameSettings.NUM_COLS;
	int numRows = GameSettings.NUM_ROWS;
	int tileSize = GameSettings.TILE_SIZE;
	private JPanel controlPanel;
	private JPanel handPanel;
	private JPanel deckPanel;
	public Player player;
    handCardButton[] handCard = new handCardButton[5];
    subCardButton[] subCard = new subCardButton[9];
    private JButton readyButton;
    private JLabel livesLabel;
    private JLabel playerNameLabel;
    private JButton nextTurnButton;
    private JLabel robotImage;
    private int a;
 

    
	

	
	public controlView(Player player) throws IOException {
		this.player = player;
		setLayout(null);
		
		setLocation(5,tileSize*numRows+15);
		
		
	    controlPanel = new StyledJPanel(null);
	    handPanel = new StyledJPanel(new GridLayout(1,5));
	    deckPanel = new StyledJPanel(new GridLayout(9,1));
	    handPanel.setSize(tileSize*numCols/2,175);
        controlPanel.setSize((tileSize*numCols)/6*2,175);
        deckPanel.setSize((tileSize*numCols)/6,175);
        
        handPanel.setLocation(0,0);
        deckPanel.setLocation(tileSize*numCols/2,0);
        controlPanel.setLocation(2*tileSize*numCols/3,0);
        

        
        
        readyButton = new JButton("Ready!!");
        readyButton.addActionListener(this);
        readyButton.setSize(70,30);
        readyButton.setLocation(35,135);
        controlPanel.add(readyButton);
        
        nextTurnButton = new JButton("Next Turn!!");
        nextTurnButton.addActionListener(this);
        nextTurnButton.setSize(70,30);
        nextTurnButton.setLocation(110,135);
        controlPanel.add(nextTurnButton);
        
        livesLabel = new JLabel();
        livesLabel.setSize(64,20);
        livesLabel.setLocation(20,30);
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
        
        
        playerNameLabel = new JLabel();
        playerNameLabel.setSize(120,20);
        playerNameLabel.setLocation(20,5);
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        playerNameLabel.setText("Player: " + player.getRobot().getName());
        controlPanel.add(playerNameLabel);
        
        
        
        robotImage = new JLabel();
        robotImage.setIcon(new ImageIcon(player.getRobot().getImage()));
        robotImage.setSize(tileSize,tileSize);
        robotImage.setLocation((tileSize*numCols)/6*2-tileSize-10,10);
        controlPanel.add(robotImage);

 
    	for (int i = 0; i<handCard.length; i++){
    		

    		handCard[i] = new handCardButton(player.getHand().get(i));
        	handCard[i].addActionListener(this);
            handPanel.add(handCard[i]);
    		}
    			
          
    	for (int i =0; i<(1*9); i++){
    		subCard[i] = new subCardButton(player.getSubdeck().get(i));
        	subCard[i].addActionListener(this);
            deckPanel.add(subCard[i]);
    	}
        
        setSize(tileSize*numCols,175);
        add(handPanel);
        add(deckPanel);
        add(controlPanel);		
	}
	
//     for (Card card : player.getSubdeck()) {
//     }
     
	
	private class subCardButton extends JButton {
        private Card normal;

		public subCardButton (Card normal){
        	this.normal = normal;
            this.setIcon(createIcon(this.getClass().getClassLoader().getResource("view/" + normal.getCardImagePick())));
            styleButton();
            this.setRolloverIcon(createIcon(this.getClass().getClassLoader().getResource("view/" + normal.getCardImagePickRollover())));

        }
       
        private ImageIcon createIcon(URL url){
            BufferedImage bi;
            try {
                bi = ImageIO.read(url);
                return new ImageIcon(bi);
            } catch(java.io.IOException e){
                System.out.println("Image could not be read");
            }
            return null;
        }

        private void styleButton(){
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            this.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (normal instanceof EmptyCard) {
                
            }
            else {
            	g.setColor(Color.WHITE);
                g.setFont(new Font("Impact", Font.PLAIN, 14));
                g.drawString(Integer.toString(normal.getpoints()), 112, 15);
            }
        }
    }
	
	private class handCardButton extends JButton {
        private Card normal;

		public handCardButton (Card normal){
        	this.normal = normal;
            this.setIcon(createIcon(this.getClass().getClassLoader().getResource("view/" + normal.getCardImage())));
            styleButton();
        }

        
        public handCardButton (Card normal, Card hover){
            this(normal);
            this.setRolloverIcon(createIcon(this.getClass().getClassLoader().getResource("view/" + hover)));
        }

        
        private ImageIcon createIcon(URL url){
            BufferedImage bi;
            try {
                bi = ImageIO.read(url);
                return new ImageIcon(bi);
            } catch(java.io.IOException e){
                System.out.println("Image could not be read");
            }
            return null;
        }

        private void styleButton(){
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            this.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (normal instanceof EmptyCard) {
                
            }
            else {
            	g.setColor(Color.WHITE);
                g.setFont(new Font("Impact", Font.PLAIN, 20));
                g.drawString(Integer.toString(normal.getpoints()), 30, 40);
            }
        }
    }


	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		if (player.isCardsChangeable()) {
			for (int i=0;i<subCard.length;i++) {
				if (e.getSource() == subCard[i]) {
					
					try {
						player.fiveToHand(player.getSubdeck().get(i));
						GUI.showGame(player);

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
						GUI.showGame(player);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}
				
		if (e.getSource() == nextTurnButton) {
			
			try {
				GameLaunch.newTurn(player);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		else if (e.getSource() == readyButton) {
			player.setReady(true);
			try {
				GUI.showGame(player);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}			
	}
		

//	public void updateStatusView() {
//		if (player.getLife() == 3) {
//        	livesLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("view/threelives.png")));
//        }
//        else if (player.getLife() == 2) {
//        	livesLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("view/twolives.png")));
//
//        }
//        else if (player.getLife() == 1) {
//        	livesLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("view/onelife.png")));
//
//        }
//        controlPanel.add(livesLabel);
//		
//		/*lifeTokensPanel.setLifeTokens(player.getLifeTokens());*/
//       // robotStatusLabel.setText("<html><FONT COLOR=WHITE>Status: </FONT>" + player.getStatus());
//        switch (player.getPlayerStatus()) {
//            case ALIVE:
//                //robotStatusLabel.setForeground(Color.GREEN);
//                break;
//            case DEAD:
//                //robotStatusLabel.setForeground(Color.RED);
//                break;
//            case KAPUT:
//                //robotStatusLabel.setForeground(Color.BLACK);
//                break;
//        }
//        //checkpointLabel.setText("Checkpoints cleared: " + player.getCheckpointID() + "/3");
//    }
	
	
	@Override
    public void onEvent(EventList.Event evt, Object o, Object o2) {
        if (EventList.Event.PICK_CARDS == evt) {
        	for (int i=0;i<subCard.length;i++) {
        		a = i;
        		subCard[i].addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//for (int i=0;i<subCard.length;i++) {
						if (e.getSource() == subCard[a]) {
							
							try {
								player.fiveToHand(player.getSubdeck().get(a));
								GUI.showGame(player);
			
							} catch (IllegalActionException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
			    }
        					
			});
		} 
        	}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




	








	public void setTurnIndicator(int turn) {
//		turnLabel1.setForeground(Color.WHITE);
//        turnLabel2.setForeground(Color.WHITE);
//        turnLabel3.setForeground(Color.WHITE);
//        turnLabel4.setForeground(Color.WHITE);
//        turnLabel5.setForeground(Color.WHITE);
//        switch (turn) {
//            case 0:
//                break;
//            case 1:
//                turnLabel1.setForeground(Color.RED);
//                break;
//            case 2:
//                turnLabel2.setForeground(Color.RED);
//                break;
//            case 3:
//                turnLabel3.setForeground(Color.RED);
//                break;
//            case 4:
//                turnLabel4.setForeground(Color.RED);
//                break;
//            case 5:
//                turnLabel5.setForeground(Color.RED);
//                break;
//        }
		
	}




	public void setRegisterCardIconsChangeable() {
//		 for (RegisterCardIcon icon : registerCardIcons) {
//	            if (icon.getCard() != null && !icon.getCard().isLocked()) {
//	                icon.setChangeable(true);
//	            }
//	        }
		
	}




	public void resetRegisterCards() {
//		for (int i = 0; i < 5; i++) {
//            if (player.getProgrammedCard(i) != null && player.getProgrammedCard(i).isLocked()) {
//                registerCardIcons[i].setCard(player.getProgrammedCard(i));
//                registerCardIcons[i].setChangeable(false);
//            } else {
//                registerCardIcons[i].removeCard();
//            }
//        }
		
	}




	public void resetNewCardButtons() {
//		pickCardsView.removeAll();
//        for (int index = 0; index < 9; index++) {
//            PickNewCardButton btn = new PickNewCardButton();
//            pickCardsView.add(btn);
//        }
//		
	}




	/**
     * Sets if the done button should be enabled.
     * @param b True to enable, false to disable.
     */
//    public void setDoneButtonEnabled(boolean b) {
//        doneButton.setEnabled(b);
//    }
//
//    /**
//     * Sets if the next turn button should be enabled.
//     * @param b True to enable, false to disable.
//     */
//    public void setNextTurnButtonEnabled(boolean b) {
//        nextTurnButton.setEnabled(b);
//    }
//
//    /**
//     * Sets if the power down button should be enabled.
//     * @param b True to enable, false to disable.
//     */
//    public void setPowerDownButtonEnabled(boolean b) {
//        powerDownButton.setEnabled(b);
//    }




	public void newCardsToPick() {
		// TODO Auto-generated method stub
//		newCardsToPick = player.getDealtCards();
//        refreshNewCardButtons();
	}




	public void setDoneButtonEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}




	public void setRegisterCardIconsNotChangeable() {
		// TODO Auto-generated method stub
//		for (RegisterCardIcon icon : registerCardIcons) {
//            icon.setChangeable(false);
//        }
	}
}

	
	


