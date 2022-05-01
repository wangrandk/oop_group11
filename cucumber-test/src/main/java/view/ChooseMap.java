package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.GameLaunch;
import model.board.BlankBoard;
import model.board.Board;
import model.main.Player;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class ChooseMap extends JPanel implements ActionListener {
	
	
	private static BorderLayout layout;
	private final JButton arrowRight;
	private final JButton arrowLeft;
//	private final JButton exit;
	private final JButton start;
	private final JPanel mapPanel;
	private Image imageBG;
	private final JLabel easyPic;
	private final JLabel mediumPic;
	private final JLabel hardPic;
	private boolean easy;
	private boolean medium;
	private boolean hard;
	private JLabel title;
	String bg = GameSettings.BACKGROUND;



	
	
	
	
	public ChooseMap() {
	
		
		
		
        setLayout(null);
		mapPanel = new StyledJPanel(new BorderLayout());
        mapPanel.setSize(800,500);
        try {
			imageBG = ImageIO.read(this.getClass().getClassLoader().getResource(bg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        start = new Button("menu_buttons/start_btn.png","menu_buttons/start_btn_hover.png");
        start.addActionListener(this);
        
        
        arrowRight = new Button("menu_buttons/arrowRight.png");
        arrowRight.addActionListener(this);
        
        arrowLeft = new Button("menu_buttons/arrowLeft.png");
        arrowLeft.addActionListener(this);
        
        
        easyPic = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("view/maps/easyBoard.png")));
        
        mediumPic = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("view/maps/mediumBoard.png")));

        
        hardPic = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("view/maps/hardBoard.png")));

        
        title = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("view/text/difficulty.png")));
        
       
        
//        levelPanel.add(easyLabel,BorderLayout.NORTH);
//        levelPanel.add(easyPic,BorderLayout.CENTER);
        
        mapPanel.add(arrowLeft,BorderLayout.WEST);
        mapPanel.add(arrowRight,BorderLayout.EAST);
        mapPanel.add(start,BorderLayout.SOUTH);
        mapPanel.add(easyPic,BorderLayout.CENTER);
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
        mapPanel.add(easyPic,BorderLayout.CENTER);
        mapPanel.revalidate();
        mapPanel.repaint();
        medium = false;
        easy = true;
	}
	
	public void showMedium() {
		layout = (BorderLayout)mapPanel.getLayout();
		mapPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        mapPanel.add(mediumPic,BorderLayout.CENTER);
        mapPanel.revalidate();
        mapPanel.repaint();
        medium = true;

	}
	
	public void showHard() {
		layout = (BorderLayout)mapPanel.getLayout();
		mapPanel.remove(ChooseMap.layout.getLayoutComponent(BorderLayout.CENTER));
        mapPanel.add(hardPic,BorderLayout.CENTER);
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
		
		else if (e.getSource() == start && easy == true) {
			try {
				GameLaunch.setBoard(1);
				GUI.showGame(null);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		else if (e.getSource() == start && medium == true) {
			try {
				GameLaunch.setBoard(2);

				GUI.showGame(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
		
		else {
			try {
				GameLaunch.setBoard(3);

				GUI.showGame(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
			
		}
		
		
		
	}
	
}
	
	

