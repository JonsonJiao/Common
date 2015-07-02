package com.test.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Permutation {

	/**
	 * 耗时最短<br>
	 * 从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，
	 * 从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例：
	 * 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
	 * 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba 固定c，求后面ba的排列：cba，cab。
	 * 
	 * @param str
	 * @param first
	 * @param end
	 */
	public static void permutation(String[] str, int first, int end) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			// for (int j = 0; j <= end; j++) {
			// System.out.print(str[j]);
			// }
			// System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);
			permutation(str, first + 1, end); // 固定好当前一位，继续排列后面的
			swap(str, i, first);
		}
	}

	private static void swap(String[] str, int i, int first) {
		String tmp;
		tmp = str[first];
		str[first] = str[i];
		str[i] = tmp;
	}

	/**
	 * 从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，
	 * 从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例：
	 * 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
	 * 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba 固定c，求后面ba的排列：cba，cab。
	 * 
	 * 即递归树： <br>
	 * 
	 * <pre>
	 * str:		 a		b		c 
	 * 		ab ac		ba bc		ca cb 　　
	 * result: 		abc acb 　　	 bac bca　 　 	cab cba
	 * </pre>
	 * 
	 * @param str
	 * @param result
	 * @param len
	 */
	public static void permutation1(String str, String result, int len) {
		/*
		 * 全排列 递归实现 递归树： str: a b c ab ac ba bc ca cb result: abc acb bac bca
		 * cab cba
		 */

		// 结果 开始传入"" 空字符进入 len 是这个数的长度
		if (result.length() == len) { // 表示遍历完了一个全排列结果
			// System.out.println(result);
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (result.indexOf(str.charAt(i)) < 0) { // 返回指定字符在此字符串中第一次出现处的索引。
					permutation1(str, result + str.charAt(i), len);
				}
			}
		}
	}

	public static void permutationMine(String[] values) {
		int length = values.length;
		Map<String, Integer> numCountMap = new HashMap<String, Integer>();
		for (int i = 0; i < length; i++) {
			if (numCountMap.containsKey(values[i])) {
				numCountMap.put(values[i], numCountMap.get(values[i]) + 1);
			} else {
				numCountMap.put(values[i], 1);
			}
		}

		int sumType = getAllPosNum(length, numCountMap);
		List<String> posStrList = new ArrayList<String>();
		List<Integer> selectedIndexList = new ArrayList<Integer>();
		Random random = new Random(System.currentTimeMillis());
		int index = 0;
		while (posStrList.size() != sumType) {
			StringBuilder sb = new StringBuilder();
			sb.append("");
			while (selectedIndexList.size() != length) {
				index = random.nextInt(length);
				if (!selectedIndexList.contains(index)) {
					selectedIndexList.add(index);
					sb.append(values[index]);
				}
			}
			if (!posStrList.contains(sb.toString())) {
				posStrList.add(sb.toString());
			}
			selectedIndexList.clear();
		}
	}

	/**
	 * length个数字可能的全排列组合数
	 * 
	 * @param length
	 * @param numCountMap
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int getAllPosNum(int length, Map<String, Integer> numCountMap) {
		// TODO Auto-generated method stub
		boolean containsZero = numCountMap.containsKey(0);
		int sum = 0;
		// if (containsZero) {
		// int zeroNums = numCountMap.get(0);
		// sum = length - zeroNums; //第一个数字的可能
		//
		// } else {
		// 总的排列数
		sum = getAllPos(length);
		// 找到重复的数字，并除以重复数字的全排列
		Iterator<String> keyIt = numCountMap.keySet().iterator();
		String key;
		while (keyIt.hasNext()) {
			key = keyIt.next();
			if (numCountMap.get(key) > 1) {
				sum /= getAllPos(numCountMap.get(key));
			}
		}

		// }
		return sum;
	}

	/**
	 * n个数字的全排列
	 * 
	 * @param n
	 * @return
	 */
	private static int getAllPos(int n) {
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}

	public static void main(String args[]) throws Exception {

		String[] str = { "a", "b", "c", "d", "e", "f", "g", "h" };
		long l = System.currentTimeMillis();
		permutation(str, 0, 4);// 输出str[0..2]的所有排列方式
		System.out.println("permutation:" + (System.currentTimeMillis() - l));

		String s = "abcdefgh";
		String result = "";
		l = System.currentTimeMillis();
		permutation1(s, result, s.length());
		System.out.println("permutation1:" + (System.currentTimeMillis() - l));
		
		l = System.currentTimeMillis();
		permutationMine(str);
		System.out.println("permutation1:" + (System.currentTimeMillis() - l));
	}
}
