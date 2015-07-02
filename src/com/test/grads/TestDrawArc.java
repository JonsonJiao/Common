/**
 * 
 */
package com.test.grads;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.test.geo.Point;

public class TestDrawArc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3196215829188355691L;
	MyCanvas1 cnv;

	public TestDrawArc() {
		super("半圆");
		cnv = new MyCanvas1();
		this.add(cnv);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestDrawArc();
	}

	@SuppressWarnings("unused")
	private int[] getCircleParams(Point startPoint, Point endPoint,
			Point midPoint) {
		int[] params = new int[3]; // 圆方程的三个参数，中心点（a,b）和半径r分别对应的下标为0，1，2
		// 计算的原理是三点不在一条直线上且任意两点不重合，这些情况都不符合规定，返回值中都是0
		if (startPoint.equals(endPoint) || startPoint.equals(midPoint)
				|| endPoint.equals(midPoint)) {
			return params;
		} else if (checkInLine(startPoint, endPoint, midPoint)) {
			// 检查是否在一条直线上
			return params;
		} else {
			return circleParams(startPoint, endPoint, midPoint);
		}
	}

	/**
	 * 计算的原理是，起点和中点连线的中垂线与终点与中点连线的中垂线相交点即为圆心。
	 * 
	 * @param startPoint
	 * @param endPoint
	 * @param midPoint
	 * @return
	 */
	@SuppressWarnings("unused")
	private int[] circleParams(Point startPoint, Point endPoint, Point midPoint) {
		// 首先求起点与中点连线的斜率
		if (startPoint.getxValue() == midPoint.getxValue()) {
			double smyValue = (startPoint.getyValue() + midPoint.getyValue()) * 1.0f / 2;
		} else {

		}

		return null;
	}

	/**
	 * @param startPoint
	 * @param endPoint
	 * @param midPoint
	 * @return
	 */
	private boolean checkInLine(Point startPoint, Point endPoint, Point midPoint) {
		if (startPoint.getxValue() == endPoint.getxValue()
				&& startPoint.getxValue() != midPoint.getxValue()) {
			return false;
		} else if (startPoint.getxValue() != endPoint.getxValue()
				&& startPoint.getxValue() == midPoint.getxValue()) {
			return false;
		} else {
			// 此时startPoint和endPoint的x值不相同，同时startPoint和midPoint的x值不相同，这样才能计算斜率
			double kValue1 = (startPoint.getyValue() - endPoint.getyValue())
					* 1.0d / (startPoint.getxValue() - endPoint.getxValue());
			double kValue2 = (startPoint.getyValue() - midPoint.getyValue())
					* 1.0d / (startPoint.getxValue() - midPoint.getxValue());
			if (kValue1 - kValue2 < 0.00001) {
				return true;
			}
		}
		return false;
	}
}

class MyCanvas1 extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6995962565214441176L;

	public MyCanvas1() {
		super();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillArc(0, 0, 300, 300, 0, 30);
		g.drawArc(50, 50, 300, 300, 0, 360);
		g.drawRect(50, 50, 300, 300);
	}
}
