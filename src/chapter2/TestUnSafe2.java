package chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @auther willi
 * @create-time 2019-06-11-13:25
 */


public class TestUnSafe2 {
    static final Unsafe unsafe;

    static final long stateOffest;

    private volatile long state = 0;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffest = unsafe.objectFieldOffset(TestUnSafe2.class.getDeclaredField("state"));
        } catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        TestUnSafe2 test = new TestUnSafe2();
        Boolean success = unsafe.compareAndSwapInt(test,stateOffest,0,1);
        System.out.println(success);
    }
}
