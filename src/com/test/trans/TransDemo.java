package com.test.trans;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ClassLib implements Serializable {
	private static final long serialVersionUID = 6046583586672352106L;

	private transient InputStream is; // 因为InputStream没有实现Serializable接口，不声明为transient反序列化时，则会抛出java.io.NotSerializableException

	private int majorVer;
	private int minorVer;

	ClassLib(InputStream is) throws IOException {
		System.out.println("ClassLib(InputStream) called");
		this.is = is;
		DataInputStream dis;
		if (is instanceof DataInputStream)
			dis = (DataInputStream) is;
		else
			dis = new DataInputStream(is);
		if (dis.readInt() != 0xcafebabe)
			throw new IOException("not a .class file");
		minorVer = dis.readShort();
		majorVer = dis.readShort();
	}

	int getMajorVer() {
		return majorVer;
	}

	int getMinorVer() {
		return minorVer;
	}

	void showIS() {
		System.out.println(is);
	}
}

public class TransDemo {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("usage: java TransDemo classfile");
			return;
		}
		ClassLib cl = new ClassLib(new FileInputStream(args[0]));
		System.out.printf("Minor version number: %d%n", cl.getMinorVer());
		System.out.printf("Major version number: %d%n", cl.getMajorVer());
		cl.showIS();

		FileOutputStream fos = new FileOutputStream("x.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(cl);

		cl = null;

		FileInputStream fis = new FileInputStream("x.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println();
		try {
			cl = (ClassLib) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Minor version number: %d%n", cl.getMinorVer());
		System.out.printf("Major version number: %d%n", cl.getMajorVer());
		// 反序列化的is是空的
		cl.showIS();
	}
}
