/**
 * 
 */
package com.test.frame;

//̹����
class Tank {
	// ̹�˵�����
	int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	// ̹�˵��ٶ�
	int speed = 1;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	int direct = 0;
	// ̹�˵ĺ�������
	int x = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int y = 0;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
