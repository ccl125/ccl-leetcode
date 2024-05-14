package thread;

import java.util.concurrent.BlockingQueue;

/**
 * @Author CuiChengLong
 * @Date 2024/5/12 21:23
 * @Description 生产者
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                queue.put(i);
                System.out.println("produced: " + i);
            }
            //结束标志
            queue.put(-1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
