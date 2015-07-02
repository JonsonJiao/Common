package com.test.audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class exam extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4001476803533556526L;
	private Image img = null;
	private Image img2 = null;
	private Image img3 = null;
	int x = 500;
	int y = 400;

	String hurl;

	AudioClip audio;

	public static void main(String[] args) {
		new exam();
		// File file = new File("./photos/rabit.jpg");
		// System.out.println(file.exists());
	}

	public exam() {
		this.setSize(1366, 768);
		this.setLocation(100, 100);

		img = Toolkit.getDefaultToolkit().createImage("./photos/rabit.jpg");
		img3 = Toolkit.getDefaultToolkit().createImage("./photos/rabit.jpg");
		img2 = Toolkit.getDefaultToolkit().createImage("./photos/rabit.jpg");

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					x = x + 5;
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					x = x - 5;
				else if (e.getKeyCode() == KeyEvent.VK_UP)
					y = y - 5;
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					y = y + 5;
				repaint();
			}
		});
		if (hurl == null) {
			hurl = "./audio/BEEP1.wav";
		}
		try {
			URL url = new URL("file:" + hurl);
			audio = Applet.newAudioClip(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				audio.play();
			}
		}.start();
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawImage(img2, 100, 400, 200, 200, this);
		g.drawImage(img3, x, y, 200, 200, this);
		g.drawImage(img, 1200, 400, 100, 200, this);
	}
}