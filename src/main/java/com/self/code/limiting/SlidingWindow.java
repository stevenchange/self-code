package com.self.code.limiting;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: self-code
 * @description: 用滑动窗口的方式处理限流(QPS)
 * @author: GaoBo
 * @create: 2019/10/12
 **/
public class SlidingWindow {

    /**
     * 滑动窗口
     */
    private Long[] slidingWindow;

    /**
     * 窗口大小
     */
    private int limit;

    /**
     * 指针位置
     */
    private int curPosition;
    /**
     * 时间间隔
     */
    private long period;

    /**
     * 限制并发数
     */
    private Semaphore semaphore ;

    /**
     * 并发锁控制对象
     */
    private final Object lock = new Object();

    /**
     * 禁止通过无参构造函数，创建对象
     */
    private SlidingWindow(){}

    /**
     * 1秒内最多limit次请求
     * @param limit             限制次数
     * @param period            时间间隔 1000ms
     * @param concurrentCount   并发限制数
     * @param timeUnit          间隔类型 秒
     */
    public SlidingWindow(int limit, int period, int concurrentCount, TimeUnit timeUnit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + limit);
        }

        this.curPosition = 0;
        this.period = timeUnit.toMillis(period);
        this.limit = limit;
        this.slidingWindow = new Long[limit];
        this.semaphore = new Semaphore(concurrentCount, true);

        Arrays.fill(slidingWindow, 0L);
    }

    /**
     * 限制QPS
     * 本质上，使用了队列存储调用的次数
     * @return true or false
     */
    public boolean isPass() {
        long curTime = System.currentTimeMillis();

        synchronized (lock) {
            if (curTime >= period + slidingWindow[curPosition]) {
                //赋值，将上一次调用的时间放入，保证下个窗口到来时，方便计算时间
                slidingWindow[curPosition++] = curTime;
                //整理滑动窗口，让窗口超过20后，能重新计算
                curPosition = curPosition % limit;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isConcurrentPass(){
        try{
            semaphore.acquire();
            return isPass();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow(20, 1, 3, TimeUnit.SECONDS);

        for(int i = 0; i < 5; i++){
            Thread thread = new Thread() {
                @Override
                public void run() {
                    int count = 0;
                    while (count < 100) {
                        if (slidingWindow.isConcurrentPass()) {
                            count++;
                            System.out.println("can invoke, count: " + count + " time: " + System.currentTimeMillis() +
                                    " thread: " + Thread.currentThread().getName());
                        } else {
                            System.out.println("can't invoke");
                            break;
                        }
                    }
                }

            };

            thread.start();
        }

    }
}
