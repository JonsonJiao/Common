/**
 * 
 */
package com.test.frame;

import java.util.Vector;

class MyTank extends Tank {
	Bullet mb = null;

	public MyTank(int x, int y) {
		super(x, y);
	}

	Vector<Bullet> ss = new Vector<Bullet>();

	// ¿ª»ðÄÜÁ¦
	public void fire() {

		switch (this.direct) {
		case 0:
			mb = new Bullet(this.getX() + 10, this.getY(), 0);
			ss.add(mb);
			break;
		case 1:
			mb = new Bullet(this.getX() + 10, this.getY() + 30, 1);
			ss.add(mb);
			break;
		case 2:
			mb = new Bullet(this.getX() - 5, this.getY() + 15, 2);
			ss.add(mb);
			break;
		case 3:
			mb = new Bullet(this.getX() + 25, this.getY() + 15, 3);
			ss.add(mb);
			break;
		}
		Thread t = new Thread(mb);
		t.start();
	}

	public void moveUp() {
		y -= speed;
	}

	public void moveRight() {
		x += speed;
	}

	public void moveDown() {
		y += speed;

	}

	public void moveLeft() {
		x -= speed;
	}
}
