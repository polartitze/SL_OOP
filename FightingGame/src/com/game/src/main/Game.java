package com.game.src.main;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public Game() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setFocusable(true);
		setResizable(false);
		setLocationRelativeTo(
				null);
		InGame inGame = new InGame();
		add(inGame);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
	}
	
}