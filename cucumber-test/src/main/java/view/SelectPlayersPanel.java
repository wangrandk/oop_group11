package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SelectPlayersPanel extends JPanel implements ActionListener {
	private final JButton plus;
	private final JButton minus;
	private final JPanel buttonPanel;
	private int number;
	private JLabel welcome;
	private JLabel nbrQuestion;
	
	

	
	public SelectPlayersPanel() {
		buttonPanel = new StyledJPanel(new BorderLayout());
		plus = new Button("plus-4x.png");
		minus = new Button("minus-4x.png");
		welcome = new JLabel("Welcome to RoboRally");
		nbrQuestion = new JLabel("How many players will be playing?");
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
