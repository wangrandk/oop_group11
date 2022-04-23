package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChooseMap extends JPanel implements ActionListener {
	
	
	private static BorderLayout layout;
	private final JButton arrowRight;
	private final JButton arrowLeft;
//	private final JButton exit;
	private final JButton start;
	private final JPanel mapPanel;
	private Image imageBG;
	private final JLabel easyLabel;
	private final JLabel mediumLabel;
	private final JLabel hardLabel;
	private boolean easy;
	private boolean medium;
	private boolean hard;
	private JButton title;
	
	
	
	
	public ChooseMap() {
		
		
		
        setLayout(null);
		mapPanel = new StyledJPanel(new BorderLayout());
        mapPanel.setSize(800,500);
        try {
			imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        start = new Button("start_btn.png","start_btn_hover.png");
        start.addActionListener(this);
//        exit = new Button("exit_btn.png","exit_btn_hover.png");
//        exit.addActionListener(this);
//        arrowRight = new Button("plus-4x.png");
        arrowRight = new Button("arrowRight.png");
        arrowRight.addActionListener(this);
//        arrowLeft = new Button("minus-4x.png");
        arrowLeft = new Button("arrowLeft.png");
        arrowLeft.addActionListener(this);
        easyLabel = new StyledLabel("Easy");
        mediumLabel = new StyledLabel("Medium");
        hardLabel = new StyledLabel("hard");
        title = new Button("../text/difficulty.png");
        title.setLocation(250,25);
        mapPanel.add(arrowLeft,BorderLayout.WEST);
        mapPanel.add(arrowRight,BorderLayout.EAST);
//        mapPanel.add(exit,BorderLayout.NORTH);
        mapPanel.add(start,BorderLayout.SOUTH);
        mapPanel.add(easyLabel,BorderLayout.CENTER);
        mapPanel.add(title, BorderLayout.NORTH);
        easy = true;
        add(mapPanel);
        mapPanel.setLocation(750-400,250);
        

		
		
	}
	
//	public void addListeners() {
//		int level = 1;
//		BorderLayout layout = (BorderLayout)mapPanel.getLayout();
//		arrowLeft.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//		switch (level) {
//		case 1:
//			mapPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
//	        mapPanel.add(easyLabel,BorderLayout.CENTER);
//	        break;
//	        
//		case 2:
//			mapPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
//	        mapPanel.add(mediumLabel,BorderLayout.CENTER);
//	        level--;
//	        break;
//		case 3:
//			mapPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
//	        mapPanel.add(hardLabel,BorderLayout.CENTER);
//	        level--;
//	        break;
//		}
//		}
//	});
//	}
	
	
	public void showEasy() {
		layout = (BorderLayout)mapPanel.getLayout();
		mapPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        mapPanel.add(easyLabel,BorderLayout.CENTER);
        mapPanel.revalidate();
        mapPanel.repaint();
        medium = false;
        easy = true;
	}
	
	public void showMedium() {
		layout = (BorderLayout)mapPanel.getLayout();
		mapPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        mapPanel.add(mediumLabel,BorderLayout.CENTER);
        mapPanel.revalidate();
        mapPanel.repaint();
        medium = true;

	}
	
	public void showHard() {
		layout = (BorderLayout)mapPanel.getLayout();
		mapPanel.remove(ChooseMap.layout.getLayoutComponent(BorderLayout.CENTER));
        mapPanel.add(hardLabel,BorderLayout.CENTER);
        mapPanel.revalidate();
        mapPanel.repaint();
        medium = false;
        hard = true;
        
	}

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(arrowLeft) && medium == true) {
			showEasy();
			}
		else if (e.getSource().equals(arrowRight) && easy == true) {
			easy = false;
			showMedium();
		}
		
		else if (e.getSource().equals(arrowRight) && medium == true) {
			showHard();
		}
		
		else if (e.getSource().equals(arrowLeft) && hard == true) {
			hard = false;
			showMedium();
		}
		
		else if (e.getSource().equals(arrowLeft) && easy == true) {
		
		}
		
		else if (e.getSource().equals(arrowRight) && hard == true) {
			
		}
		
//		else if (e.getSource() == exit) {
//			System.exit(1);
//			
//		}
		
		
		else if (e.getSource() == start) {
			try {
				GUI.startGame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else {
			
		}
		
		
		
	}
	
}
	
	

