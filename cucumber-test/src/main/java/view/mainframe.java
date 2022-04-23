package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class mainframe extends JFrame {
	

	public mainframe() {
		Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage("https://dbdzm869oupei.cloudfront.net/img/sticker/large/8340.jpg");
        setIconImage(img);
        setTitle("RoboRally");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setPreferredSize(new Dimension(1500,1000));
		setVisible(true);

		pack();

	}

	

}
