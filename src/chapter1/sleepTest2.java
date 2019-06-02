package chapter1;

/**
 * 当一个线程处于睡眠状态，如果另外一个线程中断了它，
 * 会在调用 sleep 方法处抛出异常
 *
 * @auther willi
 * @create-time 2019-06-02-14:51
 */


public class sleepTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("child thread is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child thread is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        thread.start();

        //主线程休眠 2s
        Thread.sleep(2000);

        //主线程中断子线程
        thread.interrupt();
    }


}
