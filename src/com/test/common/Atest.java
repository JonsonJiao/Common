package com.test.common;

class Atest extends Example1 {
	private Integer i = 1;// （2）使成员变量进行初始化

	void testAbstract() {
		System.out.println("testAbstract()" + i);
	}

	public Atest() {// （3）调用子类构造方法
		System.out.println(i);
	}
}