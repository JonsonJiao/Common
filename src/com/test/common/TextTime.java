package com.test.common;

import java.applet.*;
import java.util.*;
import java.awt.*;

/**
 * 
 @author Administrator
 */
public class TextTime extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) { // TODO code application logic here
		TextTime textTime = new TextTime();
		textTime.start();

	}
}