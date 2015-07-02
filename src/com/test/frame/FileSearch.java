package com.test.frame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class FileSearch extends JFrame {
	private static final long serialVersionUID = -497231270990815830L;
	/**
	 * 常用的后缀名数组
	 */
	private static final String[] SUFFIX = new String[] { ".txt", ".doc",
			".gif", ".jpg", ".bp3", ".ppt", ".zip" };
	private static final String[] NULL_DATA = new String[] {};
	private JTextField txt_Dir;
	private JTextField txt_Search;
	@SuppressWarnings("rawtypes")
	private JComboBox cbox_End;
	private JButton btn_Dir;
	private JButton btn_Search;
	@SuppressWarnings("rawtypes")
	private JList jList;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FileSearch() {
		setTitle("\u5728\u6307\u5B9A\u8303\u56F4\u5185\u641C\u7D22\u6587\u4EF6");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.5, 0.0, 0.5, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lbl_Dir = new JLabel("\u6587\u4EF6\u5730\u5740\uFF1A");
		GridBagConstraints gbc_lbl_Dir = new GridBagConstraints();
		gbc_lbl_Dir.anchor = GridBagConstraints.EAST;
		gbc_lbl_Dir.insets = new Insets(10, 10, 5, 5);
		gbc_lbl_Dir.gridx = 0;
		gbc_lbl_Dir.gridy = 0;
		panel.add(lbl_Dir, gbc_lbl_Dir);

		txt_Dir = new JTextField();
		GridBagConstraints gbc_txt_Dir = new GridBagConstraints();
		gbc_txt_Dir.insets = new Insets(10, 0, 5, 5);
		gbc_txt_Dir.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Dir.gridx = 1;
		gbc_txt_Dir.gridy = 0;
		gbc_txt_Dir.gridwidth = 3;
		panel.add(txt_Dir, gbc_txt_Dir);
		txt_Dir.setColumns(10);

		btn_Dir = new JButton("\u9009\u62E9\u5730\u5740");
		GridBagConstraints gbc_btn_Dir = new GridBagConstraints();
		gbc_btn_Dir.insets = new Insets(10, 0, 5, 5);
		gbc_btn_Dir.gridx = 4;
		gbc_btn_Dir.gridy = 0;
		panel.add(btn_Dir, gbc_btn_Dir);

		JLabel lbl_Search = new JLabel("\u6587\u4EF6\u540D\uFF1A");
		GridBagConstraints gbc_lbl_Search = new GridBagConstraints();
		gbc_lbl_Search.anchor = GridBagConstraints.EAST;
		gbc_lbl_Search.insets = new Insets(5, 10, 5, 5);
		gbc_lbl_Search.gridx = 0;
		gbc_lbl_Search.gridy = 1;
		panel.add(lbl_Search, gbc_lbl_Search);

		txt_Search = new JTextField();
		GridBagConstraints gbc_txt_Search = new GridBagConstraints();
		gbc_txt_Search.insets = new Insets(5, 0, 5, 5);
		gbc_txt_Search.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Search.gridx = 1;
		gbc_txt_Search.gridy = 1;
		panel.add(txt_Search, gbc_txt_Search);
		txt_Search.setColumns(10);

		JLabel lbl_End = new JLabel("\u540E\u7F00\uFF1A");
		GridBagConstraints gbc_lbl_End = new GridBagConstraints();
		gbc_lbl_End.anchor = GridBagConstraints.EAST;
		gbc_lbl_End.insets = new Insets(5, 5, 5, 5);
		gbc_lbl_End.gridx = 2;
		gbc_lbl_End.gridy = 1;
		panel.add(lbl_End, gbc_lbl_End);

		cbox_End = new JComboBox();
		GridBagConstraints gbc_cbox_End = new GridBagConstraints();
		gbc_cbox_End.insets = new Insets(5, 0, 5, 5);
		gbc_cbox_End.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbox_End.gridx = 3;
		gbc_cbox_End.gridy = 1;
		panel.add(cbox_End, gbc_cbox_End);
		cbox_End.setModel(new DefaultComboBoxModel(SUFFIX));

		btn_Search = new JButton("\u641C\u7D22");
		GridBagConstraints gbc_btn_Search = new GridBagConstraints();
		gbc_btn_Search.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_Search.anchor = GridBagConstraints.EAST;
		gbc_btn_Search.insets = new Insets(5, 0, 5, 5);
		gbc_btn_Search.gridx = 4;
		gbc_btn_Search.gridy = 1;
		panel.add(btn_Search, gbc_btn_Search);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(10, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);

		jList = new JList(new DefaultListModel());
		jList.setBorder(new TitledBorder(null, "\u641C\u7D22\u7ED3\u679C",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(jList);
		btn_Dir.addActionListener(btnHandler);
		btn_Search.addActionListener(btnHandler);
	}

	private ActionListener btnHandler = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn_Dir) {
				String strDir = txt_Dir.getText();
				// 弹出文件选择器，只能选择目录
				JFileChooser fileChooser = new JFileChooser(strDir);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int mode = fileChooser.showOpenDialog(null);
				if (mode == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if (file != null) {
						txt_Dir.setText(file.getPath());
					}
				}
			} else if (e.getSource() == btn_Search) {
				// 执行查找工作
				doSearch();
			}
		}
	};

	/**
	 * 执行查找，并更新列表
	 */
	@SuppressWarnings("unchecked")
	protected void doSearch() {
		String strDir = txt_Dir.getText();
		if (strDir == null || strDir.equals("")) {
			JOptionPane.showMessageDialog(null, "文件地址为空，请选择文件地址！");
			return;
		}
		File fileDir = new File(strDir);
		if (!fileDir.exists()) {
			JOptionPane.showMessageDialog(null, "文件地址无效，请重新选择文件地址！");
			return;
		}
		String searchName = txt_Search.getText();
		if (searchName == null || searchName.equals("")) {
			JOptionPane.showMessageDialog(null, "文件名为空，请输入文件名！");
			return;
		}
		String suffix = cbox_End.getSelectedItem().toString();
		String[] resultNames = getRightFileNames(fileDir, searchName, suffix);
		if (resultNames != null) {
			jList.setListData(resultNames);
		} else {
			jList.setListData(NULL_DATA);
		}
	}

	/**
	 * 根据传入的文件名和后缀在指定的目录下搜索符合条件的文件名
	 * 
	 * @param fileDir
	 * @param searchName
	 * @param suffix2
	 * @return
	 */
	private String[] getRightFileNames(File fileDir, String searchName,
			final String suffix2) {
		String[] fileNames = fileDir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(suffix2);
			}

		});
		if (fileNames == null || fileNames.length == 0) {
			JOptionPane.showMessageDialog(null, "文件地址中不存在该类型文件！");
			return null;
		}
		if (searchName.equals("*")) {
			// 处理只有一个*号的文件，直接返回即可
			return fileNames;
		} else if (searchName.equals("?")) {
			// 处理只有一个?号的文件，返回文件名长度为1的文件
			return lengthOne(fileDir, suffix2);
		} else if (searchName.contains("*") || searchName.contains("?")) {
			// 需要根据正则来进行匹配
			searchName = searchName.replaceAll("\\*", "\\.+");
			searchName = searchName.replaceAll("\\?", "\\.");
			return regexNameResult(fileDir, suffix2, searchName);
		} else {
			return fullNameResult(fileDir, suffix2, searchName);
		}
	}

	/**
	 * 正则匹配
	 * 
	 * @param fileDir
	 * @param suffix2
	 * @param searchName
	 * @return
	 */
	private String[] regexNameResult(File fileDir, final String suffix2,
			final String searchName) {
		final Pattern pattern = Pattern.compile(searchName + suffix2);
		String[] fileNames = fileDir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(suffix2)
						&& pattern.matcher(name).matches();
			}

		});
		return fileNames;
	}

	/**
	 * 全匹配
	 * 
	 * @param fileDir
	 * @param suffix2
	 * @param searchName
	 * @return
	 */
	private String[] fullNameResult(File fileDir, final String suffix2,
			final String searchName) {
		String[] fileNames = fileDir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(suffix2)
						&& name.equals(searchName + suffix2);
			}

		});
		return fileNames;
	}

	/**
	 * 返回文件名长度为1的值
	 * 
	 * @param fileDir
	 * @param suffix2
	 * @return
	 */
	private String[] lengthOne(File fileDir, final String suffix2) {
		String[] fileNames = fileDir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(suffix2)
						&& name.length() == 1 + suffix2.length();
			}

		});
		return fileNames;
	}

	public static void main(String[] args) {
		final FileSearch fileSearch = new FileSearch();
		fileSearch.setSize(500, 500);
		fileSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileSearch.setLocationRelativeTo(null);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				fileSearch.setVisible(true);
			}
		});
	}

}
