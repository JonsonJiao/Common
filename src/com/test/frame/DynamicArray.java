package com.test.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DynamicArray extends JFrame {
	private static final long serialVersionUID = -4399228578353014409L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynamicArray frame = new DynamicArray();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private ArrayList<String> arraylist = new ArrayList<String>();

	@SuppressWarnings("rawtypes")
	public DynamicArray() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(25, 82, 198, 155);
		contentPane.add(list);

		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setBounds(25, 20, 65, 30);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(104, 23, 121, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("���ѧ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ִ�ж���
				textField.requestFocusInWindow();
				textField.selectAll();// ѡ���ı����ı�׼���´�����
				String text = textField.getText();// ��ȡ�û���������
				if (text.isEmpty())// ����Ϊ�������������
					return;
				arraylist.add(text);// ��������ӵ����鼯����
				// replaceModel();// �����鼯����������ʾ�������б�ؼ���
			}
		});
		btnNewButton.setBounds(300, 27, 93, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("ɾ��ѧ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ִ�ж���

			}
		});
		btnNewButton_1.setBounds(300, 94, 93, 23);
		contentPane.add(btnNewButton_1);

		// ��������
		/** private void replaceModel() **/

	}
}