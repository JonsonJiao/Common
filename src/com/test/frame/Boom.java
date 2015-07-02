/**
 * 
 */
package com.test.frame;

class Boom {
	int x;
	int y;
	int life = 9;// 爆炸的时间过程
	boolean isLive = true;

	public Boom(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 过程减少
	public void lifeDown() {
		if (life > 0) {
			life--;
		} else {
			this.isLive = false;
		}
	}
}