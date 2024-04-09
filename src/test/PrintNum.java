package test;

import java.util.concurrent.Executor;

/**
 * @Author CuiChengLong
 * @Date 2024/4/2 17:37
 * @Description N个线程循环打印1—100
 */

public class PrintNum {

    private int num;
    private static final Object LOCK = new Object();
    private int maxNum = 100;

    private void print(int targetNum) {
        while (true) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {
                    if (num >= maxNum) {
                        break;
                    }
                    try {
                        LOCK.wait();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                if (num >= maxNum) {
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName() + ": " + num);
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintNum test = new PrintNum();
        new Thread(() -> test.print(0), "Thread1").start();
        new Thread(() -> test.print(1), "Thread2").start();
        new Thread(() -> test.print(2), "Thread3").start();
    }


}
