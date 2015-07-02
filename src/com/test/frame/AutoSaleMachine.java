package com.test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * �Զ��ۻ��� ����˵����
 * <ol>
 * <li>���ͼƬ��ͼƬ�·��Ĺ���ѡ�������Ʒ��ѡ���ȡ��ѡ����Ʒ����С�ڵ���0ʱ�޷�ѡ��</li>
 * <li>�����Ͷ��һԪ����Ͷ����Ԫ����ťģ��Ͷ��Ǯ������</li>
 * <li>��������򡱰�ť��ɹ��򣬵�Ͷ��Ǯ�����ڹ�����Ʒ��Ҫ��Ǯ��ʱ���򲻳ɹ�����ϵͳ��Ǯ��������ʱ���򲻳ɹ���</li>
 * <li>������˿��ť����˿</li>
 * <li>������鿴����ť���Բ鿴������Ʒ��ʣ����������ʾ������ر���ʾ��</li>
 * <li>
 * �������¼����ť������¼����Ա��Ҫ���������������ADMIN����Խ������Աҳ�棬����Աҳ����Բ鿴ϵͳ����ϵͳһԪ��������Ԫ����
 * ��ͬʱ�����ֶ�����һԪ����Ԫ�������������Ӳ�����</li>
 * </ol>
 * <p>
 * <h4>ע��������֮ǰ�޸�ͼƬ·��</h4>
 * 
 * @author th
 */
public class AutoSaleMachine extends JFrame {

	private static final long serialVersionUID = 6576104659382463412L;

	private static final String ADMIN = "ADMIN"; // ����Ա����

	// ��ʼ��������Ʒ������
	private static final String NAME_COKE = "�ɿڿ���";
	private static final String NAME_FANTA = "�Ҵ�";
	private static final String NAME_RTEA = "���";
	private static final String NAME_GTEA = "�̲�";

	// ��ʼ��������Ʒ�ļ۸�
	private static final int PRICE_COKE = 3;
	private static final int PRICE_FANTA = 2;
	private static final int PRICE_RTEA = 4;
	private static final int PRICE_GTEA = 5;

	// ��ʼ��������Ʒ��ID��û�ж�����
	private static final int ID_COKE = 1;
	private static final int ID_FANTA = 2;
	private static final int ID_RTEA = 3;
	private static final int ID_GTEA = 4;

	// ��ʼ��������Ʒ����
	private static int COUNT_COKE = 10;
	private static int COUNT_FANTA = 1;
	private static int COUNT_RTEA = 30;
	private static int COUNT_GTEA = 2;

	private String img_coke = "photos/coke.jpg";
	private String img_fanta = "photos/fanta.jpg";
	private String img_rtea = "photos/rtea.jpg";
	private String img_gtea = "photos/gtea.jpg";

	private int cokeCount;
	private int fantaCount;
	private int rteaCount;
	private int gteaCount;

	private int userMoneySum; // �û�Ͷ���Ǯ��
	private int userOneCount; // �û�һԪ����
	private int userFiveCount; // �û���Ԫ����
	private int sysMoneySum; // ϵͳ����Ǯ��
	private int sysOneCount = 1; // ϵͳһԪ����
	private int sysFiveCount = 20; // ϵͳ��Ԫ����
	private JTextField txt_UserMoney;
	private JButton btn_UserFive;
	private JButton btn_UserOne;

	private GoodPanel gp_coke;
	private GoodPanel gp_fanta;
	private GoodPanel gp_rtea;
	private GoodPanel gp_gtea;

	private JButton btn_Show;
	private JButton btn_Buy;
	private JButton btn_Cancle;
	private JButton btn_Admin;
	private JPanel panel_Admin;
	private JLabel label;
	private JTextField txt_SysSum;
	private JLabel label_1;
	private JTextField txt_SysOne;
	private JLabel lblNewLabel;
	private JTextField txt_SysFive;
	private JButton btn_Save;
	private JButton btn_Logout;

