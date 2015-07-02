package com.test.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Permutation {

	/**
	 * ��ʱ���<br>
	 * �Ӽ���������ѡ��ÿһ��Ԫ�أ���Ϊ���еĵ�һ��Ԫ�أ�Ȼ���ʣ���Ԫ�ؽ���ȫ���У���˵ݹ鴦��
	 * �Ӷ��õ�����Ԫ�ص�ȫ���С��Զ��ַ���abc����ȫ����Ϊ�������ǿ�����ô������abcΪ����
	 * �̶�a�������bc�����У�abc��acb����ú�a��b�������õ�bac
	 * �̶�b�������ac�����У�bac��bca����ú�c�ŵ���һλ�ã��õ�cba �̶�c�������ba�����У�cba��cab��
	 * 
	 * @param str
	 * @param first
	 * @param end
	 */
	public static void permutation(String[] str, int first, int end) {
		// ���str[first..end]���������з�ʽ
		if (first == end) { // ���һ�����з�ʽ
			// for (int j = 0; j <= end; j++) {
			// System.out.print(str[j]);
			// }
			// System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);
			permutation(str, first + 1, end); // �̶��õ�ǰһλ���������к����
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
	 * �Ӽ���������ѡ��ÿһ��Ԫ�أ���Ϊ���еĵ�һ��Ԫ�أ�Ȼ���ʣ���Ԫ�ؽ���ȫ���У���˵ݹ鴦��
	 * �Ӷ��õ�����Ԫ�ص�ȫ���С��Զ��ַ���abc����ȫ����Ϊ�������ǿ�����ô������abcΪ����
	 * �̶�a�������bc�����У�abc��acb����ú�a��b�������õ�bac
	 * �̶�b�������ac�����У�bac��bca����ú�c�ŵ���һλ�ã��õ�cba �̶�c�������ba�����У�cba��cab��
	 * 
	 * ���ݹ����� <br>
	 * 
	 * <pre>
	 * str:		 a		b		c 
	 * 		ab ac		ba bc		ca cb ����
	 * result: 		abc acb ����	 bac bca�� �� 	cab cba
	 * </pre>
	 * 
	 * @param str
	 * @param result
	 * @param len
	 */
	public static void permutation1(String str, String result, int len) {
		/*
		 * ȫ���� �ݹ�ʵ�� �ݹ����� str: a b c ab ac ba bc ca cb result: abc acb bac bca
		 * cab cba
		 */

		// ��� ��ʼ����"" ���ַ����� len ��������ĳ���
		if (result.length() == len) { // ��ʾ��������һ��ȫ���н��
			// System.out.println(result);
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (result.indexOf(str.charAt(i)) < 0) { // ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ���������
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
	 * length�����ֿ��ܵ�ȫ���������
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
		// sum = length - zeroNums; //��һ�����ֵĿ���
		//
		// } else {
		// �ܵ�������
		sum = getAllPos(length);
		// �ҵ��ظ������֣��������ظ����ֵ�ȫ����
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
	 * n�����ֵ�ȫ����
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
		permutation(str, 0, 4);// ���str[0..2]���������з�ʽ
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
