package com.self.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * @Author: gaobo07
 * @Date: 2020/8/31 10:04 下午
 */
public class SlidingWindow {

    /**
     * 滑动窗口
     */
    private int[] slidingWindow;

    /**
     * 当前票号
     */
    private int curNumber = -1;

    /**
     * 窗口大小
     */
    private int limit;

    /**
     * 指针位置
     */
    private int curPosition;

    /**
     * 总数
     */
    private long total;

    /**
     * 限制黄牛数
     */
    private Semaphore semaphore;

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
     * @param total            间隔
     * @param concurrentCount   并发限制数
     */
    public SlidingWindow(int limit, int total, int concurrentCount) {
        if (limit < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + limit);
        }

        this.curPosition = 0;
        this.total = total;
        this.limit = limit;
        this.slidingWindow = new int[limit];
        this.semaphore = new Semaphore(concurrentCount, true);

        Arrays.fill(slidingWindow, 0);
    }

    /**
     * 限制QPS
     * 使用了数组存储调用的次数
     * @return 钱
     */
    public SellObj sell() {
        synchronized (lock) {
            curNumber++;
            if (curNumber < total) {
                //赋值，将上一次调用的编号放入，保证下个窗口到来时，方便计算
                slidingWindow[curPosition++] = curNumber;
                //整理滑动窗口，让窗口超过limit后，能重新计算
                int over = curNumber / limit;
                curPosition = curPosition % limit;
                return new SellObj(curNumber, 500 + over * 100);
            } else {
                return null;
            }
        }
    }

    public SellObj concurrentSell(){
        try{
            semaphore.acquire();
            return sell();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return null;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow(100, 1000, 3);
        for(int i = 0; i < 3; i++){
            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 0;
                    int money = 0;
                    StringBuilder sb = new StringBuilder();
                    while(count < 1000){
                        SellObj sellObj = slidingWindow.concurrentSell();
                        if(sellObj != null){
                            sb.append(" ");
                            sb.append(sellObj.number);
                            money = money + sellObj.money;
                        }
                        count++;
                    }
                    System.out.println(sb.toString());
                    System.out.println(money);
                }
            });
            threadA.start();
        }
    }

}

class SellObj{
    public int number;
    public int money;

    public SellObj(int number, int money){
        this.number = number;
        this.money = money;
    }
}
