package chapter1;

/**
 * 本例证明了当线程调用共享变量的 wait() 方法时，
 * 当前线程只会释放当前共享对象的锁，
 * 当前线程所持有的其他共享对象的监视器锁并不会被释放
 *
 * @auther willi
 * @create-time 2019-06-02-0:45
 */


public class WaitNotifyTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException{

        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                        synchronized (resourceB) {
                            System.out.println("threadA get resourcesB lock");
                            System.out.println("threadA release resourceA lock");

                            resourceA.wait();
                        }
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock ...");

                        synchronized (resourceB) {
                            System.out.println("threadB get resourcesB lock");
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}
