package com.test.geo;

public class Rectangle extends GeometricObject {
	private Point pointLU; // 左上
	private Point pointRU; // 右上
	private Point pointLD; // 左下
	private Point pointRD; // 右下

	public Rectangle(Point pLU, Point pRU, Point pLD, Point pRD) {
		this.pointLU = pLU;
		this.pointRU = pRU;
		this.pointLD = pLD;
		this.pointRD = pRD;
	}

	/*
	 * 获取矩形的面积
	 * 
	 * @see com.test.geo.GeometricObject#getArea()
	 */
	@Override
	public double getArea() {
		double lengthW = pointLU.distance(pointRU);
		double lengthH = pointLU.distance(pointLD);
		return roundDouble(lengthH * lengthW);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "矩形的四个顶点为:" + pointLU.toString() + ";" + pointRU.toString()
				+ ";" + pointLD.toString() + ";" + pointRD.toString() + ";";
	}

}
