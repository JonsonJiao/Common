/**
 * 
 */
package com.test.grads;

import java.io.FileWriter;

public class TestFileWriter {
	public static void showFile(java.io.File file) {
		char buff[] = new char[22];
		int ret = 0;

		System.out.println("Showfile begin[" + file.getName() + "]:");

		java.io.FileReader read_file = null;

		try {
			// 创建读取文件对象
			read_file = new java.io.FileReader(file);

			do {
				// 读取一段字符，每次22个字符
				ret = read_file.read(buff);

				for (int i = 0; i < ret; i++) {
					System.out.print(buff[i]); // 逐个输出读入的字符
				}
			} while (ret != -1);
		} catch (java.lang.Exception e) {
			System.out.println("There must be something wrong!");
		} finally {
			// 关闭打开的文件
			try {
				read_file.close();
			} catch (java.lang.Exception e) {
				System.out.println("Ignore the exception when closing.");
			}
		}

		System.out.println("\nshowfile end [" + file.getName() + "].");
	}

	public static void main(String[] argv) {
		char buff[] = new char[48];
		char ch = 'A';

		for (int i = 0; i < 26; i++) {
			buff[i] = ch++; // 输入A-Z共26个字母到字符数组buff
		}

		java.io.File _write = new java.io.File("_write.txt");
		java.io.FileWriter write_java = null;

		try {
			System.out.println(_write.getName() + "exist?" + _write.exists());

			write_java = new java.io.FileWriter("_write.txt"); // 创建写入文本的对象

			System.out.println(_write.getName() + "exist?" + _write.exists());

			write_java.write(buff, 0, 26); // 将buff数组里的内容输出到指定文件

			System.out.println(_write.getName() + "exist?" + _write.exists());

			// write_java.flush();

			write_java.close(); // 调用close（）会自动执行flush（），如果将这一行放在show_file（）方法后面，则show_file()显示文件为空，因为未写入

			System.out.println("\nWrite into an empty file.");

			showFile(_write); // 调用show_file()方法
		} catch (java.lang.Exception e) {
			System.out.println("There must be something wrong!");
		} finally {
			try {
				write_java.close();
			} catch (java.lang.Exception e) {
				System.out.println("Ignore the exception when closing.");
			}

		}

		FileWriter append_java = null;
		try {
			// 使用append（）方法向文件追加内容
			append_java = new java.io.FileWriter(_write); // 以普通形式打开，结果依然覆盖原文
			append_java.append("Someting appended in the file....");
			append_java.close();

			System.out.println("\n以普通方式打开，调用append()方法");
			showFile(_write);
		} catch (java.lang.Exception e) {
			System.out.println("There must be something wrong!");
		} finally {
			try {
				append_java.close();
			} catch (java.lang.Exception e) {
				System.out.println("Ignore the exception when closing.");
			}
		}

		try {
			// 以追加方式打开文件，并使用append（）方法向文件追加内容

			append_java = new java.io.FileWriter(_write, true);
			append_java.write(buff, 0, 26);
			append_java.close();

			System.out.println("\n以追加模式打开文件，用append（）方法追加内容到文件中");
			showFile(_write);
		} catch (java.lang.Exception e) {
			System.out.println("There must be something wrong!");
		} finally {
			try {
				append_java.close();
			} catch (java.lang.Exception e) {
				System.out.println("Ignore the exception when closing.");
			}
		}

		try {
			// 以非追加方式打开，并用append（）方法向文件追加内容
			append_java = new java.io.FileWriter(_write, false);
			append_java.append(new String(buff).trim());
			append_java.close();
			System.out.println("\n以非追加方式打开，调用append（）方法");
			showFile(_write);
		} catch (java.lang.Exception e) {
			System.out.println("There must be something wrong!");
		} finally {
			try {
				append_java.close();
			} catch (java.lang.Exception e) {
				System.out.println("Ignore the exception when closing.");
			}
		}

		_write.delete();
	}
}
