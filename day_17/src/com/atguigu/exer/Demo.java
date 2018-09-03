package com.atguigu.exer;

public class Demo {

	public static void main(String[] args) {
		Print p = new Print();

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);

		t1.setName("甲：");
		t2.setName("乙：");

		t1.start();
		t2.start();

	}

}

class Print implements Runnable {

	int i = 1;

	@Override
	public void run() {
		// 实现打印1-100d的方法
		while (i < 100) {
			synchronized (this) {
				notify();
				System.out.println(Thread.currentThread().getName() + ":" + i);
				i++;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
