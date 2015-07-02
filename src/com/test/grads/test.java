/**
 * 
 */
package com.test.grads;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class test {

	public static void main(String[] args) {

		File file = new File("photos/rabit.png");
		BufferedImage src = null;
		try {
			src = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		int minX = src.getMinX();
		int minY = src.getMinY();
		short[] rgb = new short[3];
		short[] grayImage = new short[width * height];
		for (int i = minX; i < height; i++) {
			for (int j = minY; j < width; j++) {
				int pixel = src.getRGB(j, i);
				rgb[0] = (short) ((pixel & 0xff0000) >> 16);
				rgb[1] = (short) ((pixel & 0xff00) >> 8);
				rgb[2] = (short) (pixel & 0xff);
				grayImage[i * width + j] = (short) (rgb[0] * 0.299 + rgb[1]
						* 0.587 + rgb[2] * 0.114);
			}
		}
		int[] data1 = new int[grayImage.length];
		for (int i = 0; i < data1.length; i++) {
			data1[i] =  new Color(grayImage[i],grayImage[i],grayImage[i]).getRGB();
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		image.setRGB(minX, minY, width, height, data1, 0, width);
		String path = "D:\\test.png";
		try {
			ImageIO.write(image, "png", new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
