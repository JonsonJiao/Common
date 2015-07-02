package com.test.geo;

public class Circle extends GeometricObject {
	private Point center;
	private double radius;

	public Circle(Point centerPoint, double radius) {
		this.center = centerPoint;
		this.radius = radius;
	}

	/*
	 * 获取圆形的面积
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
		return "圆形的中心为:" + center.toString() + ";半径为:" + radius;
	}

}
