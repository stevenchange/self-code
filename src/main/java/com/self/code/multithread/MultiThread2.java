package com.self.code.multithread;

import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: self-code
 * @description: 多线程相关程序
 * @author: GaoBo
 * @create: 2019/12/2
 **/
public class MultiThread2 {

//	/**打印水分子*/

//	int hCount,oCount;
//
//	Semaphore hSem = new Semaphore(0);
//
//	Semaphore oSem = new Semaphore(1);
//
//	public MultiThread2() {
//
//	}
//
//	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//
//		hSem.acquire();
//		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
//		releaseHydrogen.run();
//		hCount++;
//		if(hCount >=2){
//			hCount = 0;
//			oSem.release();
//
//		}
//	}
//
//	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//
//		oSem.acquire();
//		// releaseOxygen.run() outputs "O". Do not change or remove this line.
//		releaseOxygen.run();
//		oCount++;
//		if(oCount>=1){
//			oCount=0;
//			hSem.release(2);
//
//		}
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//
//		MultiThread2 multiThread2 = new MultiThread2();
//
//		Thread thread1 = new Thread(() -> {
//			try{
//				multiThread2.hydrogen(() -> {
//					System.out.println("H");
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//
//		Thread thread2 = new Thread(() -> {
//			try{
//				multiThread2.oxygen(() -> {
//					System.out.println("O");
//				});
//			} catch (Exception e){
//				e.printStackTrace();
//			}
//		});
//
//		thread1.start();
//		thread2.start();
//	}

	/**打印水分子 end*/


	/**交替打印字符串*/

	private int n;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private AtomicInteger atomicInteger = new AtomicInteger(0);

	public MultiThread2(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		for(int i = 1; i <= n; i++){
			try {

				lock.lock();



				while(!(atomicInteger.intValue() % 3 == 0 && atomicInteger.intValue() % 5 != 0)){
					if(atomicInteger.intValue() >= n){
						return;
					}
					condition.await(10, TimeUnit.MILLISECONDS);
				}
				printFizz.run();
				atomicInteger.incrementAndGet();
				condition.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for(int i = 1; i <= n; i++){

			try {

				lock.lock();


				while(!(atomicInteger.intValue() % 3 != 0 && atomicInteger.intValue() % 5 == 0)){
					if(atomicInteger.intValue() >= n){
						return;
					}
					condition.await(10, TimeUnit.MILLISECONDS);
				}
				printBuzz.run();
				atomicInteger.incrementAndGet();
				condition.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for(int i = 1; i <= n; i++){

			try {

				lock.lock();

				while(!(atomicInteger.intValue() % 3 == 0 && atomicInteger.intValue() % 5 == 0)){
					if(atomicInteger.intValue() >= n){
						return;
					}
					condition.await(10, TimeUnit.MILLISECONDS);
				}
				printFizzBuzz.run();
				atomicInteger.incrementAndGet();
				condition.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for(int i = 1; i <= n; i++){
			try {
				lock.lock();
				if(atomicInteger.intValue() > n){
					return;
				}
				while(atomicInteger.intValue() % 3 == 0 || atomicInteger.intValue() % 5 == 0){
					if(atomicInteger.intValue() >= n){
						return;
					}
					condition.await(10, TimeUnit.MILLISECONDS);
				}
				printNumber.accept(atomicInteger.intValue());
				atomicInteger.incrementAndGet();
				condition.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		MultiThread2 multiThread2 = new MultiThread2(5);
		IntConsumer intConsumer = new IntConsumer();
		Thread thread1 = new Thread(() -> {
			try{
				multiThread2.fizz(() -> {
					System.out.println("fizz");
				});
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		});

		Thread thread2 = new Thread(() -> {
			try{
				multiThread2.buzz(() -> {
					System.out.println("buzz");
				});
			} catch (Exception e){
				e.printStackTrace();
			}
		});

		Thread thread3 = new Thread(() -> {
			try{
				multiThread2.fizzbuzz(() -> {
					System.out.println("fizzbuzz");
				});
			} catch (Exception e){
				e.printStackTrace();
			}
		});

		Thread thread4 = new Thread(() -> {
			try{
				multiThread2.number(intConsumer);
			} catch (Exception e){
				e.printStackTrace();
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

	/**交替打印字符串 end*/
}
