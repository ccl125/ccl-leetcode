package thread;

import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/5/11 19:48
 * @Description
 */
// 线程池接口
public interface ThreadPool {

    // 提交任务到线程池
    void execute(Runnable task);

    // 优雅关闭
    void shutdown();

    //立即关闭
    List<Runnable> shutdownNow();
}