package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChooseMap extends JPanel implements ActionListener {
	
	
	private final JButton arrowRight;
	private final JButton arrowLeft;
	private final JButton exit;
	private final JButton start;
	private final JPanel mapPanel;
	private Image imageBG;
	private final JLabel easy;
	private final JLabel medium;
	private final JLabel hard;
	
	
	
	public ChooseMap() {
		
		
		
		
		mapPanel = new StyledJPanel(new BorderLayout());
        mapPanel.setPreferredSize(new Dimension(700,500));
        try {
			imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        start = new Button("start_btn.png","start_btn_hover.png");
        start.addActionListener(this);
        exit = new Button("exit_btn.png","exit_btn_hover.png");
        exit.addActionListener(this);
        arrowRight = new Button("plus-4x.png");
        arrowRight.addActionListener(this);
        arrowLeft = new Button("minus-4x.png");
        arrowLeft.addActionListener(this);
        easy = new StyledLabel("Easy");
        medium = new StyledLabel("Medium");
        hard = new StyledLabel("hard");
        
        mapPanel.add(arrowLeft,BorderLayout.LINE_START);
        mapPanel.add(arrowRight,BorderLayout.LINE_END);
        mapPanel.add(exit,BorderLayout.PAGE_START);
        mapPanel.add(start,BorderLayout.PAGE_END);
        mapPanel.add(easy,BorderLayout.CENTER);
        mapPanel.setLocation(100, 700);
        this.add(mapPanel);
        

		
		
	}
	
	public void showEasy() {
		mapPanel.remove(medium);
        mapPanel.add(easy,BorderLayout.CENTER);
	}
	
	public void showMedium() {
		mapPanel.remove(easy);
		mapPanel.remove(hard);
        mapPanel.add(medium,BorderLayout.CENTER);

	}
	
	public void showHard() {
		mapPanel.remove(medium);
        mapPanel.add(hard,BorderLayout.CENTER);
        
	}

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == arrowLeft) {
			showEasy();
			}
		else if (e.getSource() == arrowRight) {
			showMedium();
		}
		
		else if (e.getSource() == exit) {
			System.exit(1);
			
		}
		
		else if (e.getSource() == start) {
//			GUI.startGame();
		}
		
	}
	
}
	
	

