package com.test.frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ButtonIconDemo extends JFrame {

	private static final long serialVersionUID = 3941841604512093907L;

	public ButtonIconDemo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel label = new JLabel(
				"\u9ED8\u8BA4\u6309\u94AE\uFF1A\u5782\u76F4\u6C34\u5E73\u5C45\u4E2D");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		getContentPane().add(label, gbc_label);

		JButton btnNewButton = new JButton("有图标");
		ImageIcon defaultIcon = new ImageIcon(
				"D:\\svn\\Common\\Common\\photos\\filesave.gif");
		btnNewButton.setIcon(defaultIcon);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setVerticalTextPosition(SwingConstants.CENTER);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);

		JLabel label_1 = new JLabel(
				"\u9ED8\u8BA4\u6309\u94AE\uFF1A\u5782\u76F4\u9760\u4E0B\u6C34\u5E73\u5C45\u4E2D");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		getContentPane().add(label_1, gbc_label_1);

		JButton btnNewButton_1 = new JButton("有图标");
		btnNewButton_1.setIcon(defaultIcon);
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel label_2 = new JLabel(
				"\u9ED8\u8BA4\u6309\u94AE\uFF1A\u5782\u76F4\u5C45\u4E2D\u6C34\u5E73\u9760\u5DE6");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		getContentPane().add(label_2, gbc_label_2);

		JButton button = new JButton("\u6709\u56FE\u6807");
		button.setIcon(defaultIcon);
		button.setVerticalTextPosition(SwingConstants.CENTER);
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		getContentPane().add(button, gbc_button);
		JLabel label_3 = new JLabel("\u81EA\u5B9A\u4E49\u6309\u94AE");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		getContentPane().add(label_3, gbc_label_3);

		JButton button3 = new IconButton(
				"D:\\svn\\Common\\Common\\photos\\filesave.gif",
				"\u6709\u56FE\u6807");
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.insets = new Insets(0, 0, 5, 0);
		gbc_button3.gridx = 1;
		gbc_button3.gridy = 3;
		getContentPane().add(button3, gbc_button3);

		JLabel label_4 = new JLabel("\u81EA\u5B9A\u4E49\u6309\u94AE");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		getContentPane().add(label_4, gbc_label_4);

		JButton button_1 = new IconButton(null, "\u65E0\u56FE\u6807");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 4;
		getContentPane().add(button_1, gbc_button_1);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ButtonIconDemo btnIconDemo = new ButtonIconDemo();
				btnIconDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				btnIconDemo.setLocationRelativeTo(null);
				btnIconDemo.setSize(400, 400);
				btnIconDemo.setTitle("带图标的按钮");
				btnIconDemo.setVisible(true);
			}
		});
	}
}

/**
 * @author th 带图标的button，需要传入图片的路径进行初始化，会根据button的大小对图片进行缩放，以button的宽高最小值进行缩放
 */
class IconButton extends JButton {
	private static final long serialVersionUID = -3398789452084817273L;

	private ImageIcon icon = null;

	public IconButton(String imgPath, String text) {
		initIcon(imgPath);
		this.setText(text);
		this.setIcon(icon);
	}

	private void initIcon(final String imgPath) {
		new Thread() {
			@Override
			public void run() {
				if (imgPath != null) {
					int width2 = getWidth();
					while (width2 == 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						width2 = getWidth();
					}
					int height2 = getHeight();
					int length = width2 < height2 ? width2 : height2;
					length -= getInsets().top * 2;
					try {
						BufferedImage image = ImageIO.read(new File(imgPath));
						Image img = image.getScaledInstance(length, length,
								Image.SCALE_DEFAULT);
						icon = new ImageIcon(img);
						updateIcon();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	protected void updateIcon() {
		this.setIcon(icon);
		this.validate();
	}

}
