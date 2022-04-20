//package view;
//
//import java.awt.*;
//
//import javax.swing.*;
//
//public class Demo {
//	private static void addButtons(JPanel frame){
//	    for(int y=0; y<12; y++){
//	        for(int x=0; x<15; x++){
//	            JButton grid=new JButton(x+","+y); //creates new button
//	            grid.setSize(40,40);
//	            frame.add(grid); //adds button to grid
//
//	        }
//	    }
//	
//    
//	}
//	protected void paintComponent(Graphics g) {
//    	if(g instanceof Graphics2D) {
//    		Graphics2D g2 = (Graphics2D) g;
//    		
//    		for (int i = 1; i<(15*15); i++) {
//    			g2.fillRect((5*i), (5*i), 40, 40);
//    		}
//    		
//    	}
//    }
//    public static void main(String[] args) {
//
//        JFrame jf=new JFrame();
//        
//        jf.setLayout(null);
//        jf.setPreferredSize(new Dimension(900, 900));
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setResizable(false);
//        jf.setTitle("RoboRally");
//        jf.setVisible(true);
//
//        JPanel Board=new JPanel();
//        Board.setLocation(5, 5);
//        Board.setSize(40*15+15*2,40*15+15*2);
//        Board.setLayout(new GridLayout(15,15));
//        Board.setOpaque(true);
//        Board.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        Board.setVisible(true);
//        
////        paintComponent(Board);
//        for (int i =0; i<(15*15); i++){
//            final JLabel label = new JLabel();
//            label.setPreferredSize(new Dimension(40,40));
//            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            Board.add(label);
//        }
//
//
//
//
//        
//        
//        JPanel Console = new JPanel();
//        Console.setLocation(40*15+15*2+10,5);
//        Console.setSize(200,40*15+15*2);
//        Console.setBorder(BorderFactory.createLineBorder(Color.black));
//        Console.add(new JLabel("Console"));
//
//
//        
//        
//        JPanel Cards = new JPanel();
//        Cards.setLayout(new GridLayout(1,5));
//        Cards.setLocation(5,40*15+15*2+10);
//        Cards.setSize(40*11+11*2,200);
//        Cards.setBorder(BorderFactory.createLineBorder(Color.black));
//
//        for (int i =0; i<(5*1); i++){
//            final JLabel label = new JLabel("Turn "+(i+1));
//            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            Cards.add(label);
//        }
//
//        
//        
//        JPanel Deck = new JPanel();
//        Deck.setLayout(new GridLayout(9,1));
//
//        Deck.setLocation(40*11+11*2+10,40*15+15*2+10);
//        Deck.setSize(40*4+4*2-5,200);
//
//        Deck.setBorder(BorderFactory.createLineBorder(Color.black));
//
//
//        for (int i =0; i<(9*1); i++){
//            final JLabel label = new JLabel("Card "+(i+1));
//            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            Deck.add(label);
//        }
//        
//        
//        JPanel Controls = new JPanel();
//        Controls.setLocation(40*15+15*2+10,40*15+15*2+10);
//        Controls.setSize(200,200);
//        Controls.setBorder(BorderFactory.createLineBorder(Color.black));
//        Controls.add(new JLabel("Controls"));
//
//
//        
//        
//                
//        	
//        jf.add(Board);
//        jf.add(Console);
//        jf.add(Cards);
//        jf.add(Deck);
//        jf.add(Controls);
////        addButtons(Board);
//        jf.pack();
//        
//        jf.repaint();
//        }
//}