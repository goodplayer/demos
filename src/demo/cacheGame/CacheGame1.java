package demo.cacheGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午2:51
 */
public class CacheGame1 {
    public static void main(String[] args) {
        int[] arr = new int[64 * 1024 * 1024];

        long time1 = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++)
            arr[i] *= 3;

        long time2 = System.currentTimeMillis();

        for (int k = 0 ; k < 16 ; k++)
            for (int i = 0; i < arr.length; i += 16)
                arr[i] *= 3;

        long time3 = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i += 16)
            arr[i] *= 3;

        long time4 = System.currentTimeMillis();

        System.out.println("method1: "+(time2 - time1));
        System.out.println("method2: "+(time3 - time2));
        System.out.println("method3: "+(time4 - time3));

        /**
         * 说明：计算的时间很大程度上取决于内存的读写次数
         * 当超过一个缓存行的时候
         */
    }
}
