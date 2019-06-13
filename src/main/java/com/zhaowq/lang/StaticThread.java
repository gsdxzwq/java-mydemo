package com.zhaowq.lang;

/**
 * @author zhaowq
 * @date 2017/6/1
 */
public class StaticThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		StaticAction.print();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new StaticThread()).start();
		}
	}
}
