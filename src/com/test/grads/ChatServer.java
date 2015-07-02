/**
 * 
 */
package com.test.grads;

import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String[] args) {

		/*
		 * InetAddress ServerIPaddress=null; try {
		 * ServerIPaddress=InetAddress.getLocalHost();} catch
		 * (UnknownHostException e) {} System.out.println(ServerIPaddress);
		 */

		try {
			ServerSocket ss = new ServerSocket(8800);
			while (true) {

				Socket s = ss.accept();
				System.out.println("a client is connected!"
						+ s.getInetAddress());
				/*
				 * BufferedReader re = new BufferedReader(new
				 * InputStreamReader(s.getInputStream())); String str =
				 * re.readLine(); System.out.println(str); re.close();
				 */
				/*
				 * DataInputStream dis = new
				 * DataInputStream(s.getInputStream()); String str =
				 * dis.readUTF(); System.out.println(str); dis.close();
				 */
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
