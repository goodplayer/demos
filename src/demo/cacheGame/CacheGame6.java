package demo.cacheGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-16
 * Time: 下午11:32
 */
public class CacheGame6 {
    /**
     * NOTE: # of cores = 4
     * 虚拟机参数：-Xint
     * @param args ...
     */
    public static void main(String[] args) {
        run(0);
        sleep(15);

        run(1);
        sleep(15);

        run(2);
        sleep(15);

        run(16);
        sleep(15);

        run(32);
        sleep(15);

        run(64);
        sleep(15);

        /**
         *
         0:1381938152974
         1381938161922
         1381938162380
         1381938163010
         1381938163015
         1:1381938167976
         1381938175908
         1381938176868
         1381938177366
         1381938177608
         2:1381938182976
         1381938193011
         1381938193434
         1381938193795
         1381938193820
         16:1381938197977
         1381938201459
         1381938201915
         1381938201935
         1381938202231
         32:1381938212977
         1381938215763
         1381938216343
         1381938216781
         1381938216994
         64:1381938227977
         1381938231583
         1381938231623
         1381938231998
         1381938232186

         最大数据差
         0:10041
         1:9632
         2:10844
         16:4254
         32:4017
         64:4209

         * 说明：
         * 缓存的伪共享问题影响性能
         * 另外虚拟机的JIT对此代码做了优化，造成没有明显差别
         *
         */
    }

    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void run(final int position) {
        System.err.println(position + ":" + System.currentTimeMillis());
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    UpdateCounter(position);
                }
            }).start();
        }
    }

    private static int[] s_counter = new int[1024];

    private static void UpdateCounter(int position) {
        for (int j = 0; j < 100000000; j++) {
            s_counter[position] = s_counter[position] + 3;
        }
        System.err.println(System.currentTimeMillis());
    }
}
