package chapter1;

/**
 * 一个例子说明线程死锁
 *
 * @auther willi
 * @create-time 2019-05-28-17:05
 */


public class DeadLockTest {

    public static Object resourceA = new Object();
    public static Object resourceB = new Object();

    public static void main(String[] args) {

        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }
            }
        });

//        //创建线程B
//        Thread threadB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resourceB){
//                    System.out.println(Thread.currentThread() + "get ResourceB");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread() + "waiting get resourceA");
//                    synchronized (resourceA){
//                        System.out.println(Thread.currentThread() + "get resourceA");
//                    }
//                }
//
//            }
//        });

        //创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get ResourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }
                }

            }
        });

        threadA.start();
        threadB.start();
    }

}
