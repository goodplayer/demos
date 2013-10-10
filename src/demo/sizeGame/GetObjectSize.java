package demo.sizeGame;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午3:02
 */
public class GetObjectSize {
    public static long sizeOf(Object o) {
        try {
            Unsafe u = getUnsafe();
            HashSet<Field> fields = new HashSet<Field>();
            Class c = o.getClass();
            while (c != Object.class) {
                for (Field f : c.getDeclaredFields()) {
                    if ((f.getModifiers() & Modifier.STATIC) == 0) {
                        fields.add(f);
                    }
                }
                c = c.getSuperclass();
            }
            long maxSize = 0;
            for (Field f : fields) {
                long offset = u.objectFieldOffset(f);
                if (offset > maxSize) {
                    maxSize = offset;
                }
            }
            return ((maxSize / 8) + 1) * 8;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Unsafe getUnsafe() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}
