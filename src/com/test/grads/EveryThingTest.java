/**
 * 2014-2-27
 * jiaoqishun
 */
package com.test.grads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2014-2-27 author jiaoqishun
 */
public class EveryThingTest {
	public static void main(String[] args) {
		String str = args == null||args.length==0 ? null : args[0];
		Object o = str;
		Integer a = (Integer) o;
		System.out.println(a);

		// EveryThingTest ett = new EveryThingTest();
		// ett.printAz();
		// Pattern pattern = Pattern.compile("[a-z]+\\s*[a-z]+");//这里不会写
		// Pattern pattern = Pattern.compile("[b-z&&[^a]]+");//这里不会写
		Pattern pattern = Pattern.compile("[0-9]+|(.*[0-9]+.*)");// 这里不会写

		Matcher m = pattern.matcher("a");

		System.out.println(m.matches());

		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf.format(100000));// 格式化
		DecimalFormat df = new DecimalFormat();
		df.setGroupingSize(2);// 进行分组，
		df.setGroupingUsed(false);// 分组可用
		df.setCurrency(Currency.getInstance(Locale.US));// 加上货币符号，根据不同国家地区

		String message = "Once upon a time ({1,date},"
				+ "around about {1,time,short}), there "
				+ "was a humble developer named Geppetto"
				+ " who slaved for {0,number,integer}"
				+ "days with {2,number,percent} complete "
				+ "user requirements. ";
		Object[] variables = new Object[] { new Integer(4), new Date(),
				new Double(0.21) };
		String output = MessageFormat.format(message, variables);
		System.out.println(output);
		String path = "D:\\SWAP-Data\\VectorData\\中国数据/中国省界.shp";
		path = path.replaceAll("/", "\\\\");
		System.out.println(path);
	}

	/**
	 * 设计一个a到z的26个字母的无限循环，类似于数字相加一样，当从a循环到z的时候，下一个就是aa循环到zz，然后就是aaa到zzz，依此类推，
	 * 无限循环下去
	 */
	@SuppressWarnings("unused")
	private void printAz() {
		String azStr = new String("abcdefghijklmnopqrstuvwxyz");
		char[] azChar = azStr.toCharArray();
		int repeat = 1;
		while (repeat < 10) {
			for (int i = 0; i < azChar.length; i++) {
				for (int j = 0; j < repeat; j++) {
					System.out.print(azChar[i]);
				}
				System.out.println();
			}
			repeat++;
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void printXlsHeader() {
		File xlsFile = new File("D:\\test.xls");

		try {
			BufferedReader br = new BufferedReader(new FileReader(xlsFile));
			char[] buff = new char[218];
			while ((br.read(buff, 0, 218)) > -1) {
				System.out.println(buff);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void printDocHeader() {
		File xlsFile = new File("D:\\test.doc");

		try {
			BufferedReader br = new BufferedReader(new FileReader(xlsFile));
			char[] buff = new char[218];
			while ((br.read(buff, 0, 218)) > -1) {
				System.out.println(buff);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void outPut() {
		String fileName = "D:\\test.zip";
		String savePath = "D:\\tedd.zip";
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(
					fileName));
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					savePath));
			int bufferSize = 1024;
			byte[] buf = new byte[bufferSize];
			int start = 0;
			while (true) {
				int read = 0;
				if (dis != null) {
					read = dis.read(buf, start, bufferSize);
				}
				if (read == -1) {
					break;
				}
				dos.write(buf, start, read);
				dos.flush();
			}
			dos.close();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param height
	 * @param dayNum
	 */
	@SuppressWarnings("unused")
	private void getAllPossibleList(int height, int dayNum) {
		int ave = height % dayNum == 0 ? height / dayNum : height / dayNum + 1;
		int min = ave - dayNum / 2;
		int max = 10;
		ArrayList<Integer[]> possibleList = getPossibleList(height, min, max,
				dayNum);
	}

	/**
	 * @param height
	 * @param min
	 * @param max
	 * @param dayNum
	 * @return
	 */
	private ArrayList<Integer[]> getPossibleList(int height, int min, int max,
			int dayNum) {
		return null;
	}

	/**
	 * 
	 */
	public static void easyBank() {
		String userId = "1200221"; // 待验证的用户账号
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					"D:\\bank.txt")));
			// 跳过第一行
			br.readLine();
			String line = br.readLine();
			boolean existFlag = false;
			while (line != null) {
				existFlag = checkExist(line, userId);
				if (existFlag) {
					break;
				} else {
					line = br.readLine();
				}
			}
			System.out.println("经检查，" + (existFlag ? "存在" : "不存在") + "账号"
					+ userId);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据传入的信息检查是否存在该账号
	 * 
	 * @param line
	 * @param userId
	 * @return
	 */
	public static boolean checkExist(String line, String userId) {
		String[] infos = line.split("\\t");
		if (infos[0].equals(userId)) {
			return true;
		}
		return false;
	}

}
