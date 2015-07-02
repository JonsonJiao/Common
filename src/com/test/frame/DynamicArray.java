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

		JButton btnNewButton = new JButton("添加学生");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 执行动作
				textField.requestFocusInWindow();
				textField.selectAll();// 选择文本框文本准备下次输入
				String text = textField.getText();// 获取用户输入姓名
				if (text.isEmpty())// 过滤为输入姓名的情况
					return;
				arraylist.add(text);// 把姓名添加到数组集合中
				// replaceModel();// 把数组集合中内容显示到界面列表控件中
			}
		});
		btnNewButton.setBounds(300, 27, 93, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("删除学生");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 执行动作

			}
		});
		btnNewButton_1.setBounds(300, 94, 93, 23);
		contentPane.add(btnNewButton_1);

		// 后续代码
		/** private void replaceModel() **/

	}
}