package com.game.src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class InGame extends JFrame implements ActionListener{
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	Timer tm = new Timer(5, this);
	
	private Image dbImage;
	private Graphics dbg;
//	
//	private boolean falling = true;
//	private boolean jumping = false;
//	
	private float gravity = 0.05f;
	private final int MAX_SPEED = 10;

	Rectangle p = new Rectangle(256, 460, 220, 220);
	ImageIcon img = new ImageIcon("res/Zeus.png");
	ImageIcon imgfw = new ImageIcon("res/Zeus Forward.png");
	ImageIcon tile = new ImageIcon("res/Brick_Block.png");
	ImageIcon bg = new ImageIcon("res/sky.png");
	private int x = 0, y = 0;
	private int w, h;
	private int velX = 0, velY = 0;
	private int detect = 0;
	boolean isRight = false;
	boolean isLeft = false;
	
	private boolean left, right, special;

	KeyListener keyListener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			velX = 0;
			velY = 0;
			detect = 0;
			if(e.getKeyCode() == KeyEvent.VK_D)
				isRight = false;
			if(isRight) {
				velX = 5;
				velY = 0;
				detect = 2;
			}
			System.out.println(isRight);
			if(e.getKeyCode() == KeyEvent.VK_A)
				isLeft = false;
			if(isLeft) {
				velX = -5;
				velY = 0;
				detect = 2;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				velX = -5;
				velY = 0;
				detect = 1;
				isLeft = true;
				break;
			case KeyEvent.VK_D:
//				p.x += 40;
				velX = 5;
				velY = 0;
				detect = 2;
				isRight = true;
				break;
//			case KeyEvent.VK_W:
//				velX = 0;
//				velY = -10;
//				break;
//			case KeyEvent.VK_S:
//				velX = 0;
//				velY = 10;
//				break;
			default:
				break;
			}
			repaint();
		}
	};

	Thread th = new Thread(() -> {
		while (true) {
			x++;
			x%=3;
			if(x == 0) {
				y++;
				y%=3;
			}
			repaint();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});

	public InGame() {
		tm.start();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		w = img.getIconWidth() / 3;
		h = img.getIconHeight() / 3;
		addKeyListener(keyListener);
		th.start();
	}

	@Override
	public void paint(Graphics g) {
		dbImage = createImage(WIDTH, HEIGHT);
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent	(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		// background
		g.drawImage(bg.getImage(), 0, 0, WIDTH, HEIGHT, null);
		
		// tile
		for(int i=0; i<=1280; i+=80) {
			g.drawImage(tile.getImage(), i, 640, 80, 80, null);
		}
		
		// character
		if(detect == 0) {
			g.drawImage(img.getImage(), p.x, p.y, p.x+220, p.y+220, x*w, y*h, (x*w)+w, (y*h)+h, null);
		}
		else if(detect == 1) {
			g.drawImage(img.getImage(), p.x, p.y, p.x+220, p.y+220, x*w, y*h, (x*w)+w, (y*h)+h, null);
		}
		else if(detect == 2) {
			g.drawImage(imgfw.getImage(), p.x, p.y, p.x+220, p.y+220, x*w, y*h, (x*w)+w, (y*h)+h, null);
		}
		
		// wall
		for(int i=0; i<=720; i+=80) {
			g.drawImage(tile.getImage(), 0, i, 80, 80, null);
		}
		for(int i=0; i<=720; i+=80) {
			g.drawImage(tile.getImage(), 1200, i, 80, 80, null);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(p.x < 0) {
			velX = 0;
			p.x = 0;
		}
		if(p.x > WIDTH-220) {
			velX = 0;
			p.x = WIDTH-220;
		}
		if(p.y < 0) {
			velY = 0;
			p.y = 0;
		}
		if(p.y > HEIGHT-220) {
			velY = 0;
			p.y = HEIGHT-220;
		}
		p.x += velX;
		p.y += velY;
		
		repaint();
	}

	public static void main(String[] args) {
		new InGame();
	}

}