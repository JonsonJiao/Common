package com.test.common;

import java.util.Arrays;
import java.util.Random;

public class SortDemo {

	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		char[] srcChars = getChars(70);
		System.out.print("����ǰ��");
		System.out.println(srcChars);
		// ����
		Arrays.sort(srcChars);
		System.out.print("�����");
		System.out.println(srcChars);
		System.out.println("��ʱ��" + (System.currentTimeMillis() - l) + "����");
	}

	/**
	 * �����ȡһ������Ϊnum���ַ�����ֻ�������ֻ���ĸ
	 * 
	 * @param num
	 * @return
	 */
	private static char[] getChars(int num) {
		char[] result = new char[num];
		int index = 0;
		Random random = new Random();
		for (int i = 0; i < result.length; i++) {
			index = random.nextInt(62);
			result[i] = getChar(index);
		}
		return result;
	}

	/**
	 * �������ֵindex��ȡ��Ӧ����ĸ<br>
	 * 0-9��Ӧ����0-9(asciiֵΪ48-57)<br>
	 * 10-35��Ӧ��д��ĸA-Z(asciiֵΪ65-90)<br>
	 * 36-61��ӦСд��ĸa-z(asciiֵΪ97-122)<br>
	 * 
	 * @param index
	 * @return
	 */
	private static char getChar(int index) {
		if (index >= 0 && index <= 9) {
			index += 48;
		} else if (index >= 10 && index <= 35) {
			index += 55;
		} else {
			index += 61;
		}
		return (char) index;
	}
}
