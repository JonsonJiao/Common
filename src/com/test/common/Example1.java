package com.test.common;

public abstract class Example1 {
	abstract void testAbstract();

	Example1() {// ��1������ִ�и��๹�췽��
		System.out.println("before testAbstract()");
		testAbstract();// ��������˳��󷽷����������า�ǵķ������������Atest���testAbstract��������
		System.out.println("after testAbstarcat()");
	}

	public static void main(String args[]) {
		new Atest();
	}
}
