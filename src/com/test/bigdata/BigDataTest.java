/**
 * 2014-6-17
 * jiaoqishun
 */
package com.test.bigdata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 2014-6-17 author jiaoqishun
 */
public class BigDataTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1145268605536997025L;
	private static SimpleDateFormat birthSdf = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat versionSdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		// ���Զ�ȡ���ݴ������ݿ�
		String path = "F:\\Study\\forFun\\2000W\\";
		File file = new File(path);
		File[] files = file.listFiles();
		for (File f : files) {
			readCsv(f);
		}

		// ����IP
		// BigDataTest addressUtils = new BigDataTest();
		// // ����ip 219.136.134.157 �й�=����=�㶫ʡ=������=Խ����=����
		// String ip = "219.136.134.157";
		// String address = "";
		// try {
		// address = addressUtils.getAddresses("ip=" + ip, "gbk");
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(address);
		// // ������Ϊ���㶫ʡ,������,Խ����
		// new BigDataTest();

		// ���Ժ�̨���ó���
		// runCmd();
	}

	public static void runCmd() {
		// windows
		// String cmd = "F:\\apache-tomcat-6.0.20.exe";
		// String cmd =
		// "D:\\Program Files\\Microsoft Office\\OFFICE11\\WINWORD.EXE F:\\test.doc";
		String cmd = "cmd.exe /c start E:\\FogApp\\FogApp1.1.exe";
		// String cmd = "ping www.qq.com";

		// linux
		// String cmd = "./fork_wait";
		// String cmd = "ls -l";
		// String[] cmd=new String[3];
		// cmd[0]="/bin/sh";
		// cmd[1]="-c";
		// cmd[2]="ls -l ./";
		Runtime run = Runtime.getRuntime();// �����뵱ǰ Java Ӧ�ó�����ص�����ʱ����
		try {
			Process p = run.exec(cmd);// ������һ��������ִ������
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = inBr.readLine()) != null)
				// �������ִ�к��ڿ���̨�������Ϣ
				System.out.println(lineStr);// ��ӡ�����Ϣ
			// ��������Ƿ�ִ��ʧ�ܡ�
			if (p.waitFor() != 0) {
				if (p.exitValue() == 1)// p.exitValue()==0��ʾ����������1������������
					System.err.println("����ִ��ʧ��!");
			}
			inBr.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����IP��ַ��ȡ��ϸ�ĵ�����Ϣ
	 * 
	 * @project:personGocheck
	 * @class:AddressUtils.java
	 * @author:heguanhua E-mail:37809893@qq.com
	 * @date��Nov 14, 2012 6:38:25 PM
	 */
	/**
	 * 
	 * @param content
	 *            ����Ĳ��� ��ʽΪ��name=xxx&pwd=xxx
	 * @param encoding
	 *            ��������������롣��GBK,UTF-8��
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getAddresses(String content, String encodingString)
			throws UnsupportedEncodingException {
		// �������pconline�Ľӿ�
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		// ��http://whois.pconline.com.cnȡ��IP���ڵ�ʡ������Ϣ
		String returnStr = this.getResult(urlStr, content, encodingString);
		if (returnStr != null) {
			// �����ص�ʡ������Ϣ
			System.out.println(returnStr);
			String[] temp = returnStr.split(",");
			if (temp.length < 3) {
				return "0";// ��ЧIP������������
			}
			// String region = (temp[5].split(":"))[1].replaceAll("\"", "");
			// region = decodeUnicode(region);// ʡ��
			String country = "";
			String area = "";
			String region = "";
			String city = "";
			String county = "";
			String isp = "";
			for (int i = 0; i < temp.length; i++) {
				switch (i) {
				case 1:
					country = (temp[i].split(":"))[2].replaceAll("\"", "");
					country = decodeUnicode(country);// ����
					break;
				case 3:
					area = (temp[i].split(":"))[1].replaceAll("\"", "");
					area = decodeUnicode(area);// ����
					break;
				case 5:
					region = (temp[i].split(":"))[1].replaceAll("\"", "");
					region = decodeUnicode(region);// ʡ��
					break;
				case 7:
					city = (temp[i].split(":"))[1].replaceAll("\"", "");
					city = decodeUnicode(city);// ����
					break;
				case 9:
					county = (temp[i].split(":"))[1].replaceAll("\"", "");
					county = decodeUnicode(county);// ����
					break;
				case 11:
					isp = (temp[i].split(":"))[1].replaceAll("\"", "");
					isp = decodeUnicode(isp);// ISP��˾ break;
				}
			}

			System.out.println(country + "=" + area + "=" + region + "=" + city
					+ "=" + county + "=" + isp);
			return region;
		}
		return returnStr;
	}

	/**
	 * @param urlStr
	 *            ����ĵ�ַ
	 * @param content
	 *            ����Ĳ��� ��ʽΪ��name=xxx&pwd=xxx
	 * @param encoding
	 *            ��������������롣��GBK,UTF-8��
	 * @return
	 */
	private String getResult(String urlStr, String content, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// �½�����ʵ��
			connection.setConnectTimeout(2000);// �������ӳ�ʱʱ�䣬��λ����
			connection.setReadTimeout(2000);// ���ö�ȡ���ݳ�ʱʱ�䣬��λ����
			connection.setDoOutput(true);// �Ƿ������� true|false
			connection.setDoInput(true);// �Ƿ��������true|false
			connection.setRequestMethod("POST");// �ύ����POST|GET
			connection.setUseCaches(false);// �Ƿ񻺴�true|false
			connection.connect();// �����Ӷ˿�
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());// ����������Զ˷�����д����
			out.writeBytes(content);// д����,Ҳ�����ύ��ı� name=xxx&pwd=xxx
			out.flush();// ˢ��
			out.close();// �ر������
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encoding));// ���Զ�д�����ݶԶ˷�������������
			// ,��BufferedReader������ȡ
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// �ر�����
			}
		}
		return null;
	}

	/**
	 * unicode ת���� ����
	 * 
	 * @author fanhui 2007-3-15
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	public BigDataTest(String arg) {
		try {
			URL url = new URL("File:\\"
					+ "C:\\Users\\th\\Desktop\\20120419fire.gif");
			ImageIcon ii = new ImageIcon(url);
			JLabel label = new JLabel();
			label.setLayout(new BorderLayout());
			JPanel panel = new JPanel();
			JPanel panel_lbl = new JPanel();
			label.add(panel_lbl, BorderLayout.CENTER);
			JLabel lbl_img = new JLabel();
			lbl_img.setIcon(ii);
			panel_lbl.add(lbl_img);
			// label.setIcon(ii);
			JLabel lbl_Up = new JLabel();
			label.add(panel, BorderLayout.SOUTH);
			panel.add(lbl_Up);
			panel.setBackground(Color.pink);
			lbl_Up.setText("testssssssssssssssssssssssssssssssssssssssssssssss");
			lbl_Up.setOpaque(false);
			lbl_Up.setBackground(Color.pink);
			JFrame frm = new JFrame();
			frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frm.getContentPane().add(label, BorderLayout.CENTER);
			frm.setSize(120, 90);
			frm.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public BigDataTest() {
		// TODO Auto-generated constructor stub
	}

	public static void readCsv(File csv) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(csv));
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
			String line = "";
			line = br.readLine(); // ������һ��
			int count = 10000;
			ArrayList<String[]> values = new ArrayList<String[]>(count);
			while ((line = br.readLine()) != null) {
				// ��һ�����ݷָ�ɶ���ֶ�
				count--;
				String[] value = line.split(",");
				values.add(value);
				if (count == 0) {
					write2DataBase(values);
					count = 10000;
					values = null;
					values = new ArrayList<String[]>(count);
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			// ����File��������ʱ���쳣
			e.printStackTrace();
		} catch (IOException e) {
			// ����BufferedReader����ر�ʱ���쳣
			e.printStackTrace();
		}
	}

	public static void write2DataBase(ArrayList<String[]> values) {
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://127.0.0.1:3306/BigDataTest";
		String userName = "root";
		String userPwd = "1234dhcc";
		try {
			Class.forName(driverName);
			System.out.println("���������ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		try {
			Connection dbConn = DriverManager.getConnection(dbURL, userName,
					userPwd);
			System.out.println("�������ݿ�ɹ���");
			String sql = "insert into BigDataBaseTable(NAME, CARDNO, DESCRIOT,"
					+ " CTFTP, CTFID, GENDER, BIRTHDAY, ADDRESS, ZIP, DIRTY, DISTRICT1, DISTRICT2, DISTRICT3, DISTRICT4, "
					+ "DISTRICT5, DISTRICT6, FIRSTNM, LASTNM, DUTY, MOBILE, TEL, FAX, EMAIL, NATION, TASTE, EDUCATION, COMPANY, "
					+ "CTEL, CADDRESS, CZIP, FAMILY, VERSION, ID) "
					+ "values(?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?," + "?,?,?)";
			PreparedStatement pstmt = null;
			try {
				int flag = 0;
				for (int i = 0; i < values.size(); i++) {
					String[] value = values.get(i);
					pstmt = dbConn.prepareStatement(sql);
					int j = 0;
					if (value.length < 32 || value.length > 33) {
						continue;
					}
					if (flag != 0) {
						flag = 0;
					}
					pstmt.setString(++j, value[j - 1]); // name
					pstmt.setString(++j, value[j - 1]); // cardno
					pstmt.setString(++j, value[j - 1]); // descriot
					pstmt.setString(++j, value[j - 1]); // ctftp
					pstmt.setString(++j, value[j - 1]); // ctfid
					pstmt.setString(++j, value[j - 1]); // gender
					String birth = value[++j - 1];
					if (birth == null || birth.trim().equals("")) {
						pstmt.setTimestamp(j, null);
					} else {
						pstmt.setTimestamp(j,
								new Timestamp(birthSdf.parse(birth).getTime())); // version
					}
					pstmt.setString(++j, value[j - 1]); // address
					pstmt.setString(++j, value[j - 1]); // zip
					pstmt.setString(++j, value[j - 1]); // dirty
					pstmt.setString(++j, value[j - 1]); // district1
					pstmt.setString(++j, value[j - 1]); // district2
					pstmt.setString(++j, value[j - 1]); // district3
					pstmt.setString(++j, value[j - 1]); // district4
					pstmt.setString(++j, value[j - 1]); // district5
					pstmt.setString(++j, value[j - 1]); // district6
					pstmt.setString(++j, value[j - 1]); // firstnm
					pstmt.setString(++j, value[j - 1]); // lastnm
					pstmt.setString(++j, value[j - 1]); // duty
					pstmt.setString(++j, value[j - 1]); // mobile
					pstmt.setString(++j, value[j - 1]); // tel
					pstmt.setString(++j, value[j - 1]); // fax
					pstmt.setString(++j, value[j - 1]); // email
					pstmt.setString(++j, value[j - 1]); // nation
					pstmt.setString(++j, value[j - 1]); // taste
					pstmt.setString(++j, value[j - 1]); // education
					pstmt.setString(++j, value[j - 1]); // company
					pstmt.setString(++j, value[j - 1]); // ctel
					pstmt.setString(++j, value[j - 1]); // caddress
					pstmt.setString(++j, value[j - 1]); // czip
					String family = value[++j - 1];
					if (family == null || family.equals("")) {
						pstmt.setInt(j, -1);
					} else {
						pstmt.setInt(j, Integer.parseInt(family));
					}
					String version = value[++j - 1];
					if (version == null || version.equals("")
							|| version.length() < 10) {
						pstmt.setTimestamp(j, null);
					} else {
						pstmt.setTimestamp(j,
								new Timestamp(versionSdf.parse(version)
										.getTime())); // version
					}
					String id = value[++j - 1];
					if (id == null || id.equals("")) {
						pstmt.setInt(j, -1);
					} else {
						pstmt.setInt(j, Integer.parseInt(id)); // id
					}
					try {
						flag = pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(value);
						for (int i1 = 0; i1 < value.length; i1++) {
							System.out.println(value[i1].length());
						}
					}
					if (flag > 0) {
						System.out.println("insert success");
					}
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println();
			} finally {
				dbConn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("MySQL����ʧ�ܣ�");
		}
	}
}
