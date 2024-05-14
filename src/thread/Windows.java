package thread;

/**
 * @Author CuiChengLong
 * @Date 2024/5/13 17:48
 * @Description 验证synchronized关键字范围
 */
public class Windows implements Runnable {

    private static int ticketNum = 10;

    public static synchronized void show(){
        String name = Thread.currentThread().getName();
        if(ticketNum > 0) {
            try {
                //这一步是为了演示错票，原理是当前线程进入了if语句陷入沉睡的时候票被卖光，
                //然后当该线程苏醒时再来一次ticketNum--产生0号这个非法票
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +"卖出第" + ticketNum + "张票");
            ticketNum--;
        }
    }
    @Override
    public void run() {
        while (true){
            show();
        }
    }
}
