/**
 * 
 */
package com.test.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -225712417638239314L;
	// ����һ����ҵ�̹��
	MyTank mytank = null;
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	// ���屬ըЧ������
	Vector<Boom> boom = new Vector<Boom>();
	int enSize = 8;
	// ��������ͼƬ,����ͼƬ���һ�α�ը
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;

	// ���캯��
	public MyPanel() {
		mytank = new MyTank(100, 250);
		mytank.setType(0);
		for (int i = 0; i < enSize; i++) {
			EnemyTank et = new EnemyTank((i + 1) * 50, 0);
			et.setType(1);
			et.setDirect(1);
			et.setType(1);
			ets.add(et);
		}

//		try {
//			image1 = ImageIO.read(Panel.class.getResource("/1.png"));
//			image2 = ImageIO.read(Panel.class.getResource("/2.png"));
//			image3 = ImageIO.read(Panel.class.getResource("/3.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// ��ʼ��ͼƬ
		image1 = Toolkit.getDefaultToolkit().getImage(
				Panel.class.getResource("/1.png"));
		image2 = Toolkit.getDefaultToolkit().getImage(
				Panel.class.getResource("/2.png"));
		image3 = Toolkit.getDefaultToolkit().getImage(
		Panel.class.getResource("/3.png"));

	}

	public BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
			int transparency = Transparency.OPAQUE;
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null),
					image.getHeight(null), transparency);
		} catch (HeadlessException e) {
			// The system does not have a screen
		}
		if (bimage == null) {
			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			bimage = new BufferedImage(image.getWidth(null),
					image.getHeight(null), type);
		}
		// Copy image to buffered image
		Graphics g = bimage.createGraphics();
		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bimage;
	}

	public void hittank(Bullet b, EnemyTank et) {
		// �жϸ�̹�˵ķ���
		switch (et.direct) {
		// �����ϻ�����
		case 0:
		case 1:
			if (b.x > et.x && b.x < et.x + 20 && b.y > et.y && b.y < et.y + 30) {
				// ����
				// �ӵ����� ̹������
				b.isAlive = false;
				et.isLive = false;
				// ����һ����ըЧ��������boom
				Boom bom = new Boom(et.x, et.y);
				boom.add(bom);
			}
		case 2:
		case 3:
			if (b.x > et.x - 5 && b.x < et.x + 25 && b.y > et.y + 5
					&& b.y < et.y + 25) {
				// ����
				b.isAlive = false;
				et.isLive = false;
				Boom bom = new Boom(et.x, et.y);
				boom.add(bom);
			}
		}
	}

	// �����������ң���Ӧ0123
	public void paint(Graphics g) {

		super.paint(g);
//		System.out.println("xx");
		g.fillRect(0, 0, 500, 500);
		this.drawTank(this.mytank.getX(), this.mytank.getY(), g,
				this.mytank.getDirect(), this.mytank.getType());
		// ��ss�л��������ӵ�
		for (int i = 0; i < this.mytank.ss.size(); i++) {
			Bullet b = mytank.ss.get(i);
			if (b != null && b.isAlive == true) {
				g.drawRect(b.x, b.y, 1, 1);
			}
			if (b.isAlive == false) {
				// ��ss��ɾ�����ӵ�
				mytank.ss.remove(b);
			}
		}
		for (int i = 0; i < ets.size(); i++) {
			EnemyTank et = ets.get(i);
			if (et.isLive) {
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(),
						et.getType());
			}
		}
		// ������ը
//		System.out.println(boom.size());
		for (int j = 0; j < boom.size(); j++) {
			Boom bom = boom.get(j);
			if (bom.life > 6) {
				System.out.println("width1:"+image1.getWidth(this));
				g.drawImage(image1, bom.x, bom.y, 30, 30, this);
			} else if (bom.life > 3) {
				System.out.println("width2:"+image2.getWidth(this));
				g.drawImage(image2, bom.x, bom.y, 30, 30, this);
			} else {
				System.out.println("width3:"+image3.getWidth(this));
				g.drawImage(image3, bom.x, bom.y, 30, 30, this);
			}
			// �ñ�ը����
			bom.lifeDown();
			if (bom.life == 0) {
				boom.remove(bom);
			}
		}
	}

	// ����̹�˵ĺ���
	public void drawTank(int x, int y, Graphics g, int direct, int type) {
		switch (type) {
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		switch (direct) {
		case 0:// ������
			g.fill3DRect(x, y, 5, 30, false);

			g.fill3DRect(x + 15, y, 5, 30, false);

			g.fill3DRect(x + 5, y + 5, 10, 20, false);

			g.fillOval(x + 5, y + 10, 10, 10);

			g.drawLine(x + 10, y + 15, x + 10, y);

			g.drawOval(x + 5, y + 10, 10, 10);
			break;
		case 3:// ������
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			g.fill3DRect(x, y + 10, 20, 10, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y + 15, x + 25, y + 15);
			g.drawOval(x + 5, y + 10, 10, 10);
			break;
		case 1:// ������
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x + 15, y, 5, 30, false);
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y + 15, x + 10, y + 30);
			g.drawOval(x + 5, y + 10, 10, 10);
			break;
		case 2:// ������
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			g.fill3DRect(x, y + 10, 20, 10, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y + 15, x - 5, y + 15);
			g.drawOval(x + 5, y + 10, 10, 10);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.mytank.setDirect(0);

			this.repaint();
			this.mytank.moveUp();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.mytank.setDirect(1);

			this.repaint();
			this.mytank.moveDown();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.mytank.setDirect(2);

			this.repaint();
			this.mytank.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.mytank.setDirect(3);

			this.repaint();
			this.mytank.moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (this.mytank.ss.size() <= 4) {
				this.mytank.fire();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// ÿ��100�����ػ�
		while (true) {
//			System.out.println("sleep");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// �ж��Ƿ����
			for (int i = 0; i < mytank.ss.size(); i++) {
				Bullet mb = mytank.ss.get(i);
				// �ж��ӵ��Ƿ���Ч
				if (mb.isAlive) {
					// ȡ��ÿһ��̹�ˣ����ӵ��ж��Ƿ����
					for (int j = 0; j < ets.size(); j++) {
						// ȡ��̹��
						EnemyTank et = ets.get(j);
						if (et.isLive) {
							this.hittank(mb, et);
						}
					}
				}
			}
			this.repaint();

		}
	}

}
