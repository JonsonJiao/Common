package com.test.trans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransDemo2 {

	public static void main(String[] args) {
		Foo foo = new Foo();
		System.out.printf("w: %d%n", Foo.w);
		System.out.printf("x: %d%n", Foo.x);
		System.out.printf("y: %d%n", foo.y);
		System.out.printf("z: %d%n", foo.z);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("x.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(foo);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		foo = null;

		try {
			FileInputStream fis = new FileInputStream("x.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println();
			foo = (Foo) ois.readObject();
			System.out.printf("w: %d%n", Foo.w);
			System.out.printf("x: %d%n", Foo.x);
			System.out.printf("y: %d%n", foo.y);
			System.out.printf("z: %d%n", foo.z);
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Foo implements Serializable {
	private static final long serialVersionUID = 6019625418736149106L;
	public transient static int w = 1111;
	public static int x = 2;
	public transient int y = 3;
	public transient int z = 4;
}
