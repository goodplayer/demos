package demo.waitNofity;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-24
 * Time: 上午10:35
 */
public class WaitNotifyDemo implements Runnable {
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitNotifyDemo()).start();
        Thread.sleep(2000);//两个线程的顺序颠倒就会产生死锁，因为wait会无限等待
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.err.println(Thread.currentThread());
                        Thread.sleep(5000);
                        lock.notifyAll();
                        System.err.println(Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.err.println(Thread.currentThread());
                Thread.sleep(5000);
                lock.wait();
                System.err.println(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
