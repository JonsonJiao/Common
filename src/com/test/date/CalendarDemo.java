package com.test.date;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarDemo {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
  		try {
			Date d = format.parse("1986-09-13 21:00:00");
			TimeZone timeZone = format.getTimeZone();
			boolean flg = timeZone.inDaylightTime(d);
			System.out.println(flg);
			Calendar c = Calendar.getInstance();
			for (int i = 0; i < 5; i++) {
				c.setTime(d);
				System.out.println(d);
				c.add(Calendar.HOUR_OF_DAY, 1);
//				Timestamp ts = new Timestamp(c.getTimeInMillis());
				d = c.getTime();
//				System.out.println(ts);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String startCal = "2012-12-31";
		String endCal = "2017-10-10";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = sdf.parse(startCal);
			Date endDate = sdf.parse(endCal);
			Calendar startCalendar = Calendar.getInstance();
			Calendar endCalendar = Calendar.getInstance();

			startCalendar.setTime(startDate);
			endCalendar.setTime(endDate);

			if (endCalendar.compareTo(startCalendar) < 0) {
				System.out.println("后一时次的日期小于前一时次的日期，请重新输入。");
				return;
			}

			int day = endCalendar.get(Calendar.DAY_OF_MONTH)
					- startCalendar.get(Calendar.DAY_OF_MONTH);
			int month = endCalendar.get(Calendar.MONTH)
					- startCalendar.get(Calendar.MONTH);
			int year = endCalendar.get(Calendar.YEAR)
					- startCalendar.get(Calendar.YEAR);

			if (day < 0) {
				month--;
			}

			File file = new File("");
			file.isDirectory();
			file.isFile();
			if (month < 0) {
				month += 12;
				year--;
			}
			System.out.println("两者相差年月为：" + year + "年" + month + "个月");
			System.out.println("今天是一星期中的第"
					+ startCalendar.get(Calendar.DAY_OF_WEEK) + "天（星期日为第一天）.");
			// printDayOfYear(startCal);
			// printMonth(Calendar.getInstance());
			System.out.println();
			strDateStr();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void strDateStr() {
		String dateStr = "6/1/2015 14:23:05";

		// String转换为Date，格式字符串必须与上面传入的日期字符串对应，不然会报ParseException
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try {
			Date date = sdf.parse(dateStr);
			// 输出date日期，调用date的默认打印方法
			System.out.println("默认的日期输出格式：" + date);

			// 格式化date的输出样式，需要指定想要的格式，比如输出2015-06-01 12:11:11格式的
			SimpleDateFormat outSdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String outDateStr = outSdf.format(date);
			System.out.println("格式化后的日期输出格式：" + outDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final String[] CHINA = { "七", "一", "二", "三", "四", "五", "六" };

	/**
	 * 输出给定日期所在月份的日历图
	 */
	public static void printMonth(Calendar calendar) {
		int oldMonth = calendar.get(Calendar.MONTH);
		int curMonth = oldMonth;
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置起始日期为1号
		// 输出第一行星期
		for (int i = 0; i < CHINA.length; i++) {
			System.out.print(CHINA[i] + "\t");
		}
		System.out.println();

		boolean firstRowFlag = true;
		int col = 0;
		int week = calendar.get(Calendar.WEEK_OF_MONTH);
		while (curMonth == oldMonth) {
			// 这里通过WEEK_OF_MONTH来判断当前日期是该月份的第一周，如果周发生了变化，需要另起一行进行输出
			if (week != calendar.get(Calendar.WEEK_OF_MONTH)) {
				week = calendar.get(Calendar.WEEK_OF_MONTH);
				col = 0;
				System.out.println();
			} else {
				col = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			}
			// 需要打印第一行的前面空白部分，只打印一次即可。firstRowFlag用于标记
			if (week == 1 && firstRowFlag) {
				for (int i = 0; i < col; i++) {
					System.out.print("\t");
				}
				firstRowFlag = false;
			}
			// 输出日期号
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
			// 更新日期，每次加一天
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// 更新月份
			curMonth = calendar.get(Calendar.MONTH);
		}

	}

	/**
	 * 根据输入日期输出该日期所在年份的天数。
	 * 
	 * @param dateStr
	 *            必须为2014-04-02格式
	 * @return 返回日期所在年份的第几天
	 */
	public static int printDayOfYear(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date startDate;
		try {
			startDate = sdf.parse(dateStr);
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(startDate);
			int index = startCalendar.get(Calendar.DAY_OF_YEAR);
			System.out.println("输入的日期" + dateStr + "是这一年中的第" + index + "天。");
			return index;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}
