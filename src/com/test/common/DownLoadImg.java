package com.test.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

class DownLoadImg {
	static int value = 1;

	public static void downLoadImg(String imgName, String imgUrl, String fileURL)
			throws Exception {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			// 创建流
			System.out.println("imgUrl:" + imgUrl);
			in = new BufferedInputStream(new URL(imgUrl).openStream());
			// 生成图片名
			int index = imgUrl.lastIndexOf("/");
			String sName = imgName == null ? imgUrl.substring(index + 1,
					imgUrl.length()) : imgName;
			File fir = new File(fileURL);
			if (!fir.exists()) {
				fir.mkdirs();
			}
			// 存放地址
			File img = new File(fileURL + sName);
			// 生成图片
			out = new BufferedOutputStream(new FileOutputStream(img));
			byte[] buf = new byte[2048];
			int length = in.read(buf);
			while (length != -1) {
				System.out.println(Thread.currentThread().getName());
				out.write(buf, 0, length);
				length = in.read(buf);// 在一个下载图片的线程有的时候读取到这里就不动了 ，这种问题应该怎么解决
			}
		} catch (Exception e) {
			System.out.println("下载图片异常");
			e.printStackTrace();
			throw new RuntimeException("下载图片异常");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final String fileURL = "D:\\";
		final String imgUrl = "http://img.gewara.cn/userfiles/image/201203/s_38b8a98e_1363f703f73__7744.jpg";
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					downLoadImg(null, imgUrl, fileURL);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				try {
					downLoadImg(null, imgUrl, fileURL);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				try {
					downLoadImg(null, imgUrl, fileURL);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread1.start();
		thread2.start();
	}
}