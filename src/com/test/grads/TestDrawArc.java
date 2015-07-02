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
		super("��Բ");
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
		int[] params = new int[3]; // Բ���̵��������������ĵ㣨a,b���Ͱ뾶r�ֱ��Ӧ���±�Ϊ0��1��2
		// �����ԭ�������㲻��һ��ֱ�������������㲻�غϣ���Щ����������Ϲ涨������ֵ�ж���0
		if (startPoint.equals(endPoint) || startPoint.equals(midPoint)
				|| endPoint.equals(midPoint)) {
			return params;
		} else if (checkInLine(startPoint, endPoint, midPoint)) {
			// ����Ƿ���һ��ֱ����
			return params;
		} else {
			return circleParams(startPoint, endPoint, midPoint);
		}
	}

	/**
	 * �����ԭ���ǣ������е����ߵ��д������յ����е����ߵ��д����ཻ�㼴ΪԲ�ġ�
	 * 
	 * @param startPoint
	 * @param endPoint
	 * @param midPoint
	 * @return
	 */
	@SuppressWarnings("unused")
	private int[] circleParams(Point startPoint, Point endPoint, Point midPoint) {
		// ������������е����ߵ�б��
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
			// ��ʱstartPoint��endPoint��xֵ����ͬ��ͬʱstartPoint��midPoint��xֵ����ͬ���������ܼ���б��
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
