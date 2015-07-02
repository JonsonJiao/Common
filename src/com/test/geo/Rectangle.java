package com.test.geo;

public class Rectangle extends GeometricObject {
	private Point pointLU; // ����
	private Point pointRU; // ����
	private Point pointLD; // ����
	private Point pointRD; // ����

	public Rectangle(Point pLU, Point pRU, Point pLD, Point pRD) {
		this.pointLU = pLU;
		this.pointRU = pRU;
		this.pointLD = pLD;
		this.pointRD = pRD;
	}

	/*
	 * ��ȡ���ε����
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
		return "���ε��ĸ�����Ϊ:" + pointLU.toString() + ";" + pointRU.toString()
				+ ";" + pointLD.toString() + ";" + pointRD.toString() + ";";
	}

}
