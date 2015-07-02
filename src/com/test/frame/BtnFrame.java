package com.test.frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BtnFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3139493953911619207L;

	public BtnFrame() {
		this.setLayout(new BorderLayout());
		this.setSize(400, 400);
		final A1Panel a1 = new A1Panel();
		this.getContentPane().add(a1, BorderLayout.CENTER);
		JPanel a2 = new JPanel();
		this.getContentPane().add(a2, BorderLayout.NORTH);
		JPanel a3 = new JPanel();
		this.getContentPane().add(a3, BorderLayout.SOUTH);
		JButton btn = new JButton("更新数据");
		a3.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] xValue = new int[10];
				int[] yValue = new int[10];
				for (int i = 0; i < yValue.length; i++) {
					xValue[i] = (int) (Math.random() * 400);
					yValue[i] = (int) (Math.random() * 400);
				}
				// TODO Auto-generated method stub
				a1.updateData(xValue, yValue);
				a1.repaint();
			}
		});

	}

	public static void main(String[] args) {
//		BtnFrame btnFrm = new BtnFrame();
//		btnFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		btnFrm.setLocationRelativeTo(null);
//		btnFrm.setVisible(true);
		
		int test = 0;
		int[] p = new int[17];
		int head = 0;
		for(int i=0;i < 16; i++){
			p[i] = i+1;
		}
		p[16] = 0;
		test = 0;
		while(test != p[test]){
			for (int i = 0; i < 3;i++) {
				head = test;
				test = p[head];
			}
			p[head] = p[head];
			System.out.print(test+";");
		}
		System.out.println(test);
	}

	public class A1Panel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3909408399774619280L;
		int[] xValue = null;
		int[] yValue = null;

		public void updateData(int[] xValue, int[] yValue) {
			this.xValue = xValue;
			this.yValue = yValue;
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if (xValue != null && yValue != null
					&& xValue.length == yValue.length && xValue.length > 1) {
				for (int i = 0; i < xValue.length - 1; i++) {
					g.drawLine(xValue[i], yValue[i], xValue[i + 1],
							yValue[i + 1]);
				}
			} else {
				g.fillOval(0, 0, this.getWidth(), this.getHeight());
			}
		}
	}

}