package thread;

import threadpool.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author CuiChengLong
 * @Date 2024/5/12 21:51
 * @Description 消费者
 */
public class Customer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Customer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Integer take = queue.take();
                if (take == -1) {
                    break;
                }
                //消费者处理
                Thread.sleep(2);
                System.out.println("customer " + take);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(100);
        Thread producerThread = new Thread(new Producer(queue));
        producerThread.start();
        //2个消费者
        int numConsumers = 2;
        Thread[] consumerThread = new Thread[numConsumers];
        for (int i = 0; i < numConsumers; i++) {
            consumerThread[i] = new Thread(new Customer(queue));
            consumerThread[i].start();
        }

        try {
            producerThread.join();
            for (int i = 0; i < numConsumers; i++) {
                consumerThread[i].join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
