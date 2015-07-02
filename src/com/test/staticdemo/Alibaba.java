package com.test.staticdemo;

public class Alibaba {
	public static int k = 0;
	public static Alibaba t1 = new Alibaba("t1");
	public static Alibaba t2 = new Alibaba("t2");
	public static int i = print("i");
	public static int n = 99;
	@SuppressWarnings("unused")
	private int a = 0;
	public int j = print("j");
	{
		print("¹¹Ôì¿é");
	}
	static {
		print("¾²Ì¬¿é");
	}

	public Alibaba(String str) {
		System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
		++i;
		++n;
	}

	public static int print(String str) {
		System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
		++n;
		return ++i;
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		Alibaba t = new Alibaba("init");
	}
}