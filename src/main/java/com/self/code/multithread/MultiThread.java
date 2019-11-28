package com.self.code.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: self-code
 * @description: 按照顺序输出数据
 * @author: GaoBo
 * @create: 2019/11/27
 **/
public class MultiThread {

	public MultiThread(){

	}

	private CountDownLatch countDownLatchFirst = new CountDownLatch(1);
	private CountDownLatch countDownLatchSecond = new CountDownLatch(1);

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		countDownLatchFirst.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		countDownLatchFirst.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		countDownLatchSecond.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		countDownLatchSecond.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}


	public static void main(String[] args) throws Exception {
		MultiThread multiThread = new MultiThread();

		Thread thread1 = new Thread(() -> {
			try {
				multiThread.first(new Runnable() {
					@Override
					public void run() {
						System.out.println("one");
					}
				});
			} catch (InterruptedException e){
				e.printStackTrace();
			}

		});

		Thread thread2 = new Thread(() -> {
			try {
				multiThread.second(new Runnable() {
					@Override
					public void run() {
						System.out.println("two");
					}
				});
			} catch (InterruptedException e){
				e.printStackTrace();
			}

		});

		Thread thread3 = new Thread(() -> {
			try {
				multiThread.third(new Runnable() {
					@Override
					public void run() {
						System.out.println("three");
					}
				});
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		});


		try{
			thread1.start();
			thread2.start();
			thread3.start();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
