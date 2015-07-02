package com.test.common;

import java.util.Arrays;
import java.util.Random;

public class SortDemo {

	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		char[] srcChars = getChars(70);
		System.out.print("排序前：");
		System.out.println(srcChars);
		// 排序
		Arrays.sort(srcChars);
		System.out.print("排序后：");
		System.out.println(srcChars);
		System.out.println("耗时：" + (System.currentTimeMillis() - l) + "毫秒");
	}

	/**
	 * 随机获取一个长度为num的字符串，只能是数字或字母
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
	 * 根据随机值index获取对应的字母<br>
	 * 0-9对应数字0-9(ascii值为48-57)<br>
	 * 10-35对应大写字母A-Z(ascii值为65-90)<br>
	 * 36-61对应小写字母a-z(ascii值为97-122)<br>
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
