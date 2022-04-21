package view;

import java.awt.*;

import javax.swing.*;

import view.SelectPlayersPanel;

public class GUI {
	private final JFrame mainframe;
	private startpanel startPanel;
    private SelectPlayersPanel selectPlayersPanel;
    private chooseMap chooseMap;

//	
	public GUI() {
		mainframe = new mainframe();
		chooseMap();
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
	
	public void chooseMap() {
		chooseMap = new chooseMap();
		mainframe.remove(startPanel);
		mainframe.add(chooseMap);
	}
}