	public AutoSaleMachine() {
		setTitle("\u81EA\u52A9\u552E\u8D27\u673A");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel_Good = new JPanel();
		GridBagConstraints gbc_panel_Good = new GridBagConstraints();
		gbc_panel_Good.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Good.fill = GridBagConstraints.BOTH;
		gbc_panel_Good.gridx = 0;
		gbc_panel_Good.gridy = 0;
		getContentPane().add(panel_Good, gbc_panel_Good);
		GridBagLayout gbl_panel_Good = new GridBagLayout();
		gbl_panel_Good.columnWidths = new int[] { 230, 230, 0 };
		gbl_panel_Good.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Good.columnWeights = new double[] { 0.5, 0.5,
				Double.MIN_VALUE };
		gbl_panel_Good.rowWeights = new double[] { 0.5, 0.5, Double.MIN_VALUE };
		panel_Good.setLayout(gbl_panel_Good);

		gp_coke = new GoodPanel(img_coke, PRICE_COKE, NAME_COKE, ID_COKE,
				COUNT_COKE);
		GridBagConstraints gbc_gp_coke = new GridBagConstraints();
		gbc_gp_coke.insets = new Insets(5, 5, 5, 5);
		gbc_gp_coke.fill = GridBagConstraints.BOTH;
		gbc_gp_coke.gridx = 0;
		gbc_gp_coke.gridy = 0;
		panel_Good.add(gp_coke, gbc_gp_coke);

		gp_fanta = new GoodPanel(img_fanta, PRICE_FANTA, NAME_FANTA, ID_FANTA,
				COUNT_FANTA);
		GridBagConstraints gbc_gp_fanta = new GridBagConstraints();
		gbc_gp_fanta.insets = new Insets(5, 5, 5, 5);
		gbc_gp_fanta.fill = GridBagConstraints.BOTH;
		gbc_gp_fanta.gridx = 1;
		gbc_gp_fanta.gridy = 0;
		panel_Good.add(gp_fanta, gbc_gp_fanta);

		gp_rtea = new GoodPanel(img_rtea, PRICE_RTEA, NAME_RTEA, ID_RTEA,
				COUNT_RTEA);
		GridBagConstraints gbc_gp_rtea = new GridBagConstraints();
		gbc_gp_rtea.insets = new Insets(5, 5, 5, 5);
		gbc_gp_rtea.fill = GridBagConstraints.BOTH;
		gbc_gp_rtea.gridx = 0;
		gbc_gp_rtea.gridy = 1;
		panel_Good.add(gp_rtea, gbc_gp_rtea);

		gp_gtea = new GoodPanel(img_gtea, PRICE_GTEA, NAME_GTEA, ID_GTEA,
				COUNT_GTEA);
		GridBagConstraints gbc_gp_gtea = new GridBagConstraints();
		gbc_gp_gtea.insets = new Insets(5, 5, 5, 5);
		gbc_gp_gtea.fill = GridBagConstraints.BOTH;
		gbc_gp_gtea.gridx = 1;
		gbc_gp_gtea.gridy = 1;
		panel_Good.add(gp_gtea, gbc_gp_gtea);

		JPanel panel_Btn = new JPanel();
		GridBagConstraints gbc_panel_Btn = new GridBagConstraints();
		gbc_panel_Btn.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Btn.gridx = 0;
		gbc_panel_Btn.gridy = 1;
		getContentPane().add(panel_Btn, gbc_panel_Btn);
		GridBagLayout gbl_panel_Btn = new GridBagLayout();
		gbl_panel_Btn.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_Btn.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Btn.columnWeights = new double[] { 0.25, 0.25, 0.25, 0.25,
				Double.MIN_VALUE };
		gbl_panel_Btn.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_Btn.setLayout(gbl_panel_Btn);

		JLabel lbl_UserMoney = new JLabel(
				"\u6295\u5165\u91D1\u989D\uFF08\u5143\uFF09");
		GridBagConstraints gbc_lbl_UserMoney = new GridBagConstraints();
		gbc_lbl_UserMoney.insets = new Insets(5, 5, 5, 5);
		gbc_lbl_UserMoney.gridx = 0;
		gbc_lbl_UserMoney.gridy = 0;
		panel_Btn.add(lbl_UserMoney, gbc_lbl_UserMoney);

		txt_UserMoney = new JTextField();
		txt_UserMoney.setEditable(false);
		GridBagConstraints gbc_txt_UserMoney = new GridBagConstraints();
		gbc_txt_UserMoney.insets = new Insets(5, 0, 5, 5);
		gbc_txt_UserMoney.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_UserMoney.gridx = 1;
		gbc_txt_UserMoney.gridy = 0;
		panel_Btn.add(txt_UserMoney, gbc_txt_UserMoney);
		txt_UserMoney.setColumns(10);

		btn_UserOne = new JButton("\u6295\u5165\u4E00\u5143");
		GridBagConstraints gbc_btn_UserOne = new GridBagConstraints();
		gbc_btn_UserOne.insets = new Insets(5, 0, 5, 5);
		gbc_btn_UserOne.gridx = 2;
		gbc_btn_UserOne.gridy = 0;
		panel_Btn.add(btn_UserOne, gbc_btn_UserOne);
		btn_UserOne.addActionListener(handler);

		btn_Show = new JButton("\u67E5\u770B");
		GridBagConstraints gbc_btn_Show = new GridBagConstraints();
		gbc_btn_Show.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Show.gridx = 0;
		gbc_btn_Show.gridy = 1;
		panel_Btn.add(btn_Show, gbc_btn_Show);
		btn_Show.addActionListener(handler);

		btn_Buy = new JButton("\u8D2D\u4E70");
		GridBagConstraints gbc_btn_Buy = new GridBagConstraints();
		gbc_btn_Buy.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Buy.gridx = 1;
		gbc_btn_Buy.gridy = 1;
		panel_Btn.add(btn_Buy, gbc_btn_Buy);
		btn_Buy.addActionListener(handler);

		btn_UserFive = new JButton("\u6295\u5165\u4E94\u5143");
		GridBagConstraints gbc_btn_UserFive = new GridBagConstraints();
		gbc_btn_UserFive.insets = new Insets(5, 0, 5, 0);
		gbc_btn_UserFive.gridx = 3;
		gbc_btn_UserFive.gridy = 0;
		panel_Btn.add(btn_UserFive, gbc_btn_UserFive);
		btn_UserFive.addActionListener(handler);

		btn_Cancle = new JButton("\u9000\u6B3E");
		GridBagConstraints gbc_btn_Cancle = new GridBagConstraints();
		gbc_btn_Cancle.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Cancle.gridx = 2;
		gbc_btn_Cancle.gridy = 1;
		panel_Btn.add(btn_Cancle, gbc_btn_Cancle);
		btn_Cancle.addActionListener(handler);

		btn_Admin = new JButton("\u767B\u5F55");
		GridBagConstraints gbc_btn_Admin = new GridBagConstraints();
		gbc_btn_Admin.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Admin.gridx = 3;
		gbc_btn_Admin.gridy = 1;
		panel_Btn.add(btn_Admin, gbc_btn_Admin);
		btn_Admin.addActionListener(handler);

		panel_Admin = new JPanel();
		panel_Admin.setBorder(new TitledBorder(null,
				"\u7BA1\u7406\u5458\u754C\u9762", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_Admin = new GridBagConstraints();
		gbc_panel_Admin.fill = GridBagConstraints.BOTH;
		gbc_panel_Admin.gridx = 0;
		gbc_panel_Admin.gridy = 2;
		getContentPane().add(panel_Admin, gbc_panel_Admin);
		GridBagLayout gbl_panel_Admin = new GridBagLayout();
		gbl_panel_Admin.columnWidths = new int[] { 130, 230, 0 };
		gbl_panel_Admin.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_Admin.columnWeights = new double[] { 0.0, 0.5,
				Double.MIN_VALUE };
		gbl_panel_Admin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_Admin.setLayout(gbl_panel_Admin);

		label = new JLabel("\u7CFB\u7EDF\u603B\u4F59\u989D\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_Admin.add(label, gbc_label);

		txt_SysSum = new JTextField();
		txt_SysSum.setEditable(false);
		GridBagConstraints gbc_txt_SysSum = new GridBagConstraints();
		gbc_txt_SysSum.insets = new Insets(0, 0, 5, 0);
		gbc_txt_SysSum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_SysSum.gridx = 1;
		gbc_txt_SysSum.gridy = 0;
		panel_Admin.add(txt_SysSum, gbc_txt_SysSum);
		txt_SysSum.setColumns(10);

		label_1 = new JLabel("\u7CFB\u7EDF\u4E00\u5143\u6570\u91CF\uFF1A");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_Admin.add(label_1, gbc_label_1);

		txt_SysOne = new JTextField();
		GridBagConstraints gbc_txt_SysOne = new GridBagConstraints();
		gbc_txt_SysOne.insets = new Insets(0, 0, 5, 0);
		gbc_txt_SysOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_SysOne.gridx = 1;
		gbc_txt_SysOne.gridy = 1;
		txt_SysOne.setToolTipText("���������޸ĵ�������������水ť���ϵͳ��һԪ�������޸ġ�");
		panel_Admin.add(txt_SysOne, gbc_txt_SysOne);
		txt_SysOne.setColumns(10);

		lblNewLabel = new JLabel("\u7CFB\u7EDF\u4E94\u5143\u6570\u91CF\uFF1A");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_Admin.add(lblNewLabel, gbc_lblNewLabel);

		txt_SysFive = new JTextField();
		GridBagConstraints gbc_txt_SysFive = new GridBagConstraints();
		gbc_txt_SysFive.insets = new Insets(0, 0, 5, 0);
		gbc_txt_SysFive.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_SysFive.gridx = 1;
		gbc_txt_SysFive.gridy = 2;
		txt_SysFive.setToolTipText("���������޸ĵ�������������水ť���ϵͳ��һԪ�������޸ġ�");
		panel_Admin.add(txt_SysFive, gbc_txt_SysFive);
		txt_SysFive.setColumns(10);

		btn_Save = new JButton("\u4FDD\u5B58");
		GridBagConstraints gbc_btn_Save = new GridBagConstraints();
		gbc_btn_Save.insets = new Insets(0, 0, 0, 5);
		gbc_btn_Save.gridx = 0;
		gbc_btn_Save.gridy = 3;
		panel_Admin.add(btn_Save, gbc_btn_Save);
		btn_Save.addActionListener(handler);

		btn_Logout = new JButton("\u9000\u51FA");
		GridBagConstraints gbc_btn_Logout = new GridBagConstraints();
		gbc_btn_Logout.gridx = 1;
		gbc_btn_Logout.gridy = 3;
		panel_Admin.add(btn_Logout, gbc_btn_Logout);
		btn_Logout.addActionListener(handler);
		panel_Admin.setVisible(false);

	}

	/**
	 * ��Ӧ��ť�¼�
	 */
	private ActionListener handler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn_UserOne) {
				userOneCount++;
				updateUserMoney();
			} else if (e.getSource() == btn_UserFive) {
				userFiveCount++;
				updateUserMoney();
			} else if (e.getSource() == btn_Buy) {
				// ����
				// ��ȡ�������Ʒ�ܼۣ�����ܼ۴��������Ǯ������ʾ�û�����Ͷ��Ǯ
				int needSum = getGoodSum();
				if (needSum > userMoneySum) {
					JOptionPane.showMessageDialog(null, "Ͷ��Ľ��С����Ҫ������Ʒ���ܼۣ�����Ͷ��"
							+ (needSum - userMoneySum) + "Ԫ��ȡ��һЩ��Ʒ��");
					reinitGoodCount();
					return;
				} else {
					// ������Ҫ�����Ǯ��
					int remain = userMoneySum - needSum;
					int remainFiveCount = remain / 5;
					int remainOneCount = remain % 5;
					// �޸�ϵͳǮ���ͼ���
					int sysRemain = sysOneCount + userOneCount - remainOneCount;
					if (sysRemain < 0) {
						JOptionPane.showMessageDialog(null,
								"��Ǹ��ϵͳ��û���㹻����Ǯ�����޸Ĺ�����Ʒ���˿��ʹ����Ǯ����");
						return;
					}
					sysOneCount = sysRemain;
					sysFiveCount = sysFiveCount + userFiveCount
							- remainFiveCount;
					sysMoneySum = sysOneCount + sysFiveCount * 5;

					// �޸���Ʒ������
					updateGoodCount();
					// ����������Ʒ�������Ǯ��
					String result = getBuyResult(remain);
					JOptionPane.showMessageDialog(null, result);
					// ���ó�ʼ״̬
					reinit();
					pnlAdminUpdate();
				}
			} else if (e.getSource() == btn_Cancle) {
				// �˿�
				updateUserMoney();
				if (userMoneySum > 0) {
					String remainResult = getRemianResult();
					JOptionPane.showMessageDialog(null, remainResult);
					reinit();
				} else {
					JOptionPane.showMessageDialog(null, "��Ͷ���Ǯ��Ϊ0���޷������˿������");
				}
			} else if (e.getSource() == btn_Show) {
				// ��ʾʣ����Ʒ��Ŀ
				showGoodCount();
			} else if (e.getSource() == btn_Admin) {
				String input = JOptionPane.showInputDialog("���������Ա���룬���ִ�Сд��");

				if (ADMIN.equals(input)) {
					// ��¼�ɹ�����ʾ����Ա���
					pnlAdminUpdate();
					panel_Admin.setVisible(true);
					repaint();
				} else {
					JOptionPane.showMessageDialog(null, "���������������޷��������Աҳ�档");
				}
			} else if (e.getSource() == btn_Save) {
				String oneStr = txt_SysOne.getText();
				int one = Integer.parseInt(oneStr);
				String fiveStr = txt_SysOne.getText();
				int five = Integer.parseInt(fiveStr);
				sysOneCount = one;
				sysFiveCount = five;
				sysMoneySum = sysOneCount + sysFiveCount * 5;
				txt_SysSum.setText(sysMoneySum + "");
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���ϵͳ�е������Ϊ��"
						+ sysMoneySum + "Ԫ��");
			} else if (e.getSource() == btn_Logout) {
				panel_Admin.setVisible(false);
				repaint();
			}
		}

	};

	/**
	 * ���¹���Ա�����Ϣ
	 */
	private void pnlAdminUpdate() {
		txt_SysOne.setText(sysOneCount + "");
		txt_SysFive.setText(sysFiveCount + "");
		txt_SysSum.setText((sysOneCount + sysFiveCount * 5) + "");
	}

	/**
	 * ��ʾ��Ʒ����
	 */
	protected void showGoodCount() {
		gp_coke.showRemain();
		gp_fanta.showRemain();
		gp_rtea.showRemain();
		gp_gtea.showRemain();
	}

	/**
	 * ��ȡ�˿���
	 * 
	 * @return
	 */
	protected String getRemianResult() {
		StringBuffer sb = new StringBuffer();
		sb.append("�˿�ɹ�����ȡ��");
		if (userOneCount > 0) {
			sb.append(userOneCount).append("��һԪӲ�ң�");
		}

		if (userFiveCount > 0) {
			sb.append(userFiveCount).append("����Ԫֽ�ң�");
		}

		return sb.toString();
	}

	/**
	 * ��ȡ�������Ʒ����
	 * 
	 * @param remain
	 * @return
	 */
	protected String getBuyResult(int remain) {
		StringBuffer sb = new StringBuffer();
		sb.append("����ɹ�����������");
		if (cokeCount > 0) {
			sb.append(cokeCount).append("ƿ").append(NAME_COKE).append("��");
		}
		if (fantaCount > 0) {
			sb.append(fantaCount).append("ƿ").append(NAME_FANTA).append("��");
		}
		if (rteaCount > 0) {
			sb.append(rteaCount).append("ƿ").append(NAME_RTEA).append("��");
		}
		if (gteaCount > 0) {
			sb.append(gteaCount).append("ƿ").append(NAME_GTEA).append("��");
		}
		if (remain > 0) {
			sb.append("������" + remain + "Ԫ��");
		}
		return sb.toString();
	}

	/**
	 * ������Ʒ����
	 */
	protected void updateGoodCount() {
		if (cokeCount > 0) {
			COUNT_COKE -= cokeCount;
			gp_coke.setGoodCount(COUNT_COKE);
			gp_coke.reInit();
		}
		if (fantaCount > 0) {
			COUNT_FANTA -= fantaCount;
			gp_fanta.setGoodCount(COUNT_FANTA);
			gp_fanta.reInit();
		}
		if (rteaCount > 0) {
			COUNT_RTEA -= rteaCount;
			gp_rtea.setGoodCount(COUNT_RTEA);
			gp_rtea.reInit();
		}
		if (gteaCount > 0) {
			COUNT_GTEA -= gteaCount;
			gp_gtea.setGoodCount(COUNT_GTEA);
			gp_gtea.reInit();
		}
	}

	/**
	 * ������Ʒѡ����Ϊ0������ʼ��Ͷ��Ǯ������0��
	 */
	protected void reinit() {
		reinitGoodCount();
		userOneCount = 0;
		userFiveCount = 0;
		userMoneySum = 0;
		txt_UserMoney.setText(0 + "");
	}

	/**
	 * ����������Ʒ��ѡ������Ϊ0
	 */
	protected void reinitGoodCount() {
		cokeCount = 0;
		fantaCount = 0;
		rteaCount = 0;
		gteaCount = 0;
	}

	/**
	 * ��ȡ������Ʒ��Ҫ����Ǯ��
	 * 
	 * @return
	 */
	protected int getGoodSum() {
		int sum = 0;
		if (gp_coke.isSelected()) {
			cokeCount++;
			sum += cokeCount * PRICE_COKE;
		}
		if (gp_fanta.isSelected()) {
			fantaCount++;
			sum += fantaCount * PRICE_FANTA;
		}
		if (gp_rtea.isSelected()) {
			rteaCount++;
			sum += rteaCount * PRICE_RTEA;
		}
		if (gp_gtea.isSelected()) {
			gteaCount++;
			sum += gteaCount * PRICE_GTEA;
		}
		return sum;
	}

	/**
	 * �����û�Ͷ���Ǯ��
	 */
	protected void updateUserMoney() {
		userMoneySum = (userOneCount + userFiveCount * 5);
		txt_UserMoney.setText(userMoneySum + "");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				AutoSaleMachine asm = new AutoSaleMachine();
				asm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				asm.setSize(500, 600);
				asm.setResizable(false);
				asm.setLocationRelativeTo(null);
				asm.setVisible(true);
			}
		});
	}
}

