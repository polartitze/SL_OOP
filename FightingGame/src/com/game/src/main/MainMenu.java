package com.game.src.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JFrame{
	Rectangle play = new Rectangle(300, 150, 100, 50);
	Rectangle help = new Rectangle(300, 225, 100, 50);
	Rectangle quit = new Rectangle(300, 300, 100, 50);
	
	String[] menu = {
			"Play", //0
			"Help", //1
			"Quit", //2
	};
	
	private int status;
	
	KeyListener keyListener = new KeyListener() {
	
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				
				
				
				break;
			}
			
		}
	};
	
	public MainMenu() {
		setTitle("INI CONTOH MENU");
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
         
        // Add the menubar to the frame
        setJMenuBar(menuBar);
         
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
         
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem cutAction = new JMenuItem("Cut");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuItem pasteAction = new JMenuItem("Paste");
        
        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.addSeparator();	//membuat garis pemisah pada menu bar
        fileMenu.add(exitAction);
        
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        
        helpMenu.add("Just wanna try something :v");

       
        setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1000, 1000);
		g.drawString("FIGHTING GAME", 320, 150);
		g.fillRect(play.x, play.y, play.width, play.height);
		g.setColor(Color.WHITE);
		g.drawString("PLAY", 335, 180);
		
		
		g.setColor(Color.BLACK);
		g.fillRect(help.x, help.y, help.width, help.height);
		g.setColor(Color.WHITE);
		g.drawString("HELP", 335, 255);
		
		g.setColor(Color.BLACK);
		g.fillRect(quit.x, quit.y, quit.width, quit.height);
		g.setColor(Color.WHITE);
		g.drawString("QUIT", 335, 330);
		
	}
	
	public static void main(String[] args) {
		new MainMenu();

	}

}
