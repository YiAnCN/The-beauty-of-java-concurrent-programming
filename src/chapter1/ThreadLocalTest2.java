package chapter1;

/**
 * ThreadLocal 不支持继承性
 *
 * @auther willi
 * @create-time 2019-05-29-21:41
 */


public class ThreadLocalTest2 {

    //创建线程变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //父线程中设置线程变量
        threadLocal.set("hello world");

        //启动子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程输出线程变量的值
                System.out.println("thread:" + threadLocal.get());
            }
        });

        thread.start();

        System.out.println("main:" + threadLocal.get());
    }
}
