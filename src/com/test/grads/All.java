/**
 * 
 */
package com.test.grads;

import java.util.Scanner;

public class All {
	public static void main(String[] args) {
		int a[] = new int[200];
		int index = 0;
		// 将前200个数中的素数提取出来放入数组a中
		for (int i = 1; i < 200; i++) {
			boolean isPrime = true;
			for (int k = 2; k < i; k++) {
				if (i % k == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				a[index++] = i;
				System.out.println(a[index-1]); // 打印确认
			}
		}
		// 输入两个数 m，n 求第m个素数到底n个素数之间的素数和
		Scanner small = new Scanner(System.in);
		Scanner large = new Scanner(System.in);
		int m = small.nextInt();
		int n = large.nextInt();
		int sums = 0;
		int suml = 0;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			sums += a[i];
			System.out.print(a[i] + "*");
		}
		for (int i = 0; i < n; i++) {
			suml += a[i];
			System.out.print(a[i] + " ");
		}
		sum = suml - sums;
		System.out.println(sum);
	}
}
