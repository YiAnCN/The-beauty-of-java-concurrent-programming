package chapter1;

/**
 * 继承 Thread 并重写 run 方法
 *
 * @auther willi
 * @create-time 2019-05-26-17:57
 */


public class ThreadTest {

    public static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
