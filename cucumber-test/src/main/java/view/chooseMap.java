package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class chooseMap extends JPanel implements ActionListener {
	
	
	private final JButton arrowRight;
	private final JButton arrowLeft;
	private final JButton exit;
	private final JButton start;
	private final JPanel maps;
	
	
	public chooseMap() {
		maps = new StyledJPanel(new BorderLayout());
        start = new JButton("start");
        exit = new JButton("exit");
        arrowRight = new JButton("right");
        arrowLeft = new JButton("left");
        maps.add(arrowLeft);
        maps.add(arrowRight);
        maps.add(exit);
        maps.add(start);
        

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
