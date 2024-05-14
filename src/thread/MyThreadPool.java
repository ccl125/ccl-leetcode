package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author CuiChengLong
 * @Date 2024/5/11 20:54
 * @Description
 */
public class MyThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ThreadLocal<String> myThreadLocal = new ThreadLocal<>();
    }

}
