/**
 * 
 */
package com.test.frame;

class Boom {
	int x;
	int y;
	int life = 9;// ��ը��ʱ�����
	boolean isLive = true;

	public Boom(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// ���̼���
	public void lifeDown() {
		if (life > 0) {
			life--;
		} else {
			this.isLive = false;
		}
	}
}