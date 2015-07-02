package com.test.geo;

import java.text.DecimalFormat;

/**
 * 基础几何对象类
 */
public abstract class GeometricObject {
	private DecimalFormat dFormat = new DecimalFormat("#.00");

	/**
	 * 获取面积，由子类具体
	 * 
	 * @return
	 */
	public abstract double getArea();

	/**
	 * 将传入的值精确到2位小数
	 * 
	 * @param value
	 * @return
	 */
	public double roundDouble(double value) {
		return Double.valueOf(dFormat.format(value));
	}

}
