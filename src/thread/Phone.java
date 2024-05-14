package thread;

/**
 * @Author CuiChengLong
 * @Date 2024/5/13 18:44
 * @Description
 */
public class Phone {

    public static synchronized void sendEamil() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":send email");
    }


    public static synchronized void sendCall() {
        System.out.println(Thread.currentThread().getName() + ":send call");
    }

    public  void hello() {
        System.out.println(Thread.currentThread().getName() + ":send hello");
    }

}


class LockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone.sendEamil();
        },"aThread").start();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.sendCall();
        },"bThread").start();
    }

}







