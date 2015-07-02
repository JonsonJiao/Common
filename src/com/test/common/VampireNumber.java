package com.test.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class VampireNumber {

	private int sonNum1;

	public int getSonNum1() {
		return sonNum1;
	}

	public void setSonNum1(int sonNum1) {
		this.sonNum1 = sonNum1;
	}

	public int getSonNum2() {
		return sonNum2;
	}

	public void setSonNum2(int sonNum2) {
		this.sonNum2 = sonNum2;
	}

	private int sonNum2;

	private boolean isVampireNumber = false;

	private int value;

	public VampireNumber(int value) {
		this.value = value;
		initSonNum();
	}

	/**
	 * 获取组成吸血鬼数字的两个数字 策略是先找到最后一位的数字，因为末尾数字的乘积必须等于value的最后一位，因此先根据x*y%10=最后一位来找
	 */
	private void initSonNum() {
		// 以00结尾的不是
		if (value % 100 == 0) {
			setVampireNumber(false);
			return;
		}
		// 首先将数字分成n个int值，n代表value的数字长度
		String string = value + "";
		int length = string.length();
		if (length % 2 != 0) {
			// 非偶数位数一定不是
			setVampireNumber(false);
			return;
		}
		Integer[] rawNum = new Integer[length];
		for (int i = 0; i < rawNum.length; i++) {
			rawNum[i] = Integer.parseInt(string.charAt(i) + "");
		}

		boolean lastZero = rawNum[length - 1] == 0;
		int last = lastZero ? rawNum[length - 2] : rawNum[length - 1];
		List<Integer> oneLastList = new ArrayList<Integer>();
		List<Integer> otherLastList = new ArrayList<Integer>();
		// for (int i = 0; i < (lastZero ? rawNum.length - 2 : rawNum.length -
		// 1); i++) {
		// if (oneLast * rawNum[i] % 10 == oneLast) {
		// otherLast = rawNum[i];
		// break;
		// }
		// }
		// 需要再检查一下任意两位相乘的情况
		for (int i = 0; i < rawNum.length; i++) {
			for (int j = i + 1; j < rawNum.length; j++) {
				if (rawNum[i] * rawNum[j] % 10 == last) {
					oneLastList.add(rawNum[i]);
					otherLastList.add(rawNum[j]);
				}
			}
		}
		if (otherLastList.size() == 0) {
			// 找不到两个数相乘取模10等于最后一位的
			setVampireNumber(false);
			return;
		}
		// findNums();
		int size = oneLastList.size();
		if (lastZero) {
			for (int i = 0; i < size; i++) {
				otherLastList.add(oneLastList.get(i));
				oneLastList.add(otherLastList.get(i));
			}
		}
		int count = 0;
		int oneLast = 0;
		int otherLast = 0;
		int half = length / 2;
		// List<Integer[]> posNumList = printValues(rawNum);
		List<Object[]> posNumList = new ArrayList<Object[]>();
		permutation(rawNum, 0, length - 1, posNumList);
		while (count < oneLastList.size() && !isVampireNumber) {
			if (lastZero) {
				oneLast = 0;
			} else {
				oneLast = oneLastList.get(count);
			}
			otherLast = otherLastList.get(count);

			int two = 0;
			int one = 0;
			for (int m = 0; m < posNumList.size(); m++) {
				Integer[] list = (Integer[]) posNumList.get(m);
				two = 0;
				one = 0;
				// 将数组分为两半，每一半的末位为oneLast或otherLast时继续进行判断，否则continue
				if (list[length - 1] == oneLast && list[half - 1] == otherLast) {
					two += oneLast;
					for (int i = half; i < length - 1; i++) {
						int tmp = 1;
						for (int j = 0; j < length - 1 - i; j++) {
							tmp *= 10;
						}
						two += list[i] * tmp;
					}
					one += otherLast;
					for (int i = 0; i < half - 1; i++) {
						int tmp = 1;
						for (int j = 0; j < half - 1 - i; j++) {
							tmp *= 10;
						}
						one += list[i] * tmp;
					}
				} else if (list[length - 1] == otherLast
						&& list[half - 1] == oneLast) {
					two += otherLast;
					for (int i = half; i < length - 1; i++) {
						int tmp = 1;
						for (int j = 0; j < length - 1 - i; j++) {
							tmp *= 10;
						}
						two += list[i] * tmp;
					}
					one += oneLast;
					for (int i = 0; i < half - 1; i++) {
						int tmp = 1;
						for (int j = 0; j < half - 1 - i; j++) {
							tmp *= 10;
						}
						one += list[i] * tmp;
					}
				}
				if (two * one == value) {
					isVampireNumber = true;
					sonNum1 = one;
					sonNum2 = two;
					break;
				}
			}
			count++;
		}
		// two = 0;
		// one = 0;
		// List<Integer> selectedIndex = new ArrayList<Integer>();
		// for (int i = 0; i < rawNum.length; i++) {
		// if (rawNum[i] == oneLast || rawNum[i] == otherLast) {
		// selectedIndex.add(i);
		// }
		// }
		//
		// for (int i = 0; i < rawNum.length; i++) {
		// if (!selectedIndex.contains(i)) {
		// one = rawNum[i] * 10 + oneLast;
		// for (int j = 0; j < rawNum.length; j++) {
		// if (j != i && !selectedIndex.contains(j)) {
		// two = rawNum[j] * 10 + otherLast;
		// }
		// }
		// if (one * two == value) {
		// isVampireNumber = true;
		// sonNum1 = one;
		// sonNum2 = two;
		// break;
		// }
		// }
		// }
	}

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
	public void permutation(Object[] str, int first, int end,
			List<Object[]> posNumList) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			Object[] result = Arrays.copyOf(str, str.length);
			posNumList.add(result);
			// for (int j = 0; j <= end; j++) {
			// System.out.print(str[j]);
			// }
			// System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);
			permutation(str, first + 1, end, posNumList); // 固定好当前一位，继续排列后面的
			swap(str, i, first);
		}
	}

	private void swap(Object[] str, int i, int first) {
		if (str instanceof Integer[]) {
			Integer tmp;
			tmp = (Integer) str[first];
			str[first] = str[i];
			str[i] = tmp;
		} else if (str instanceof String[]) {
			String tmp;
			tmp = (String) str[first];
			str[first] = str[i];
			str[i] = tmp;
		}
	}

	@SuppressWarnings("unused")
	private void findNums() {
		String string = value + "";
		int length = string.length();
		int half = length / 2;
		int min = 1;
		int max = 1;
		for (int i = 0; i < half - 1; i++) {
			min *= 10;
		}
		max = min * 10 - max;

		String[] tmp = null;
		String[] result = String.valueOf(value).split("");
		Arrays.sort(result);

		// 采用两个循环来一个一个的试
		for (int i = min; i < max; i++) {
			if (isVampireNumber) {
				break;
			}
			for (int j = i + 1; j < max; j++) {
				if (i * j != value) {
					continue;
				} else {
					tmp = (String.valueOf(i) + String.valueOf(j)).split("");
					Arrays.sort(tmp);
					if (Arrays.equals(result, tmp)) {
						isVampireNumber = true;
						sonNum1 = i;
						sonNum2 = j;
						break;
					}
				}
			}
		}
	}

	public int[] getSonNum() {
		return new int[] { sonNum1, sonNum2 };
	}

	public static void main(String[] args) {
		// int value = 1435;
		VampireNumber vn = null;
		int count =0;
		long l = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			vn = new VampireNumber(i);
			if (vn.isVampireNumber()) {
				System.out.println(i + "=" + vn.getSonNum1() + "*"
						+ vn.getSonNum2());
				count++;
			}
		}
		System.out.println((System.currentTimeMillis() - l)+"共计："+count);
	}

	/**
	 * 输出n个数字的全排列可能
	 * 
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<Integer[]> printValues(int[] values) {
		// TODO Auto-generated method stub

		int length = values.length;
		Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < values.length; i++) {
			if (numCountMap.containsKey(values[i])) {
				numCountMap.put(values[i], numCountMap.get(values[i]) + 1);
			} else {
				numCountMap.put(values[i], 1);
			}
		}

		int sumType = getAllPosNum(length, numCountMap);
		List<Integer[]> posNumList = new ArrayList<Integer[]>();
		List<String> posStrList = new ArrayList<String>();
		List<Integer> selectedIndexList = new ArrayList<Integer>();
		Random random = new Random(System.currentTimeMillis());
		int index = 0;
		while (posNumList.size() != sumType) {
			Integer[] pos = new Integer[length];
			StringBuilder sb = new StringBuilder();
			sb.append("");
			while (selectedIndexList.size() != length) {
				index = random.nextInt(length);
				if (!selectedIndexList.contains(index)) {
					selectedIndexList.add(index);
					sb.append(values[index]);
					pos[selectedIndexList.size() - 1] = values[index];
				}
			}
			if (!posStrList.contains(sb.toString())) {
				posStrList.add(sb.toString());
				posNumList.add(pos);
			}
			selectedIndexList.clear();
		}
		return posNumList;
	}

	/**
	 * length个数字可能的全排列组合数
	 * 
	 * @param length
	 * @param numCountMap
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int getAllPosNum(int length,
			Map<Integer, Integer> numCountMap) {
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
		Iterator<Integer> keyIt = numCountMap.keySet().iterator();
		int key = 0;
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

	public boolean isVampireNumber() {
		return isVampireNumber;
	}

	public void setVampireNumber(boolean isVampireNumber) {
		this.isVampireNumber = isVampireNumber;
	}
}
