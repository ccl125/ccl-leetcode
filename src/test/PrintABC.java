package test;

/**
 * @Author CuiChengLong
 * @Date 2024/4/2 17:48
 * @Description 三个线程交替打印ABC
 */

public class PrintABC {

    private int num;
    private static final Object lock = new Object();

    private void printABC(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (num % 3 != targetNum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC test = new PrintABC();
        new Thread(() -> test.printABC(0), "A").start();
        new Thread(() -> test.printABC(1), "B").start();
        new Thread(() -> test.printABC(2), "C").start();

    }

}
