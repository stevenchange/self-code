package com.self.code.multithread;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: self-code
 * @description: 按照顺序输出数据
 * @author: GaoBo
 * @create: 2019/11/27
 **/
public class MultiThread {

	public MultiThread(){

	}

	/**按照顺序打印一次*/

//	private CountDownLatch countDownLatchFirst = new CountDownLatch(1);
//	private CountDownLatch countDownLatchSecond = new CountDownLatch(1);
//
//	public void first(Runnable printFirst) throws InterruptedException {
//		// printFirst.run() outputs "first". Do not change or remove this line.
//		printFirst.run();
//		countDownLatchFirst.countDown();
//	}
//
//	public void second(Runnable printSecond) throws InterruptedException {
//		countDownLatchFirst.await();
//		// printSecond.run() outputs "second". Do not change or remove this line.
//		printSecond.run();
//		countDownLatchSecond.countDown();
//	}
//
//	public void third(Runnable printThird) throws InterruptedException {
//		countDownLatchSecond.await();
//		// printThird.run() outputs "third". Do not change or remove this line.
//		printThird.run();
//	}

//	public static void main(String[] args) throws Exception {
//		MultiThread multiThread = new MultiThread();
//
//		Thread thread1 = new Thread(() -> {
//			try {
//				multiThread.first(new Runnable() {
//					@Override
//					public void run() {
//						System.out.println("one");
//					}
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//
//		});
//
//		Thread thread2 = new Thread(() -> {
//			try {
//				multiThread.second(new Runnable() {
//					@Override
//					public void run() {
//						System.out.println("two");
//					}
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//
//		});
//
//		Thread thread3 = new Thread(() -> {
//			try {
//				multiThread.third(new Runnable() {
//					@Override
//					public void run() {
//						System.out.println("three");
//					}
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//
//		thread1.start();
//		thread2.start();
//		thread3.start();
//	}
	/**按照顺序打印一次 end*/


	/**交替按照顺序打印*/
//	private int n;
//	private int threadNum;
//	private Lock lock = new ReentrantLock();
//	private Condition condition = lock.newCondition();
//	private AtomicInteger atomicInteger = new AtomicInteger(0);
//
//	public MultiThread(int threadNum, int n) {
//		this.threadNum = threadNum;
//		this.n = n;
//	}
//
//	public void foo(Runnable printFoo) throws InterruptedException {
//
//		for (int i = 0; i < n; i++) {
//			try{
//				lock.lock();
//				while(atomicInteger.intValue() % threadNum != 0){
//					condition.await();
//				}
//
//				// printFoo.run() outputs "foo". Do not change or remove this line.
//				printFoo.run();
//				atomicInteger.incrementAndGet();
//				condition.signalAll();
//			} finally {
//				lock.unlock();
//			}
//		}
//	}
//
//	public void bar(Runnable printBar) throws InterruptedException {
//
//		for (int i = 0; i < n; i++) {
//			try{
//				lock.lock();
//				while(atomicInteger.intValue() % threadNum != 1){
//					condition.await();
//				}
//
//				// printBar.run() outputs "bar". Do not change or remove this line.
//				printBar.run();
//				atomicInteger.incrementAndGet();
//				condition.signalAll();
//			} finally {
//				lock.unlock();
//			}
//		}
//	}
//
//	public void world(Runnable printWorld) throws InterruptedException {
//
//		for (int i = 0; i < n; i++) {
//			try{
//				lock.lock();
//				while(atomicInteger.intValue() % threadNum != 2){
//					condition.await();
//				}
//
//				// printBar.run() outputs "bar". Do not change or remove this line.
//				printWorld.run();
//				atomicInteger.incrementAndGet();
//				condition.signalAll();
//			} finally {
//				lock.unlock();
//			}
//		}
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//
//		MultiThread multiThread = new MultiThread(2, 6);
//
//		Thread thread1 = new Thread(() -> {
//			try {
//				multiThread.foo(new Runnable() {
//					@Override
//					public void run() {
//						System.out.print("foo");
//					}
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//
//		});
//
//		Thread thread2 = new Thread(() -> {
//			try {
//				multiThread.bar(new Runnable() {
//					@Override
//					public void run() {
//						System.out.print("bar");
//					}
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//
//		});
//
//		Thread thread3 = new Thread(() -> {
//			try {
//				multiThread.world(new Runnable() {
//					@Override
//					public void run() {
//						System.out.print("world");
//						System.out.println("");
//					}
//				});
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//
//		thread1.start();
//		thread2.start();
//		thread3.start();
//	}
	/**交替按照顺序打印*/

