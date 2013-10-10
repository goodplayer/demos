package demo.cacheGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午5:19
 */
public class CacheGame4 {
    /**
     * 虚拟机参数：-Xint
     * @param args args
     */
    public static void main(String[] args) {
        int steps = 256 * 1024 * 1024;
        int[] a = new int[2];

        long time1 = System.currentTimeMillis();
        // Loop 1
        for (int i=0; i<steps; i++) { a[0]++; a[0]++; }
        long time2 = System.currentTimeMillis();

        long time3 = System.currentTimeMillis();
        // Loop 2
        for (int i=0; i<steps; i++) { a[0]++; a[1]++; }
        long time4 = System.currentTimeMillis();

        System.out.println("LOOP1: "+(time2 - time1));
        System.out.println("LOOP2: "+(time4 - time3));

        /**
         * 说明：（intel cpu，U/V两条流水线）
         * 1、指令间并发（使用虚拟机参数-Xint强制使用解释模式，而不编译），对不同内存操作有可能实现指令间并发
         * 2、当开启jvm即时编译（即不启用-Xint参数）时，虚拟机会优化LOOP1，使其效率高于LOOP2
         *      java -version:
         *      java version "1.6.0_45"
         *      Java(TM) SE Runtime Environment (build 1.6.0_45-b06)
         *      Java HotSpot(TM) 64-Bit Server VM (build 20.45-b01, mixed mode)
         */
    }
}
