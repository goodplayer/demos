package demo.cacheGame;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-15
 * Time: 上午12:00
 */
public class CacheCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input 'cache line size'(byte):");
        int lineSize = sc.nextInt();

        System.out.println("Please input '# of ways of association':");
        int assoc = sc.nextInt();

        System.out.println("Please input 'cache size'(k,m,g):");
        String cacheSizeStr = sc.next();
        int cacheSize = 0;

        switch (cacheSizeStr.charAt(cacheSizeStr.length() - 1)) {
            case 'k':
            case 'K':
                cacheSize = Integer.parseInt(cacheSizeStr.substring(0, cacheSizeStr.length() - 1)) * 1024;
                break;
            case 'g':
            case 'G':
                cacheSize = Integer.parseInt(cacheSizeStr.substring(0, cacheSizeStr.length() - 1)) * 1024 * 1024 * 1024;
                break;
            case 'm':
            case 'M':
                cacheSize = Integer.parseInt(cacheSizeStr.substring(0, cacheSizeStr.length() - 1)) * 1024 * 1024;
                break;
        }

        //计算竞争间隔，字节
        int numOfConflict = cacheSize / assoc;
        //计算组联集合数目
        int numOfAssoSet = numOfConflict / lineSize;

        System.out.printf("偏移为[0x%x]的倍数的内存地址将竞争[%d]个缓存槽，总共可以有[%d]个这样的缓存行组联集合", numOfConflict, assoc, numOfAssoSet);

    }
}
