package chapter1;

/**
 * 当一个线程调用共享对象的 wait() 方法被阻塞挂起后，
 * 如果其他线程中断了该线程，
 * 则该线程会抛出 Interrupted Exception 异常并返回。
 *
 * @auther willi
 * @create-time 2019-06-02-1:57
 */


public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException{
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin---");
                    //阻塞当前线程
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("---end---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }
}
