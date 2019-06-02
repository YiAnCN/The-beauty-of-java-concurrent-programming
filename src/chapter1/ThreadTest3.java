package chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用 FutureTask
 *
 * @auther willi
 * @create-time 2019-05-26-18:25
 */


public class ThreadTest3 {
    public static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            //等待任务执行完毕返回结果
            String result = futureTask.get();
            System.out.println(result);
        }
        catch (ExecutionException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
