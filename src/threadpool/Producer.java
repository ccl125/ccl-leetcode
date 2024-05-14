package threadpool;

import java.util.concurrent.BlockingQueue;

/**
 * @Author CuiChengLong
 * @Date 2024/5/12 22:47
 * @Description
 */
public class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                queue.put(i);
                System.out.println("Produced: " + i);
            }
            // 发送结束信号
            queue.put(-1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}