package thread;

import java.util.concurrent.BlockingQueue;

/**
 * @Author CuiChengLong
 * @Date 2024/5/11 19:49
 * @Description
 */
public class WorkerThread extends Thread {
    // 用于从任务队列中取出并执行任务
    private BlockingQueue<Runnable> taskQueue;

    // 构造方法，传入任务队列
    public WorkerThread(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    // 重写run方法
    @Override
    public void run() {
        // 循环执行，直到线程被中断
        while (!Thread.currentThread().isInterrupted() && !taskQueue.isEmpty()) {
            try {
                // 从任务队列中取出一个任务，如果队列为空，则阻塞等待
                Runnable task = taskQueue.take();
                // 执行任务
                task.run();
            } catch (Exception e) {
                e.printStackTrace();
                // 如果线程被中断，则退出循环
                break;
            }
        }
    }

}
