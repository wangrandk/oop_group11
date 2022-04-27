package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.board.Board;
import model.main.Player;
import model.tile.Robot;
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
	static Player player1;


	
	
	
	
	public ChooseMap() {
		
		player1 = new Player();
		
		player1.setRobot((Robot) Board.getTile(new Position(1,4)));
		
        setLayout(null);
		mapPanel = new StyledJPanel(new BorderLayout());
        mapPanel.setSize(800,500);
        try {
			imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("view/roborally_start.jpg"));
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
        title.setLocation(250,25);
        
       
        
        
        mapPanel.add(arrowLeft,BorderLayout.WEST);
        mapPanel.add(arrowRight,BorderLayout.EAST);
        mapPanel.add(start,BorderLayout.SOUTH);
        mapPanel.add(easyPic,BorderLayout.CENTER);
        mapPanel.add(title, BorderLayout.NORTH);
        easy = true;
        add(mapPanel);
        mapPanel.setLocation(750-400,250);
        

		
		
	}
	
	
	
	
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
//				GUI.showGame(Player.players,new model.board.BlankBoard());
				GUI.showGame(player1,new model.board.BlankBoard());

//				p1.setRobot((Robot) Board.getTile(new Position(1,4)));
//				p1.setRobot((Robot) Board.getTile(new Position(1,6)));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		else if (e.getSource() == start && medium == true) {
			try {
//				GUI.showGame(Player.players,new model.board.MediumBoard());
				GUI.showGame(roboController.p1,roboController.boards.get(1));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
		
		else {
			try {
//				GUI.showGame(Player.players,new model.board.FinalBoard());
				GUI.showGame(roboController.p1,roboController.boards.get(2));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
			
		}
		
		
		
	}
	
}
	
	

