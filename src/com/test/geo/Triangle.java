package com.test.geo;

public class Triangle extends GeometricObject {

	private Point pointA;
	private Point pointB;
	private Point pointC;

	/**
	 * �����㹹��һ��������
	 * 
	 * @param pA
	 * @param pB
	 * @param pC
	 */
	public Triangle(Point pA, Point pB, Point pC) {
		this.pointA = pA;
		this.pointB = pB;
		this.pointC = pC;
	}

	/*
	 * ��ȡ��������������ݺ��׹�ʽ���м���
	 * 
	 * @see com.test.geo.GeometricObject#getArea()
	 */
	@Override
	public double getArea() {
		// �����������߾���
		double lengthA = pointB.distance(pointC);
		double lengthB = pointA.distance(pointC);
		double lengthC = pointA.distance(pointB);
		// ����ܳ�һ����
		double lengthP = (lengthA + lengthB + lengthC) / 2;

		// �����
		double area = Math.sqrt(lengthP * (lengthP - lengthA)
				* (lengthP - lengthB) * (lengthP - lengthC));
		return roundDouble(area);
	}

	@Override
	public String toString() {
		return "�����ε���������Ϊ:" + pointA.toString() + ";" + pointB.toString() + ";"
				+ pointC.toString() + ";";
	}

}
