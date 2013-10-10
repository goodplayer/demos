package demo.cacheGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午4:51
 */
public class CacheGame3 {
    private static int[] dataSize = {
            1*1024/4,//1k
            2*1024/4,//2k
            4*1024/4,//4k
            8*1024/4,//8k
            16*1024/4,//16k
            32*1024/4,//32k, my test cpu L1 cache size
            64*1024/4,//64k
            128*1024/4,//128k
            256*1024/4,//256k, my test cpu L2 cache size
            512*1024/4,//512k
            1*1024*1024/4,//1m
            2*1024*1024/4,//2m
            3*1024*1024/4,//3m, my test cpu L3 cache size
            4*1024*1024/4,//4m
            8*1024*1024/4,//8m
            16*1024*1024/4,//16m
            32*1024*1024/4,//32m
            64*1024*1024/4,//64m
            128*1024*1024/4,//128m
            256*1024*1024/4,//256m
            512*1024*1024/4,//512m
    };

    /**
     * 虚拟机参数：-Xmx1024m
     * @param args args
     */
    public static void main(String[] args) {
        for (int n = 0; n < dataSize.length; n++) {
            int[] arr = new int[dataSize[n]];
            int steps = 64 * 1024 * 1024;
            int lengthMod = arr.length - 1;

            long time1 = System.currentTimeMillis();
            for (int i = 0; i < steps; i++)
            {
                arr[(i * 16) & lengthMod]++; // (x & lengthMod) is equal to (x % arr.Length)
            }
            long time2 = System.currentTimeMillis();

            System.out.println("cnt="+(dataSize[n]*4)+": "+(time2 - time1));

            arr = null;
            System.gc();
        }

        /**
         * 说明：如果缓存能够容纳得下数据，那么读取数据的速度将会很快，否则速度将会变慢
         */
    }
}
