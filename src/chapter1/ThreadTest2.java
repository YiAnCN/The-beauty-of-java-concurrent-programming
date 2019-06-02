package chapter1;

/**
 * 实现 Runnable 接口的 run 方法
 *
 * @auther willi
 * @create-time 2019-05-26-18:19
 */


public class ThreadTest2 {

    public static class RunnableTask implements Runnable{

        @Override
        public void run() {
           System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