/**
 * @author th ��Ʒ��壬������Ʒ��ͼƬ�����ƣ��Լ��Ƿ�ѡ�еĸ�ѡ��
 */
class GoodPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4364216395712746083L;
	private static final String MONEY_UNIT = "Ԫ";
	private static final String TIP = "����ͼƬ����ѡ�������ȡ������";

	private String picPath;
	private String name;
	private JTextField txt_Price;
	private int price;
	private JLabel lbl_Pic;
	private JCheckBox cbox_Select;
	private int goodId;
	private int goodCount;
	private JLabel lbl_Remain;
	private JTextField txt_Remain;

	GoodPanel(String picPath, int price, String name, int goodId, int goodCount) {
		this.picPath = picPath;
		this.price = price;
		this.name = name;
		this.goodId = goodId;
		this.goodCount = goodCount;
		this.setBorder(new CompoundBorder(null, new LineBorder(new Color(255,
				0, 0), 2)));
		this.setLayout(new BorderLayout(0, 0));
		lbl_Pic = new JLabel();
		this.add(lbl_Pic, BorderLayout.CENTER);
		lbl_Pic.setToolTipText(TIP);
		// ����ͼƬ����ѡ�������ȡ������
		lbl_Pic.addMouseListener(mouseAdapter);

		JPanel panel_Prop = new JPanel();
		this.add(panel_Prop, BorderLayout.SOUTH);

		JLabel lbl_Name = new JLabel(this.name);
		panel_Prop.add(lbl_Name);

		txt_Price = new JTextField();
		txt_Price.setEditable(false);
		panel_Prop.add(txt_Price);
		txt_Price.setColumns(2);
		txt_Price.setText(this.price + MONEY_UNIT);

		cbox_Select = new JCheckBox("\u8D2D\u4E70");
		if (this.goodCount <= 0) {
			cbox_Select.setSelected(false);
		}
		panel_Prop.add(cbox_Select);

		lbl_Remain = new JLabel("ʣ�ࣺ");
		panel_Prop.add(lbl_Remain);
		txt_Remain = new JTextField();
		txt_Remain.setEditable(false);
		panel_Prop.add(txt_Remain);
		txt_Remain.setColumns(2);
		lbl_Remain.setVisible(false);
		txt_Remain.setVisible(false);
		initPic();
	}

	/**
	 * ͼƬ����Ӧ�¼�
	 */
	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (goodCount > 0)
				cbox_Select.setSelected(!cbox_Select.isSelected());
		}
	};

	/**
	 * ������Ʒ����
	 * 
	 * @param goodCount
	 */
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
		if (this.goodCount <= 0) {
			cbox_Select.setEnabled(false);
		}
	}

	/**
	 * ��ʼ����ʾ����ƷͼƬ
	 */
	private void initPic() {
		if (this.picPath == null) {
			return;
		}
		new Thread() {
			@Override
			public void run() {
				int width = getWidth();
				while (width == 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					width = getWidth();
				}
				int height = getHeight();
				File input = new File(picPath);
				if (!input.exists()) {
					return;
				}
				try {
					BufferedImage image = ImageIO.read(input);
					ImageIcon bgIcon = new ImageIcon(image.getScaledInstance(
							width, height, Image.SCALE_DEFAULT));
					lbl_Pic.setIcon(bgIcon);
					repaint();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	/**
	 * �Ƿ������Ʒ
	 * 
	 * @return
	 */
	public boolean isSelected() {
		return cbox_Select.isSelected();
	}

	/**
	 * ��ȡ��Ʒ���
	 * 
	 * @return
	 */
	public int getGoodId() {
		return goodId;
	}

	/**
	 * ������Ϻ���Ҫ����
	 */
	public void reInit() {
		cbox_Select.setSelected(false);
	}

	/**
	 * ��ʾ��Ʒ����
	 */
	public void showRemain() {
		new Thread() {
			@Override
			public void run() {
				lbl_Remain.setVisible(true);
				txt_Remain.setText(goodCount + "");
				txt_Remain.setVisible(true);
				repaint();
				try {
					Thread.sleep(5000);
					lbl_Remain.setVisible(false);
					txt_Remain.setVisible(false);
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
