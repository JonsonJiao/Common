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
				System.out.println("��һʱ�ε�����С��ǰһʱ�ε����ڣ����������롣");
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
			System.out.println("�����������Ϊ��" + year + "��" + month + "����");
			System.out.println("������һ�����еĵ�"
					+ startCalendar.get(Calendar.DAY_OF_WEEK) + "�죨������Ϊ��һ�죩.");
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

		// Stringת��ΪDate����ʽ�ַ������������洫��������ַ�����Ӧ����Ȼ�ᱨParseException
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try {
			Date date = sdf.parse(dateStr);
			// ���date���ڣ�����date��Ĭ�ϴ�ӡ����
			System.out.println("Ĭ�ϵ����������ʽ��" + date);

			// ��ʽ��date�������ʽ����Ҫָ����Ҫ�ĸ�ʽ���������2015-06-01 12:11:11��ʽ��
			SimpleDateFormat outSdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String outDateStr = outSdf.format(date);
			System.out.println("��ʽ��������������ʽ��" + outDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final String[] CHINA = { "��", "һ", "��", "��", "��", "��", "��" };

	/**
	 * ����������������·ݵ�����ͼ
	 */
	public static void printMonth(Calendar calendar) {
		int oldMonth = calendar.get(Calendar.MONTH);
		int curMonth = oldMonth;
		calendar.set(Calendar.DAY_OF_MONTH, 1); // ������ʼ����Ϊ1��
		// �����һ������
		for (int i = 0; i < CHINA.length; i++) {
			System.out.print(CHINA[i] + "\t");
		}
		System.out.println();

		boolean firstRowFlag = true;
		int col = 0;
		int week = calendar.get(Calendar.WEEK_OF_MONTH);
		while (curMonth == oldMonth) {
			// ����ͨ��WEEK_OF_MONTH���жϵ�ǰ�����Ǹ��·ݵĵ�һ�ܣ�����ܷ����˱仯����Ҫ����һ�н������
			if (week != calendar.get(Calendar.WEEK_OF_MONTH)) {
				week = calendar.get(Calendar.WEEK_OF_MONTH);
				col = 0;
				System.out.println();
			} else {
				col = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			}
			// ��Ҫ��ӡ��һ�е�ǰ��հײ��֣�ֻ��ӡһ�μ��ɡ�firstRowFlag���ڱ��
			if (week == 1 && firstRowFlag) {
				for (int i = 0; i < col; i++) {
					System.out.print("\t");
				}
				firstRowFlag = false;
			}
			// ������ں�
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
			// �������ڣ�ÿ�μ�һ��
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// �����·�
			curMonth = calendar.get(Calendar.MONTH);
		}

	}

	/**
	 * ���������������������������ݵ�������
	 * 
	 * @param dateStr
	 *            ����Ϊ2014-04-02��ʽ
	 * @return ��������������ݵĵڼ���
	 */
	public static int printDayOfYear(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date startDate;
		try {
			startDate = sdf.parse(dateStr);
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(startDate);
			int index = startCalendar.get(Calendar.DAY_OF_YEAR);
			System.out.println("���������" + dateStr + "����һ���еĵ�" + index + "�졣");
			return index;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}
