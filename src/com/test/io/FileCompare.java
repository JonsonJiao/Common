package com.test.io;

import java.io.File;

public class FileCompare {

	public static void main(String[] args) {
		File file1 = new File("E:abcde");
		File file2 = new File("E:abcde111fg");
		System.out.println(file1.compareTo(file2));
	}
}
