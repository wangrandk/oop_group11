package view;

import java.awt.*;
import java.io.IOException;

import model.board.*;
import utilities.GameSettings;
import utilities.Position;

import javax.imageio.ImageIO;
import javax.swing.*;



public class controlView extends JPanel {
	
	private JPanel controlPanel;
	private JPanel handPanel;
	private JPanel deckPanel;
	

	
	public controlView() throws IOException {
		setLayout(null);
		
		setLocation(0,66*12+5);
		
	    controlPanel = new StyledJPanel(new BorderLayout());
	    handPanel = new StyledJPanel(new GridLayout(1,5));
	    deckPanel = new StyledJPanel(new GridLayout(9,1));
	    handPanel.setSize(64*15/2-5,175);
        controlPanel.setSize((64*15)/6*2,175);
        deckPanel.setSize((64*15)/6-5,175);
        
        handPanel.setLocation(5,0);
        deckPanel.setLocation(64*15/2+5,0);
        controlPanel.setLocation(5+64*15/2+(64*15)/6,0);

        for (int i =0; i<(5*1); i++){
        	final JLabel label = new JLabel((Integer.toString(1+i)));
//                label.setIcon(new ImageIcon(easyBoard.getTile(new Position(i,j)).getImage()));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            handPanel.add(label);
            
        }
        
        for (int i =0; i<(1*9); i++){
        	final JLabel label = new JLabel((Integer.toString(1+i)));
//                label.setIcon(new ImageIcon(easyBoard.getTile(new Position(i,j)).getImage()));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            deckPanel.add(label);
            
        }
        setSize(1000,250);
        add(handPanel);
        add(deckPanel);
        add(controlPanel);

        
		
		
		
	}
	
}
	
	


