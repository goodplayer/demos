package demo;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-6-14
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */
public class Amamama {
    public static void main(String[] args) {
        Random random = new Random();
        for(int i = 0; i < 100000; i++){
            System.out.print(random.nextInt(4));
        }
    }
}
