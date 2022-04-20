package view;

import java.awt.*;

import javax.swing.*;

import view.SelectPlayersPanel;

public class GUI {
	private final JFrame mainframe;
	private startpanel startPanel;
    private SelectPlayersPanel selectPlayersPanel;

//	
	public GUI() {
		mainframe = new mainframe();
		showStartPanel();
	}
	
	public void showStartPanel() {
		startPanel = new startpanel();
		mainframe.add(startPanel);
		mainframe.pack();
		mainframe.repaint();
	}
	
	public void showPlayersPanel() {
		selectPlayersPanel = new SelectPlayersPanel();
		mainframe.remove(startPanel);
		mainframe.add(selectPlayersPanel);
	}
}