	/**交替打印奇数偶数，例如：010203040506*/
	/**自己思考后，实现版本*/
//	private int n;
//	private Lock lock = new ReentrantLock();
//	private Condition condition = lock.newCondition();
//  private Condition conditionZero = lock.newCondition();
//	private AtomicInteger atomicInteger = new AtomicInteger(0);
//  private volatile boolean needZero = true;
//
//	public MultiThread(int n) {
//		this.n = n;
//	}
//
//	// printNumber.accept(x) outputs "x", where x is an integer.
//	public void zero(IntConsumer printNumber) throws InterruptedException {
//		for(int i = 1; i <= n ; i++){
//            while (!needZero) {
//
//            }
//		    try {
//                lock.lock();
//                printNumber.accept(0);
//                needZero = false;
//                conditionZero.signalAll();
//            } finally {
//		        lock.unlock();
//            }
//		}
//	}
//
//	//打印偶数
//	public void even(IntConsumer printNumber) throws InterruptedException {
//		for(int i = 1; i <= n; i++){
//            try{
//                lock.lock();
//                while(atomicInteger.intValue() % 2 != 0){
//                    condition.await();
//                }
//
//                if(i % 2 == 0){
//                    printNumber.accept(i);
//                    needZero = true;
//                    conditionZero.await(1, TimeUnit.MILLISECONDS);
//                }
//
//                atomicInteger.incrementAndGet();
//                condition.signalAll();
//
//            } finally {
//                lock.unlock();
//            }
//		}
//	}
//
//	//打印奇数
//	public void odd(IntConsumer printNumber) throws InterruptedException {
//		for(int i = 1; i <= n; i++){
//            try{
//                lock.lock();
//                while(atomicInteger.intValue() % 2 != 1){
//                    condition.await();
//                }
//
//                if(i % 2 == 1){
//                    printNumber.accept(i);
//                    needZero = true;
//                    conditionZero.await(1, TimeUnit.MILLISECONDS);
//                }
//                atomicInteger.incrementAndGet();
//                condition.signalAll();
//            } finally {
//                lock.unlock();
//            }
//		}
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//		MultiThread multiThread = new MultiThread(10);
//		IntConsumer intConsumer = new IntConsumer();
//		Thread thread1 = new Thread(() -> {
//			try{
//				multiThread.zero(intConsumer);
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//
//		Thread thread2 = new Thread(() -> {
//			try{
//				multiThread.even(intConsumer);
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//
//		Thread thread3 = new Thread(() -> {
//			try{
//				multiThread.odd(intConsumer);
//			} catch (InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//
//		thread1.start();
//		thread2.start();
//		thread3.start();
//	}
    /**自己思考后，实现版本*/
	/**交替打印奇数偶数，例如：010203040506*/

    /**交替打印奇数偶数，例如：010203040506*/
    /**信号量，实现版本*/
    private int n;
    private Semaphore semaphore = new Semaphore(0);
    private Exchanger<Integer> oddExchanger = new Exchanger<Integer>();
    private Exchanger<Integer> evenExchanger = new Exchanger<Integer>();


	public MultiThread(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++){

            printNumber.accept(0);

            if(i % 2 == 0){
                evenExchanger.exchange(i);
            } else {
                oddExchanger.exchange(i);
            }
            semaphore.acquire();
        }
	}

	//打印偶数
	public void even(IntConsumer printNumber) throws InterruptedException {
	    while(true) {
            int temp;
            try {
                temp = evenExchanger.exchange(0, 10, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                return;
            }
            printNumber.accept(temp);
            semaphore.release();
        }
	}

	//打印奇数
	public void odd(IntConsumer printNumber) throws InterruptedException {
	    while (true) {
            int temp;
            try {
                temp = oddExchanger.exchange(0, 10, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                return;
            }
            printNumber.accept(temp);
            semaphore.release();
        }
	}

	public static void main(String[] args) throws InterruptedException {
		MultiThread multiThread = new MultiThread(10);
		IntConsumer intConsumer = new IntConsumer();
		Thread thread1 = new Thread(() -> {
			try{
				multiThread.zero(intConsumer);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		});

		Thread thread2 = new Thread(() -> {
			try{
				multiThread.even(intConsumer);
			} catch (Exception e){
				e.printStackTrace();
			}
		});

		Thread thread3 = new Thread(() -> {
			try{
				multiThread.odd(intConsumer);
			} catch (Exception e){
				e.printStackTrace();
			}
		});

		thread1.start();
		thread2.start();
		thread3.start();
	}

}

class IntConsumer{

	public void accept(int x){
		System.out.println(x);
	}
}
