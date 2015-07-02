/**
 * 
 */
package com.test.geo;

/**
 * @author jiaoqishun 2015-5-26 ����3:51:48
 */
public class Point {

	private double xValue;
	private double yValue;

	public Point(double xValue, double yValue) {
		this.setxValue(xValue);
		this.setyValue(yValue);
	}

	public double distance(Point point) {
		double distance = Math.sqrt(Math.pow((point.getxValue() - this.xValue),
				2) + Math.pow((point.getyValue() - this.yValue), 2));
		return distance;
	}

	/**
	 * @return the xValue
	 */
	public double getxValue() {
		return xValue;
	}

	/**
	 * @param xValue
	 *            the xValue to set
	 */
	public void setxValue(double xValue) {
		this.xValue = xValue;
	}

	/**
	 * @return the yValue
	 */
	public double getyValue() {
		return yValue;
	}

	/**
	 * @param yValue
	 *            the yValue to set
	 */
	public void setyValue(double yValue) {
		this.yValue = yValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "��(" + this.xValue + "," + this.yValue + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point comparePoint = (Point) obj;
			return this.getxValue() == comparePoint.getxValue()
					&& this.getyValue() == comparePoint.getyValue();
		}
		return super.equals(obj);
	}

	/**
	 * �Ի�׼��ΪԲ�ģ���x�᷽����ʱ����ת����׼����point�����߾����ĽǶȣ����뱣֤��������׼�㲻��ͬһ����<br>
	 * 
	 * @param point
	 * @return
	 */
	public double getAngle(Point point) {
		if (this.getxValue() == point.getxValue()) {
			if (this.getyValue() < point.getyValue()) {
				return 90;
			} else {
				return 270;
			}
		} else if (this.getyValue() == point.getyValue()) {
			if (this.getxValue() < point.getxValue()) {
				return 0;
			} else {
				return 180;
			}
		} else {
			double kValue = (getKValue(point));
			int quadrant = getQuadrant(point);
			double angle = Math.atan(kValue) * 180 / Math.PI;
			if (quadrant != 1) {
				if (quadrant == 2 || quadrant == 3) {
					return angle + 180;
				} else {
					return angle + 360;
				}
			}
			return angle;
		}
	}

	/**
	 * ����ĵ��ڵ��õ���ĸ������ڣ���Դ���������ƽ�Ƶ�0��0��׼����ϵ�£�Ȼ��ͨ��ƽ�ƺ����������ֵ�����ж�
	 * 
	 * @param point
	 * @return ����ֵ1��2��3��4�ֱ�����ĸ�����
	 */
	private int getQuadrant(Point point) {
		double transPointX = point.getxValue() - this.getxValue();
		double transPointY = point.getyValue() - this.getyValue();
		if (transPointX > 0 && transPointY > 0) {
			return 1;
		} else if (transPointX < 0 && transPointY > 0) {
			return 2;
		} else if (transPointX < 0 && transPointY < 0) {
			return 3;
		} else {
			return 4;
		}
	}

	/**
	 * ��ȡб��
	 * 
	 * @param point
	 * @return
	 */
	private double getKValue(Point point) {
		double kValue = (point.getyValue() - this.getyValue()) * 1.0d
				/ (point.getxValue() - this.getxValue());
		return kValue;
	}

	public static void main(String[] args) {
		Point pointA = new Point(0, 0);
		Point pointB = new Point(0, -1);
		double angle = pointA.getAngle(pointB);
		System.out.println(pointA.toString() + "��" + pointB.toString()
				+ "֮��ļн�Ϊ��" + angle);
	}
}
