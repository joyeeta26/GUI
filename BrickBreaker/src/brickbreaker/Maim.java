/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;
import javax.swing.JFrame;

 class Main {

	public static void main(String[] args) {
		JFrame obj=new JFrame();
		obj.setBounds(10,10,700,600);
		GamePlay gp=new GamePlay();
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setLocation(320, 100);
		
		obj.add(gp);
	}

}	

