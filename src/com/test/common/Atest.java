package com.test.common;

class Atest extends Example1 {
	private Integer i = 1;// ��2��ʹ��Ա�������г�ʼ��

	void testAbstract() {
		System.out.println("testAbstract()" + i);
	}

	public Atest() {// ��3���������๹�췽��
		System.out.println(i);
	}
}