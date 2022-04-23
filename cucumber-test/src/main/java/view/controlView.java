package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import model.board.*;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import utilities.GameSettings;
import utilities.IllegalActionException;
import utilities.Position;

import javax.imageio.ImageIO;
import javax.swing.*;



public class controlView extends JPanel implements ActionListener {
	
	private JPanel controlPanel;
	private JPanel handPanel;
	private JPanel deckPanel;
	private Player player;
	private ArrayList<Card> deck;
    Button[] handCard = new Button[5];
    Button[] subCard = new Button[9];


	
	public controlView(Player player) throws IOException {
		this.player = player;
		setLayout(null);
		
		setLocation(0,66*12+5);
		
		deck = Deck.getInstance().getDeck();
		
		SubDeck subdeck1 = new SubDeck(deck);
		
		player.setSubdeck(subdeck1.getSubdeck());
		
		
		ArrayList <Card> fakeHand = new ArrayList<Card>();
		ArrayList <Card> emptyHand = new ArrayList<Card>();

		
		fakeHand.add(player.getSubdeck().get(0));
		fakeHand.add(player.getSubdeck().get(1));
		fakeHand.add(player.getSubdeck().get(2));
		fakeHand.add(player.getSubdeck().get(3));
		fakeHand.add(player.getSubdeck().get(4));
		emptyHand.add(player.getSubdeck().get(5));

	
		
//		player.setHand(emptyHand);
		
		
	    controlPanel = new StyledJPanel(new BorderLayout());
	    handPanel = new StyledJPanel(new GridLayout(1,5));
	    deckPanel = new StyledJPanel(new GridLayout(9,1));
	    handPanel.setSize(64*15/2,175);
        controlPanel.setSize((64*15)/6*2,175);
        deckPanel.setSize((64*15)/6,175);
        
        handPanel.setLocation(5,0);
        deckPanel.setLocation(64*15/2,0);
        controlPanel.setLocation(64*15/2+(64*15)/6,0);

 
    	for (int i = 0; i<handCard.length; i++){
    		if (player.getHand().size() == 0) {
    			handCard[i] = new Button("hidden.png");
	            handPanel.add(handCard[i]);
    		}
    		
    		
    		if (player.getHand().size() == 1) {
    			handCard[i] = new Button(player.getHand().get(i).getCardImage());
	            handPanel.add(handCard[i]);
    		}
    		
    		else {
	    		handCard[i] = new Button(player.getHand().get(i).getCardImage());
	        	handCard[i].addActionListener(this);
	            handPanel.add(handCard[i]);
    		}
    			
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
		if (e.getSource() == subCard[0]) {
			try {
				player.fiveToHand(player.getSubdeck().get(0));
				revalidate();
				repaint();
				
			} catch (IllegalActionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
			
		else if (e.getSource() == handCard[0]) {
//			System.exit(1);
//		}
	
	}
}
}
	
	


