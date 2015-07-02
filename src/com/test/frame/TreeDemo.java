package com.test.frame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * 通过选择路径，列出改路径下的所有文件夹和文件，以Tree的形式列出
 * 
 * @author th
 * 
 */
public class TreeDemo extends JFrame {

	private static final long serialVersionUID = 4150645958463887567L;
	private JTextField txt_Path;
	private JTree tree;

	public TreeDemo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel_FileSelect = new JPanel();
		GridBagConstraints gbc_panel_FileSelect = new GridBagConstraints();
		gbc_panel_FileSelect.insets = new Insets(0, 0, 5, 0);
		gbc_panel_FileSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_FileSelect.gridx = 0;
		gbc_panel_FileSelect.gridy = 0;
		getContentPane().add(panel_FileSelect, gbc_panel_FileSelect);
		GridBagLayout gbl_panel_FileSelect = new GridBagLayout();
		gbl_panel_FileSelect.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_FileSelect.rowHeights = new int[] { 0, 0 };
		gbl_panel_FileSelect.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_FileSelect.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_FileSelect.setLayout(gbl_panel_FileSelect);

		JLabel lbl_Path = new JLabel("\u6587\u4EF6\u8DEF\u5F84\uFF1A");
		GridBagConstraints gbc_lbl_Path = new GridBagConstraints();
		gbc_lbl_Path.anchor = GridBagConstraints.WEST;
		gbc_lbl_Path.insets = new Insets(10, 10, 5, 5);
		gbc_lbl_Path.gridx = 0;
		gbc_lbl_Path.gridy = 0;
		panel_FileSelect.add(lbl_Path, gbc_lbl_Path);

		txt_Path = new JTextField();
		GridBagConstraints gbc_txt_Path = new GridBagConstraints();
		gbc_txt_Path.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Path.anchor = GridBagConstraints.WEST;
		gbc_txt_Path.insets = new Insets(10, 0, 5, 5);
		gbc_txt_Path.gridx = 1;
		gbc_txt_Path.gridy = 0;
		panel_FileSelect.add(txt_Path, gbc_txt_Path);
		txt_Path.setColumns(10);

		JButton btn_Path = new JButton("\u6D4F\u89C8...");
		GridBagConstraints gbc_btn_Path = new GridBagConstraints();
		gbc_btn_Path.insets = new Insets(10, 0, 5, 5);
		gbc_btn_Path.anchor = GridBagConstraints.NORTHWEST;
		gbc_btn_Path.gridx = 2;
		gbc_btn_Path.gridy = 0;
		panel_FileSelect.add(btn_Path, gbc_btn_Path);

		JPanel panel_Tree = new JPanel();
		GridBagConstraints gbc_panel_Tree = new GridBagConstraints();
		gbc_panel_Tree.fill = GridBagConstraints.BOTH;
		gbc_panel_Tree.gridx = 0;
		gbc_panel_Tree.gridy = 1;
		getContentPane().add(panel_Tree, gbc_panel_Tree);
		panel_Tree.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPanel = new JScrollPane();
		tree = new JTree();
		scrollPanel.setViewportView(tree);
		panel_Tree.add(scrollPanel);

		clearTree();
		btn_Path.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String curDir = txt_Path.getText();
				JFileChooser fileChooser = new JFileChooser(curDir);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int approve = fileChooser.showOpenDialog(null);
				if (approve == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if (file != null) {
						txt_Path.setText(file.getPath());
						updateTree(file);
					}
				}
			}

			/**
			 * 更新JTree
			 * 
			 * @param file
			 */
			private void updateTree(File file) {
				// TODO Auto-generated method stub
				clearTree();
				DefaultMutableTreeNode root = new DefaultMutableTreeNode(file);
				long l = System.currentTimeMillis();
				searchRoot(file, root);
				System.out.println("耗时：" + (System.currentTimeMillis() - l));
				DefaultTreeModel model = new DefaultTreeModel(root);
				tree.setModel(model);
			}

			private void searchRoot(File file, DefaultMutableTreeNode root) {
				// TODO Auto-generated method stub
				File[] files = file.listFiles();
				if (files == null) {
					return;
				}
				for (File _file : files) {
					DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(
							_file.getName());
					root.add(newChild);
					if (_file.isDirectory()) {
						searchRoot(_file, newChild);
					}
				}
			}
		});

	}

	private void clearTree() {
		// TODO Auto-generated method stub
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		if (model == null) {
			return;
		}
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		root.removeAllChildren();
		tree.setModel(null);
		tree.updateUI();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				TreeDemo treeDemo = new TreeDemo();
				treeDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				treeDemo.setTitle("文件列表");
				treeDemo.setSize(400, 400);
				treeDemo.setLocationRelativeTo(null);
				treeDemo.setVisible(true);
			}
		});
	}
}
