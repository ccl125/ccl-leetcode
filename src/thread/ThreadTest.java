package thread;

/**
 * @Author CuiChengLong
 * @Date 2024/5/13 17:56
 * @Description
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Windows windows = new Windows();
        Windows windows1 = new Windows();
        Thread thread1 = new Thread(windows);
        thread1.setName("窗口1");
        Thread thread2 = new Thread(windows);;
        thread2.setName("窗口2");
        Thread thread3 = new Thread(windows1);
        thread3.setName("窗口3");
        thread1.start();
        thread2.join();
        thread3.start();
    }
}
