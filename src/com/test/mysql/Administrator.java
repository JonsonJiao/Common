package com.test.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * ������ ���û�����
 */
public class Administrator {
	public Administrator() {
		// ���ɲ˵�
		menu();
	}

	private void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������������������������������������������");
		System.out.println("��������������������û��˵����������������������");
		System.out.println("�������������������������������������������");
		System.out
				.println("��----------------------------------------------------------------------------��");
		System.out.println("��-------------------0>�����û� -------------------��");
		System.out.println("��-------------------1>�޸��û� -------------------��");
		System.out.println("��-------------------2>ɾ���û� -------------------��");
		System.out.println("��-------------------3>�鿴�û� -------------------��");
		System.out.println("��-------------------4>�������˵� -------------------��");
		System.out
				.println("��----------------------------------------------------------------------------��");
		int flag = sc.nextInt();
		switch (flag) {
		case 0:
			addAdministrator();
			break; // ����
		case 1:
			editAdministrator();
			break; // �޸�
		case 2:
			deleteAdministrator();
			break; // ɾ��
		case 3:
			queryAdministrator();
			break; // �鿴
		case 4:
			// Login.mainMenu();
			ConnectionUtil.closeConnection();
			break; // �������˵�
		default:
			menu();
			break;
		}
	}

	// �����û�
	private void addAdministrator() {
		System.out.println("�������û�����Ϣ����ʽ���û��˺�;�û�����;�û�����;�û��绰�����磺"
				+ "A0001;123456;����;15116210083");
		try {
			Scanner sc = new Scanner(System.in);
			String msg = sc.nextLine();
			String[] msgs = msg.split(";");
			String AdminAccount = msgs[0];
			String AdminPassword = msgs[1];
			String AdminName = msgs[2];
			String AdminTel = msgs[3];
			String sql = "insert into Administrator values(?,?,?,?)";
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, AdminAccount);
			sta.setString(2, AdminPassword);
			sta.setString(3, AdminName);
			sta.setString(4, AdminTel);
			int rs = sta.executeUpdate();
			if (rs > 0) {
				System.out.println("�����û��ɹ���");
			} else {
				System.out.println("�����û�ʧ�ܣ�");
			}
			System.out
					.println("��----------------------------------------------------------------------------��");
			System.out
					.println("��-------------------0> �鿴�û��б� ------------------��");
			System.out
					.println("��-------------------1> �����ϼ��˵� ------------------��");
			System.out
					.println("��-------------------2> �������˵� ------------------��");
			System.out
					.println("��----------------------------------------------------------------------------��");
			int flag = sc.nextInt();
			switch (flag) {
			case 0:
				queryAdministrator();
				break; // �鿴�û��б�
			case 1:
				menu();
				break; // ������һ���˵�
			// case 2:
			// Login.mainMenu();
			// break; // �������˵�
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("����ʧ�ܣ������ԣ�");
			menu();
		}
	}

	// �û��޸�
	private void editAdministrator() {
		System.out.println("������Ҫ�޸ĵ��û��˺ţ�");
		try {
			Scanner sc = new Scanner(System.in);
			String AdminAccount = sc.nextLine();
			String sql = "select * from Administrator where AdminAccount = "
					+ AdminAccount + "";
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			if (rs.next()) {
				System.out.println("�˺ţ�" + rs.getString(1));
				System.out.println("���룺" + rs.getString(2));
				System.out.println("������" + rs.getString(3));
				System.out.println("�绰��" + rs.getString(4));
				System.out.println(rs.getString(1) + "-" + rs.getString(2)
						+ "-" + rs.getString(3) + "-" + rs.getString(4));
				System.out.println();
				System.out
						.println("�������û�����Ϣ�����޸ģ���ʽ������-����-�绰-�˺ţ����磺����-111-15116210083-A0001");
				Scanner scc = new Scanner(System.in);
				String msg = scc.nextLine();
				String[] AdminInfo = msg.split("-");
				String AdminPassword = AdminInfo[0];
				String AdminName = AdminInfo[1];
				String AdminTel = AdminInfo[2];
				String updateSql = "update Administrator set AdminPassword =?,AdminName=?,AdminTel=? where AdminAccount =?";
				PreparedStatement ps = conn.prepareStatement(updateSql);
				ps.setString(1, AdminPassword);
				ps.setString(2, AdminName);
				ps.setString(3, AdminTel);
				ps.setString(4, AdminAccount);
				int result = ps.executeUpdate();
				if (result > 0) {
					System.out.println("�û��޸ĳɹ���");
				} else {
					System.out.println("�û��޸�ʧ�ܣ�");
				}
			} else {
				System.out.println("���û������ڣ�");
			}
			System.out
					.println("��----------------------------------------------------------------------------��");
			System.out
					.println("��-------------------0> �鿴�û��б� ------------------��");
			System.out
					.println("��-------------------1> �����ϼ��˵� ------------------��");
			System.out
					.println("��-------------------2> �������˵� ------------------��");
			System.out
					.println("��----------------------------------------------------------------------------��");
			int flag = sc.nextInt();
			switch (flag) {
			case 0:
				queryAdministrator();
				break; // �鿴����Ա�б�
			case 1:
				menu();
				break; // ������һ���˵�
			// case 2:
			// Login.mainMenu();
			// break; // �������˵�
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("����ʧ�ܣ������ԣ�");
			menu();
		}
	}

	// �û�ɾ��
	private void deleteAdministrator() {
		System.out.println("�������û��˺Ž���ɾ��!�˺ţ�");
		try {
			Scanner sc = new Scanner(System.in);
			String userId = sc.nextLine();
			System.out.println("���棺ȷ��ɾ�����û�?0:ȷ����1:ȡ��");
			Scanner scannerTemp = new Scanner(System.in);
			int isDelete = scannerTemp.nextInt();
			if (isDelete == 0) {
				String sql = "delete Administrator where AdminAccount = ?";
				Connection conn = ConnectionUtil.getConnection();
				PreparedStatement sta = conn.prepareStatement(sql);
				sta.setString(1, userId);
				int rs = sta.executeUpdate();
				if (rs > 0) {
					System.out.println("�û�ɾ���ɹ���");
				} else {
					System.out.println("�û�ɾ��ʧ�ܣ�");
				}
			}
			System.out
					.println("��----------------------------------------------------------------------------��");
			System.out
					.println("��-------------------0> �鿴�û��б� ------------------��");
			System.out
					.println("��-------------------1> �����ϼ��˵� ------------------��");
			System.out
					.println("��-------------------2> �������˵� ------------------��");
			System.out
					.println("��----------------------------------------------------------------------------��");
			int flag = sc.nextInt();
			switch (flag) {
			case 0:
				queryAdministrator();
				break; // �鿴����Ա�б�
			case 1:
				menu();
				break; // ������һ���˵�
			// case 2:
			// Login.mainMenu();
			// break; // �������˵�
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("����ʧ�ܣ������ԣ�");
			menu();
		}
	}

	// �û��鿴
	private void queryAdministrator() {
		System.out.println("�������������������������������������������");
		System.out.println("��������������������û��б���������������������");
		System.out.println("�������������������������������������������");
		System.out
				.println("��----------------------------------------------------------------------------��");
		try {
			String sql = "select * from Administrator";
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet result = sta.executeQuery();
			while (result.next()) {
				System.out.println("�˺ţ�" + result.getString(1));
				System.out.println("������" + result.getString(3));
				System.out.println("���룺" + result.getString(2));
				System.out.println("�绰��" + result.getString(4));
				System.out
						.println("��----------------------------------------------------------------------------��");
			}
			System.out
					.println("��----------------------------------------------------------------------------��");
			Scanner scanner = new Scanner(System.in);
			System.out
					.println("��----------------------------------------------------------------------------��");
			System.out
					.println("��-------------------0>�����ϼ��˵� -------------------��");
			System.out
					.println("��-------------------1>�������˵� -------------------��");
			System.out
					.println("��----------------------------------------------------------------------------��");
			int flag = scanner.nextInt();
			switch (flag) {
			case 0:
				menu();
				break; // ������һ���˵�
			// case 1:
			// Login.mainMenu();
			// break; // �������˵�
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("����ʧ�ܣ������ԣ�");
			menu();
		}
	}

	public static void main(String[] args) {
		new Administrator();
	}
}