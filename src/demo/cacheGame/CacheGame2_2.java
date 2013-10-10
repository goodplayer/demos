package demo.cacheGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午4:35
 */
public class CacheGame2_2 {
    private static final int MAX_STEP = 64;
    public static void main(String[] args) {
        int[] arr = new int[128 * 1024 * 1024];

        long[] times = new long[MAX_STEP*2];

        for (int i = 1; i <= MAX_STEP; i++) {
            times[(i-1)*2] = System.currentTimeMillis();
            doLoop(arr, i);
            times[(i-1)*2 + 1] = System.currentTimeMillis();
        }

        for (int i = 1; i <= MAX_STEP; i++) {
            long time = times[(i-1)*2 + 1] - times[(i-1)*2];
            System.out.println("method"+i+": "+time);
        }

        /**
         * 现象：每16个字节一个台阶
         * 说明：在一个缓存行内，循环次数的减少，并不会引起较大的性能差距，因为读取内存的次数一样
         * 如果跨过缓存行，随着循环次数的减少，缓存行的替换读取就减少，内存读取次数明显降低，性能得到较大提升
         * （注：本测试不明显。。。）
         */
    }

    private static void doLoop(int[] arr, final int STEP) {
//        for (int k = 0; k < STEP; k++)
            for (int i = 0; i < arr.length; i += STEP)
                arr[i] *= 3;
    }
}
