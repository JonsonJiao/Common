/**
 * 
 */
package com.test.grads;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jiaoqishun 2015-6-5 下午4:25:44
 */
public class FindText extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -650030824256459496L;
	private JTextField txt_Search;

	public FindText() {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lbl_Search = new JLabel(
				"\u8F93\u5165\u8981\u67E5\u627E\u7684\u5185\u5BB9\uFF1A");
		GridBagConstraints gbc_lbl_Search = new GridBagConstraints();
		gbc_lbl_Search.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Search.anchor = GridBagConstraints.EAST;
		gbc_lbl_Search.gridx = 0;
		gbc_lbl_Search.gridy = 0;
		panel.add(lbl_Search, gbc_lbl_Search);

		txt_Search = new JTextField();
		GridBagConstraints gbc_txt_Search = new GridBagConstraints();
		gbc_txt_Search.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Search.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Search.gridx = 1;
		gbc_txt_Search.gridy = 0;
		panel.add(txt_Search, gbc_txt_Search);
		txt_Search.setColumns(10);

		JButton btn_Search = new JButton("\u5F00\u59CB");
		GridBagConstraints gbc_btn_Search = new GridBagConstraints();
		gbc_btn_Search.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Search.gridx = 2;
		gbc_btn_Search.gridy = 0;
		panel.add(btn_Search, gbc_btn_Search);

		final JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		panel.add(textArea, gbc_textArea);

		setTextAreaContent(textArea);

		btn_Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String findStr = txt_Search.getText();
				if ("".equals(findStr)) {
					JOptionPane.showMessageDialog(null, "查找文本为空，请重新输入。");
					return;
				} else {
					findText(findStr, textArea);
				}
			}
		});

	}

	/**
	 * @param findStr
	 * @param textArea
	 */
	protected void findText(String findStr, JTextArea textArea) {
		String textAreaText = textArea.getText();
		if (textAreaText == null || "".equals(textAreaText)) {
			JOptionPane.showMessageDialog(null, "文本域内容为空，请重新输入。");
			return;
		} else {
			int fromIndex = 0;
			int count = 0;
			int index = textAreaText.indexOf(findStr, fromIndex);
			while(index>=0){
				count++;
				index = textAreaText.indexOf(findStr, index+1);
			}
			if (count > 0) {
				JOptionPane.showMessageDialog(null, "查找成功，共找到"+count+"处。");
			}else{
				JOptionPane.showMessageDialog(null, "文本域中不存在该词汇。");
			}
		}
	}

	/**
	 * 设置JTextArea中的内容
	 */
	private void setTextAreaContent(JTextArea textArea) {
		textArea.setText("白日依山尽，\r\n黄河入海流；\r\n欲穷千里目，\r\n更上一层楼");
	}

	public static void main(String[] args) {
		FindText findText = new FindText();
		findText.setTitle("查找文本样例");
		findText.setSize(300, 300);
		findText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		findText.setLocationRelativeTo(null);
		findText.setVisible(true);
	}
}
