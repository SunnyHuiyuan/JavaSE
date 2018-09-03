package com.atguigu.exer;

/**
 * 
 * 生产者/消费者问题 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下， 如果店中有产品了再通知消费者来取走产品。
 */
public class Demo1 {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Productor p1 = new Productor(clerk);
		Productor p2 = new Productor(clerk);
		Customer c1 = new Customer(clerk);

		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		Thread t3 = new Thread(p2);

		t1.setName("生产者1");
		t2.setName("消费者");
		t3.setName("生产者2");

		t1.start();
		t2.start();
		t3.start();
	}

}

//店员
class Clerk {
	int product;

	public synchronized void addProduct() {
		if (product >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			product++;
			System.out.println(Thread.currentThread().getName() + "生产了第" + product + "个产品");
			notifyAll();
		}

	}

	public synchronized void consumeProduct() {
		if (product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "消费了第" + product + "个产品");
			product--;
			notifyAll();
		}

	}
}

//生产者
class Productor implements Runnable {
	Clerk clerk = new Clerk();

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("生产者开始生产产品");
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.addProduct();
		}
	}
}

//消费者
class Customer implements Runnable {
	Clerk clerk = new Clerk();

	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("消费者开始消费产品");
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}

	}

}
