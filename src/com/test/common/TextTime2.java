package com.test.common;
import java.applet.Applet;
import java.awt.TextField;
import java.util.Date;


/**
 * 
 @author Administrator
 */
public class TextTime2 extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5493470314087388920L;
	Thread th = null;
	TextField tt = new TextField(30);

	public void init() {
		add(tt);
	}

	public void start() {
		if (th == null) {
			th = new Thread(this);
			th.start();
		}
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		if (th != null) {
			th.stop();
			th = null;
		}
	}

	@SuppressWarnings("deprecation")
	public void run() {
		while (true) {
			Date dd = new Date();
			tt.setText(dd.toGMTString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) { // TODO code application logic here
		TextTime2 textTime = new TextTime2();
		textTime.start();
	}
}