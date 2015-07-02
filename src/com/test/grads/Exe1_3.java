package com.test.grads;

public class Exe1_3 {

	public static void main(String[] args) {
		String s = "java";
		String m = "";
		for (int i = 0; i < s.length(); i++) {
			char c = (char)(s.charAt(i)+2);
			char d = (char)(c^s.charAt(i));
			m = m+d;
			System.out.println(c);
		}
		System.out.println(m);
	}
}
