package brickbreaker;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.Timer;

import javax.swing.JPanel;

 class GamePlay extends JPanel implements KeyListener, ActionListener{
	private boolean play=false;				//game shouldn't play by itself at the start
	private int score=0;
	private int total_bricks=21;
	private Timer time;
	private int delay=8;
	
	private int playerx=310;
	private int ballx=120;
	private int bally=350;
	
	private int ballXdir=-1;
	private int ballYdir=-2;
	
	public GamePlay()
	{
		addKeyListener(this);
	
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		time=new Timer(delay, this);
	}
	
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 592);
		
		//borders
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//paddle
		g.setColor(Color.GREEN);
		g.fillRect(playerx, 550, 100, 8);
		
		//ball
		g.setColor(Color.YELLOW);
		g.fillOval(ballx, bally, 20, 20);
		
		g.dispose();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		time.start();
		if(play)
		{
			ballx+=ballXdir;
			bally+=ballYdir;
		}
		if(ballx<0)
		{
			ballXdir=-ballXdir;
		}
		if(bally<0)
		{
			ballYdir=-ballYdir;
		}
		if(ballx>670)
		{ 
			ballXdir=-ballXdir;
		}
		repaint();
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)	//right key is pressed
		{
			if(playerx>=600)
				playerx=600;
			else
				moveRight();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(playerx<=10)
				playerx=10;
			else
				moveLeft();
		}
		
	}
	public void moveRight()
	{
		play=true;					//as it was made false earlier
		playerx+=20;
	}
	public void moveLeft()
	{
		play=true;
		playerx-=20;
	}

	

}
