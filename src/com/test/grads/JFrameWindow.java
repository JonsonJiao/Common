/**
 * 
 */
package com.test.grads;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JFrameWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 901786654578296253L;
	Frame frame_win;
	JLabel scan_win;
	Panel scan_img;
	Button scan, res, calcul, next;
	JPanel fFace, uFace, lFace, rFace, bFace, dFace;
	JRadioButton fFaceBotton, uFaceBotton, lFaceBotton, rFaceBotton,
			dFaceBotton, bFaceBotton;
	ButtonGroup buttonGroup;
	Label in, ou;
	TextArea author;

	@SuppressWarnings("deprecation")
	void init() {
		final shibie sb = new shibie();

		frame_win = new JFrame("魔方自动扫描还原");
		scan_win = new JLabel("扫描窗口");
		scan_img = new Panel();

		bFace = new JPanel();
		uFace = new JPanel();
		fFace = new JPanel();
		dFace = new JPanel();
		rFace = new JPanel();
		lFace = new JPanel();

		scan = new Button("扫描");
		calcul = new Button("运算");
		next = new Button("下步");
		res = new Button("清除");

		buttonGroup = new ButtonGroup();
		fFaceBotton = new JRadioButton("正面");
		uFaceBotton = new JRadioButton("上面");
		lFaceBotton = new JRadioButton("左面");
		rFaceBotton = new JRadioButton("右面");
		dFaceBotton = new JRadioButton("底面");
		bFaceBotton = new JRadioButton("背面");
		buttonGroup.add(fFaceBotton);
		buttonGroup.add(uFaceBotton);
		buttonGroup.add(lFaceBotton);
		buttonGroup.add(rFaceBotton);
		buttonGroup.add(bFaceBotton);
		buttonGroup.add(dFaceBotton);

		in = new Label();
		ou = new Label();
		author = new TextArea("\n作者：Anke\n\n\n\nEmail:1261123807@qq.com\n版权所有",
				6, 40, 3);

		frame_win.setBounds(300, 100, 750, 530);
		frame_win.setLayout(null);
		frame_win.setResizable(false);

		scan_win.setBounds(1, 1, 300, 300);
		scan_win.setOpaque(true);
		scan_win.setBackground(new java.awt.Color(153, 204, 204));
		// scan_win.setVisible(false);

		scan_img.setBounds(340, 80, 320, 425);
		scan_img.setBackground(new java.awt.Color(153, 204, 204));
		scan_img.setLayout(null);
		// scan_img.setVisible(false);

		bFace.setBounds(110, 5, 100, 100);
		bFace.setBackground(new java.awt.Color(204, 204, 255));
		uFace.setBounds(110, 110, 100, 100);
		uFace.setBackground(new java.awt.Color(204, 204, 255));
		fFace.setBounds(110, 215, 101, 100);
		fFace.setBackground(new java.awt.Color(204, 204, 255));
		dFace.setBounds(110, 320, 100, 100);
		dFace.setBackground(new java.awt.Color(204, 204, 255));
		lFace.setBounds(5, 215, 100, 100);
		lFace.setBackground(new java.awt.Color(204, 204, 255));
		rFace.setBounds(215, 215, 100, 100);
		rFace.setBackground(new java.awt.Color(204, 204, 255));
		scan_img.add(fFace);
		scan_img.add(uFace);
		scan_img.add(dFace);
		scan_img.add(rFace);
		scan_img.add(lFace);
		scan_img.add(bFace);

		scan.setBounds(1, 310, 70, 20);
		calcul.setBounds(76, 310, 70, 20);
		res.setBounds(226, 310, 70, 20);
		next.setBounds(151, 310, 70, 20);

		fFaceBotton.setBounds(680, 170, 80, 20);
		uFaceBotton.setBounds(680, 195, 80, 20);
		lFaceBotton.setBounds(680, 220, 80, 20);
		rFaceBotton.setBounds(680, 245, 80, 20);
		bFaceBotton.setBounds(680, 270, 80, 20);
		dFaceBotton.setBounds(680, 295, 80, 20);

		in.setText("输入:");
		in.setBounds(305, 5, 430, 30);
		in.setBackground(new java.awt.Color(153, 204, 204));
		ou.setText("输入:");
		ou.setBounds(305, 45, 430, 30);
		ou.setBackground(new java.awt.Color(153, 204, 204));
		// author.setText("作者：Anke\nEmail:1261123807@qq.com\n版权所有");
		author.setBounds(20, 380, 200, 100);
		author.disable();
		// author.setBackground(new java.awt.Color(153, 204, 204));

		frame_win.add(scan_win);
		frame_win.add(scan_img);
		frame_win.add(scan);
		frame_win.add(calcul);
		frame_win.add(next);
		frame_win.add(res);
		frame_win.add(fFaceBotton);
		frame_win.add(uFaceBotton);
		frame_win.add(lFaceBotton);
		frame_win.add(rFaceBotton);
		frame_win.add(bFaceBotton);
		frame_win.add(dFaceBotton);
		frame_win.add(in);
		frame_win.add(ou);
		frame_win.add(author);

		fFaceBotton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fac = "F";
				sb.shibei(fac);
				System.out.println("点击了" + fac);
				setBkground(); // 更改背景
				scan_win.repaint();
			}
		});

		uFaceBotton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fac = "u";
				sb.shibei(fac);
				System.out.println("点击了" + fac);
			}
		});

		lFaceBotton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fac = "l";
				sb.shibei(fac);
				System.out.println("点击了" + fac);
			}
		});

		rFaceBotton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fac = "r";
				sb.shibei(fac);
				System.out.println("点击了" + fac);
			}
		});

		bFaceBotton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fac = "b";
				sb.shibei(fac);
				System.out.println("点击了" + fac);
			}
		});

		dFaceBotton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fac = "d";
				sb.shibei(fac);
				System.out.println("点击了" + fac);
			}
		});

		frame_win.setVisible(true);
	}

	void setBkground() {
		scan_win.setBackground(new java.awt.Color(204, 204, 255));
		scan_win.setIcon(new ImageIcon("D:/test/java/MoFangView/face_img/"
				+ fac + ".jpg"));
	}

	JFrameWindow() {
		init();
	}

	private String fac = null;

	public static void main(String[] args) {
		new JFrameWindow();
	}

}