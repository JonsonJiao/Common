/**
 * 
 */
package com.test.geo;

/**
 * @author jiaoqishun 2015-5-26 下午3:51:48
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
		return "点(" + this.xValue + "," + this.yValue + ")";
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
	 * 以基准点为圆心，从x轴方向逆时针旋转到基准点与point点连线经过的角度，必须保证传入点与基准点不是同一个点<br>
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
	 * 求传入的点在调用点的哪个象限内，想对传入点的坐标平移到0，0标准坐标系下，然后通过平移后的坐标正负值进行判定
	 * 
	 * @param point
	 * @return 返回值1，2，3，4分别代表四个象限
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
	 * 获取斜率
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
		System.out.println(pointA.toString() + "与" + pointB.toString()
				+ "之间的夹角为：" + angle);
	}
}
