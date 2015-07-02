/**
 * 
 */
package com.test.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyTankGame1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4283035608714969430L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyTankGame1();
	}

	// ���캯��
	public MyTankGame1() {
		MyPanel mp = new MyPanel();

		// ����mp�߳�
		Thread t = new Thread(mp);
		t.start();

		this.add(mp);
		this.addKeyListener(mp);
		this.setIconImage(new ImageIcon("TankImage/TANK.jpg").getImage());
		this.setTitle("̹�˴�ս");
		this.setLocation(350, 100);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}