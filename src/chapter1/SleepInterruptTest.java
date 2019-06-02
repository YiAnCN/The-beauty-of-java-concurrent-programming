package chapter1;

/**
 * @auther willi
 * @create-time 2019-05-27-22:04
 */


public class SleepInterruptTest {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin sleep for 2000 seconds");
                try {
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    return;
                }
                System.out.println("threadOne-leaving normally");
            }
        });

        //启动线程
        threadOne.start();

        //确保子线程进入休眠状态
        Thread.sleep(1000);

        //打断子线程休眠让子线程从 sleep 函数返回
        threadOne.interrupt();

        //等待子线程执行完毕
        threadOne.join();

        System.out.println("main thread is over");
    }
}
