package test;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/31 9:11
 * @Description
 */
public class MyTest {

    //线程个数
    private static int THREAD_COUNT = 10;
    //总元素数量
    private static int ITEM_COUNT = 1000;
    //帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
    private ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public String wrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);
        //初始900个元素
//        log.info("init size:{}", concurrentHashMap.size());
        System.out.println("init size = " + concurrentHashMap.size());
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            //查询还需要补充多少个元素
            int gap = ITEM_COUNT - concurrentHashMap.size();
//            log.info("gap size:{}", gap);
            System.out.println("gap size = " + gap);
            //补充元素
            concurrentHashMap.putAll(getData(gap));
        }));
        //等待所有任务完成
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //最后元素个数会是1000吗？
//        log.info("finish size:{}", concurrentHashMap.size());
        System.out.println("finish size = " + concurrentHashMap.size());
        ThreadLocal<Integer> test = new ThreadLocal<>();
        CompletableFuture<Void> future = new CompletableFuture<>();
        CompletableFuture<Void> uCompletableFuture = future.applyToEither(getData2(2), Function.identity());
        return "OK";
    }

    public CompletionStage<? extends Void> getData2(int a) {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        MyTest test = new MyTest();
        int x = -10;
        System.out.println(String.valueOf(x));
        int my = 20;
        //Test
//        test.wrong();
        decrypt(new int[]{2,4,9,3}, -2);
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        for (int i = 0; i < code.length; i++) {
            int x1 = (i - 1 + n) % n;
            int x2 = (i - 2 + n) % n;
            int x3 = (i - 3 + n) % n;
            System.out.println("i = " + i + " x1 = " + x1);
            System.out.println("i = " + i + " x2 = " + x2);
            System.out.println("i = " + i + " x3 = " + x3);
            if (k == 0) {
                res[i] = 0;
            } else if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(i + j + n) % n];
                }
            } else {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(i - j + n) % n];
                }
            }
        }
        return res;
    }

}
