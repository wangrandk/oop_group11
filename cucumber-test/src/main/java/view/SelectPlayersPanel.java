package view;


import javax.imageio.ImageIO;
import javax.swing.*;

import model.main.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


class SelectPlayersPanel extends Player{
static Player player1;
static Player player2;
   

    
    public SelectPlayersPanel() {
    	player1 = new Player();
    	player2 = new Player();
    	
    }
}