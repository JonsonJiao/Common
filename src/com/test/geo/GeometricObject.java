package com.test.geo;

import java.text.DecimalFormat;

/**
 * �������ζ�����
 */
public abstract class GeometricObject {
	private DecimalFormat dFormat = new DecimalFormat("#.00");

	/**
	 * ��ȡ��������������
	 * 
	 * @return
	 */
	public abstract double getArea();

	/**
	 * �������ֵ��ȷ��2λС��
	 * 
	 * @param value
	 * @return
	 */
	public double roundDouble(double value) {
		return Double.valueOf(dFormat.format(value));
	}

}
