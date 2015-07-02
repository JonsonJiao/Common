package com.test.frame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BackPicture extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8171339800988336113L;

	public BackPicture() {
		this.setOpaque(true);
		add(new JButton("DJkdslals"));
		add(new JTextField(10));
		add(new JLabel("00000000"));
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		BufferedImage img;
		try {
			File input = new File("photos/rabita.jpg");
			if(input.exists()){
				img = ImageIO.read(input);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frm = new JFrame();
				BackPicture bpanel = new BackPicture();
				frm.getContentPane().add(bpanel);
				frm.setSize(400, 400);
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm.setLocationRelativeTo(null);
				frm.setVisible(true);
			}
		});
	}
}
