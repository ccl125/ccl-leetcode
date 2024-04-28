package test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * @Author CuiChengLong
 * @Date 2024/4/23 17:12
 * @Description
 */
public class CompletableFutureTest {

    public static void main(String[] args)  {
        // 生产者，可以指定返回结果
        System.out.println(Thread.currentThread());
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("异步任务开始执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("异步任务执行结束");
            return "返回结果";
        });
        Integer.toBinaryString()
        String result1 = firstTask.join();
        String result2 = null;
        try {
            result2 = firstTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(result1 + "," + result2);
    }



}
