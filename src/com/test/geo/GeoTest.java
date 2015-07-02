package com.test.geo;

public class GeoTest {

	public static void main(String[] args) {
		GeometricObject[] gobj = new GeometricObject[3];
		gobj[0] = new Triangle(new Point(1.0, 2.0), new Point(1.0, 1.0),
				new Point(0.0, 2.0));
		gobj[1] = new Circle(new Point(1.0, 2.0), 3);
		gobj[2] = new Rectangle(new Point(1.0, 2.0), new Point(1.0, 5.0),
				new Point(1.0, 0.0), new Point(5.0, 0.0));
		double sumArea = 0;
		for (int i = 0; i < gobj.length; i++) {
			if (gobj[i] != null) {
				double area = gobj[i].getArea();
				System.out.println(gobj[i].toString() + "其面积为:" + area);
				sumArea += area;
			}
		}
		System.out.println("总面积为：" + sumArea);
	}
}
