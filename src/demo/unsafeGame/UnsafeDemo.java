package demo.unsafeGame;

import com.sun.management.OperatingSystemMXBean;
import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-11
 * Time: 上午10:00
 */
public class UnsafeDemo {
    public static void main(String[] args) {
        Unsafe unsafe = GetUnsafe.getUnsafe();
        System.out.println("pageSize: "+unsafe.pageSize());
        System.out.println("addressSize: "+unsafe.addressSize());

        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println(osmxb.getArch());
    }
}
