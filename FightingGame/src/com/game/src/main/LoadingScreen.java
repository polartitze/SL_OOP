package com.game.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingScreen extends JPanel implements KeyListener{
		
		//private Graphics g;
		static JFrame frame;
		static JPanel currentScene;
	
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			int c = e.getKeyCode();
			if(c == KeyEvent.VK_ENTER) {
				System.out.println("masuk");
				//paintComponent(g);
				currentScene = new JPanel();
				currentScene.repaint();
			}
		}
	
	
	public void paintComponent(Graphics g) { 
		g.clearRect(0, 0, 1280, 720);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		repaint();
		frame.repaint();
//		th.start();
	}
	
	public LoadingScreen() {
		frame.addKeyListener(this);
		try {
			add(new JLabel(new ImageIcon(ImageIO.read(new File("res/Olympus.png")))));
		}catch (IOException e) {
			System.out.println("Image Doesn't Exist");
		}
		setFocusable(true);
	}
	
	public static void main(String[] args) {
		frame = new JFrame("Fight For The Throne");
		
		currentScene = new LoadingScreen();
		frame.add(currentScene);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
//		System.out.println("Masuk");
//		frame.setVisible(false);
		
//		new LoadingScreen();
	}
}