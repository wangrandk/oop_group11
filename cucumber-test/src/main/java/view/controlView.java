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
import utilities.Position;

import javax.imageio.ImageIO;
import javax.swing.*;



public class controlView extends JPanel implements ActionListener {
	
	private JPanel controlPanel;
	private JPanel handPanel;
	private JPanel deckPanel;
	private Player player1;
	private ArrayList<Card> deck;

	
	public controlView() throws IOException {
		setLayout(null);
		
		setLocation(0,66*12+5);
		
		player1 = new Player();
		deck = Deck.getInstance().getDeck();
		
		SubDeck subdeck1 = new SubDeck(deck);
		
		player1.setSubdeck(subdeck1.getSubdeck());
		
		Card move1 = new MoveOne(610);
		
		ArrayList <Card> fakeHand = new ArrayList<Card>();
		
		fakeHand.add(move1);
		fakeHand.add(move1);
		fakeHand.add(move1);
		fakeHand.add(move1);
		fakeHand.add(move1);
		
		
		player1.setHand(fakeHand);
		
		
	    controlPanel = new StyledJPanel(new BorderLayout());
	    handPanel = new StyledJPanel(new GridLayout(1,5));
	    deckPanel = new StyledJPanel(new GridLayout(9,1));
	    handPanel.setSize(64*15/2,175);
        controlPanel.setSize((64*15)/6*2,175);
        deckPanel.setSize((64*15)/6,175);
        
        handPanel.setLocation(5,0);
        deckPanel.setLocation(64*15/2,0);
        controlPanel.setLocation(64*15/2+(64*15)/6,0);

 
    	for (int i =0; i<(1*5); i++){
    		final JButton handCard = new Button(player1.getHand().get(i).getCardImage());
//        	handCard.addActionListener(this);
            handPanel.add(handCard);
    	}
        			
        	
        	
          
        
        for (int i =0; i<(1*9); i++){
        	final JButton subCard = new Button("../move1_pick.png","../move1_pick_rollover.png");
        	subCard.addActionListener(this);
            deckPanel.add(subCard);
            
        }
        setSize(1000,250);
        add(handPanel);
        add(deckPanel);
        add(controlPanel);

        
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	


