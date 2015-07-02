package com.test.audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.net.URL;

public class AudioPlay extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7480679287336867222L;

	String hurl;

	AudioClip audio;

	public void init() {
		resize(300, 100);
		if (hurl == null) {
			hurl = "./audio/BEEP1.wav";
		}
		try {
			URL url = new URL("file:" + hurl);
			audio = Applet.newAudioClip(url);
			System.out.println(audio == null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setBackground(Color.lightGray);
//		new Thread() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				audio.play();
//			}
//		}.start();
	}
	public void start()
	   {
	      if(audio != null)
	      {
	    	  System.out.println("sfsfs");
	    	  audio.loop();
	      }
	   }
}