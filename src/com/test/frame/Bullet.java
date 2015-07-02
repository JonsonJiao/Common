/**
 * 
 */
package com.test.frame;

class Bullet implements Runnable {
	int x;
	int y;
	int direct;
	int speed = 1;
	boolean isAlive = true;

	public Bullet(int x, int y, int direct) {
		this.x = x;
		this.y = y;
		this.direct = direct;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (direct) {
			case 0:
				y -= speed;
				break;
			case 1:
				y += speed;
				break;
			case 2:
				x -= speed;
				break;
			case 3:
				x += speed;
				break;
			}
			// 子弹何时死亡?
			// 判断子弹到达边界
			if (x < -1 || x > 501 || y < -1 || y > 501) {
				this.isAlive = false;
				break;
			}
		}
	}
}