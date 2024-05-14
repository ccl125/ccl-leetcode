package threadpool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author CuiChengLong
 * @Date 2024/5/12 22:49
 * @Description
 */
public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final Random random = new Random();

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Integer item = queue.take();
                if (item == -1) {
                    break;
                }
                // 模拟消费者处理时间
                Thread.sleep(random.nextInt(401) + 100);
                System.out.println("Consumed: " + item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

        Thread producerThread = new Thread(new Producer(queue));
        producerThread.start();

        int numConsumers = 2; // 至少需要2个消费者
        Thread[] consumerThreads = new Thread[numConsumers];
        for (int i = 0; i < numConsumers; i++) {
            consumerThreads[i] = new Thread(new Consumer(queue));
            consumerThreads[i].start();
        }

        try {
            producerThread.join();
            for (Thread consumerThread : consumerThreads) {
                consumerThread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed");
    }

}
