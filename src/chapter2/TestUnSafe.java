package chapter2;

import sun.misc.Unsafe;

/**
 * Unsafe 类
 *
 * @auther willi
 * @create-time 2019-06-02-22:44
 */


public class TestUnSafe {

    //获取 Unsafe 的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量 state 在类 TestUnSafe 中的偏移值
    static final long stateOffset;

    //变量
    private volatile long state = 0;

    static{
        try{
            //获取 state 变量在类 TestUnSafe 中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));

        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例
        TestUnSafe test = new TestUnSafe();
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
