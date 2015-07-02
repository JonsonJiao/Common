/**
 * 
 */
package com.test.frame;

//坦克类
class Tank {
	// 坦克的种类
	int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	// 坦克的速度
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
	// 坦克的横纵坐标
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
