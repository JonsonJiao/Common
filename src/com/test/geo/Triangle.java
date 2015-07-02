package com.test.geo;

public class Triangle extends GeometricObject {

	private Point pointA;
	private Point pointB;
	private Point pointC;

	/**
	 * 三个点构成一个三角形
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
	 * 获取三角形面积，根据海伦公式进行计算
	 * 
	 * @see com.test.geo.GeometricObject#getArea()
	 */
	@Override
	public double getArea() {
		// 首先求三条边距离
		double lengthA = pointB.distance(pointC);
		double lengthB = pointA.distance(pointC);
		double lengthC = pointA.distance(pointB);
		// 求出周长一半来
		double lengthP = (lengthA + lengthB + lengthC) / 2;

		// 求面积
		double area = Math.sqrt(lengthP * (lengthP - lengthA)
				* (lengthP - lengthB) * (lengthP - lengthC));
		return roundDouble(area);
	}

	@Override
	public String toString() {
		return "三角形的三个顶点为:" + pointA.toString() + ";" + pointB.toString() + ";"
				+ pointC.toString() + ";";
	}

}
