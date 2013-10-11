package demo.unsafeGame;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-11
 * Time: 上午9:58
 */
public class GetUnsafe {
    public static Unsafe getUnsafe(){
        try {
            return getUnsafe1();
        } catch (Exception e) {
            return null;
        }
    }
    private static Unsafe getUnsafe1() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}
