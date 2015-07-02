package com.test.common;

public abstract class Example1 {
	abstract void testAbstract();

	Example1() {// （1）首先执行父类构造方法
		System.out.println("before testAbstract()");
		testAbstract();// 如果调用了抽象方法，调用子类覆盖的方法。这里调用Atest类的testAbstract（）方法
		System.out.println("after testAbstarcat()");
	}

	public static void main(String args[]) {
		new Atest();
	}
}
