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
			// ������ȡ�ļ�����
			read_file = new java.io.FileReader(file);

			do {
				// ��ȡһ���ַ���ÿ��22���ַ�
				ret = read_file.read(buff);

				for (int i = 0; i < ret; i++) {
					System.out.print(buff[i]); // ������������ַ�
				}
			} while (ret != -1);
		} catch (java.lang.Exception e) {
			System.out.println("There must be something wrong!");
		} finally {
			// �رմ򿪵��ļ�
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
			buff[i] = ch++; // ����A-Z��26����ĸ���ַ�����buff
		}

		java.io.File _write = new java.io.File("_write.txt");
		java.io.FileWriter write_java = null;

		try {
			System.out.println(_write.getName() + "exist?" + _write.exists());

			write_java = new java.io.FileWriter("_write.txt"); // ����д���ı��Ķ���

			System.out.println(_write.getName() + "exist?" + _write.exists());

			write_java.write(buff, 0, 26); // ��buff����������������ָ���ļ�

			System.out.println(_write.getName() + "exist?" + _write.exists());

			// write_java.flush();

			write_java.close(); // ����close�������Զ�ִ��flush�������������һ�з���show_file�����������棬��show_file()��ʾ�ļ�Ϊ�գ���Ϊδд��

			System.out.println("\nWrite into an empty file.");

			showFile(_write); // ����show_file()����
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
			// ʹ��append�����������ļ�׷������
			append_java = new java.io.FileWriter(_write); // ����ͨ��ʽ�򿪣������Ȼ����ԭ��
			append_java.append("Someting appended in the file....");
			append_java.close();

			System.out.println("\n����ͨ��ʽ�򿪣�����append()����");
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
			// ��׷�ӷ�ʽ���ļ�����ʹ��append�����������ļ�׷������

			append_java = new java.io.FileWriter(_write, true);
			append_java.write(buff, 0, 26);
			append_java.close();

			System.out.println("\n��׷��ģʽ���ļ�����append��������׷�����ݵ��ļ���");
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
			// �Է�׷�ӷ�ʽ�򿪣�����append�����������ļ�׷������
			append_java = new java.io.FileWriter(_write, false);
			append_java.append(new String(buff).trim());
			append_java.close();
			System.out.println("\n�Է�׷�ӷ�ʽ�򿪣�����append��������");
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
