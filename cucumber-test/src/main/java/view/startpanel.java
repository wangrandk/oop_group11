package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import utilities.EventList;
import utilities.EventList.Event;
import utilities.GameSettings;
import utilities.IEventHandler;



public class startpanel extends JPanel implements ActionListener,IEventHandler  {
	private JButton newGame;
	private JButton exitGame;
	private Image imageBG;
	private JPanel buttonPanel;
	String bg = GameSettings.BACKGROUND;

	

	
	public startpanel() throws IOException {
		EventList.getInstance().register(this);
	    buttonPanel = new StyledJPanel(new GridLayout(2,1));
        buttonPanel.setSize(150,100);
        setLayout(null);
        imageBG = ImageIO.read(this.getClass().getClassLoader().getResource(bg));
        newGame = new Button("menu_buttons/start_btn.png","menu_buttons/start_btn_hover.png");
        newGame.addActionListener(this);
        exitGame = new Button("menu_buttons/exit_btn.png","menu_buttons/exit_btn_hover.png");
        exitGame.addActionListener(this);
        buttonPanel.add(newGame);
        buttonPanel.add(exitGame);
        buttonPanel.setLocation(675, 450);
        add(buttonPanel);

        
		
		
		
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			EventList.getInstance().publish(EventList.Event.MAP_SELECTED, null, null);	
			//GUI.showChooseMap();
			}
		else if (e.getSource() == exitGame) {
			System.exit(1);
		}
		}
	@Override
	public void onEvent(Event evt, Object o1, Object o2) {
		  if (EventList.Event.MAP_SELECTED == evt) {
			  GUI.showChooseMap();
		  }	
	}
}
	
	


