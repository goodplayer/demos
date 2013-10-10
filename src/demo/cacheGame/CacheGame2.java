package demo.cacheGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午3:47
 */
public class CacheGame2 {
    private static final int MAX_STEP = 64;
    public static void main(String[] args) {
        int[] arr = new int[64 * 1024 * 1024];

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
    }

    private static void doLoop(int[] arr, int STEP) {
        for (int k = 0; k < STEP; k++)
            for (int i = 0; i < arr.length; i += STEP)
                arr[i] *= 3;
    }
}
