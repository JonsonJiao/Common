package com.test.geo;

public class Circle extends GeometricObject {
	private Point center;
	private double radius;

	public Circle(Point centerPoint, double radius) {
		this.center = centerPoint;
		this.radius = radius;
	}

	/*
	 * ��ȡԲ�ε����
	 * 
	 * @see com.test.geo.GeometricObject#getArea()
	 */
	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		return roundDouble(area);
	}

	@Override
	public String toString() {
		return "Բ�ε�����Ϊ:" + center.toString() + ";�뾶Ϊ:" + radius;
	}

}
