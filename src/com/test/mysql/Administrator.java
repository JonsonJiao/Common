package com.test.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 类描述 ：用户管理
 */
public class Administrator {
	public Administrator() {
		// 生成菜单
		menu();
	}

	private void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆用户菜单☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out
				.println("┌----------------------------------------------------------------------------┐");
		System.out.println("├-------------------0>新增用户 -------------------┤");
		System.out.println("├-------------------1>修改用户 -------------------┤");
		System.out.println("├-------------------2>删除用户 -------------------┤");
		System.out.println("├-------------------3>查看用户 -------------------┤");
		System.out.println("├-------------------4>返回主菜单 -------------------┤");
		System.out
				.println("└----------------------------------------------------------------------------┘");
		int flag = sc.nextInt();
		switch (flag) {
		case 0:
			addAdministrator();
			break; // 新增
		case 1:
			editAdministrator();
			break; // 修改
		case 2:
			deleteAdministrator();
			break; // 删除
		case 3:
			queryAdministrator();
			break; // 查看
		case 4:
			// Login.mainMenu();
			ConnectionUtil.closeConnection();
			break; // 返回主菜单
		default:
			menu();
			break;
		}
	}

	// 新增用户
	private void addAdministrator() {
		System.out.println("请输入用户的信息，格式：用户账号;用户密码;用户名称;用户电话。例如："
				+ "A0001;123456;张三;15116210083");
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
				System.out.println("新增用户成功！");
			} else {
				System.out.println("新增用户失败！");
			}
			System.out
					.println("┌----------------------------------------------------------------------------┐");
			System.out
					.println("├-------------------0> 查看用户列表 ------------------┤");
			System.out
					.println("├-------------------1> 返回上级菜单 ------------------┤");
			System.out
					.println("├-------------------2> 返回主菜单 ------------------┤");
			System.out
					.println("└----------------------------------------------------------------------------┘");
			int flag = sc.nextInt();
			switch (flag) {
			case 0:
				queryAdministrator();
				break; // 查看用户列表
			case 1:
				menu();
				break; // 返回上一级菜单
			// case 2:
			// Login.mainMenu();
			// break; // 返回主菜单
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("操作失败，请重试！");
			menu();
		}
	}

	// 用户修改
	private void editAdministrator() {
		System.out.println("请输入要修改的用户账号：");
		try {
			Scanner sc = new Scanner(System.in);
			String AdminAccount = sc.nextLine();
			String sql = "select * from Administrator where AdminAccount = "
					+ AdminAccount + "";
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			if (rs.next()) {
				System.out.println("账号：" + rs.getString(1));
				System.out.println("密码：" + rs.getString(2));
				System.out.println("姓名：" + rs.getString(3));
				System.out.println("电话：" + rs.getString(4));
				System.out.println(rs.getString(1) + "-" + rs.getString(2)
						+ "-" + rs.getString(3) + "-" + rs.getString(4));
				System.out.println();
				System.out
						.println("请输入用户的信息进行修改，格式：密码-姓名-电话-账号，例如：张三-111-15116210083-A0001");
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
					System.out.println("用户修改成功！");
				} else {
					System.out.println("用户修改失败！");
				}
			} else {
				System.out.println("该用户不存在！");
			}
			System.out
					.println("┌----------------------------------------------------------------------------┐");
			System.out
					.println("├-------------------0> 查看用户列表 ------------------┤");
			System.out
					.println("├-------------------1> 返回上级菜单 ------------------┤");
			System.out
					.println("├-------------------2> 返回主菜单 ------------------┤");
			System.out
					.println("└----------------------------------------------------------------------------┘");
			int flag = sc.nextInt();
			switch (flag) {
			case 0:
				queryAdministrator();
				break; // 查看管理员列表
			case 1:
				menu();
				break; // 返回上一级菜单
			// case 2:
			// Login.mainMenu();
			// break; // 返回主菜单
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("操作失败，请重试！");
			menu();
		}
	}

	// 用户删除
	private void deleteAdministrator() {
		System.out.println("请输入用户账号进行删除!账号：");
		try {
			Scanner sc = new Scanner(System.in);
			String userId = sc.nextLine();
			System.out.println("警告：确定删除该用户?0:确定；1:取消");
			Scanner scannerTemp = new Scanner(System.in);
			int isDelete = scannerTemp.nextInt();
			if (isDelete == 0) {
				String sql = "delete Administrator where AdminAccount = ?";
				Connection conn = ConnectionUtil.getConnection();
				PreparedStatement sta = conn.prepareStatement(sql);
				sta.setString(1, userId);
				int rs = sta.executeUpdate();
				if (rs > 0) {
					System.out.println("用户删除成功！");
				} else {
					System.out.println("用户删除失败！");
				}
			}
			System.out
					.println("┌----------------------------------------------------------------------------┐");
			System.out
					.println("├-------------------0> 查看用户列表 ------------------┤");
			System.out
					.println("├-------------------1> 返回上级菜单 ------------------┤");
			System.out
					.println("├-------------------2> 返回主菜单 ------------------┤");
			System.out
					.println("└----------------------------------------------------------------------------┘");
			int flag = sc.nextInt();
			switch (flag) {
			case 0:
				queryAdministrator();
				break; // 查看管理员列表
			case 1:
				menu();
				break; // 返回上一级菜单
			// case 2:
			// Login.mainMenu();
			// break; // 返回主菜单
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("操作失败，请重试！");
			menu();
		}
	}

	// 用户查看
	private void queryAdministrator() {
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆用户列表☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
		System.out
				.println("┌----------------------------------------------------------------------------┐");
		try {
			String sql = "select * from Administrator";
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet result = sta.executeQuery();
			while (result.next()) {
				System.out.println("账号：" + result.getString(1));
				System.out.println("姓名：" + result.getString(3));
				System.out.println("密码：" + result.getString(2));
				System.out.println("电话：" + result.getString(4));
				System.out
						.println("├----------------------------------------------------------------------------┤");
			}
			System.out
					.println("├----------------------------------------------------------------------------┤");
			Scanner scanner = new Scanner(System.in);
			System.out
					.println("├----------------------------------------------------------------------------┤");
			System.out
					.println("├-------------------0>返回上级菜单 -------------------┤");
			System.out
					.println("├-------------------1>返回主菜单 -------------------┤");
			System.out
					.println("└----------------------------------------------------------------------------┘");
			int flag = scanner.nextInt();
			switch (flag) {
			case 0:
				menu();
				break; // 返回上一级菜单
			// case 1:
			// Login.mainMenu();
			// break; // 返回主菜单
			default:
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("操作失败，请重试！");
			menu();
		}
	}

	public static void main(String[] args) {
		new Administrator();
	}
}