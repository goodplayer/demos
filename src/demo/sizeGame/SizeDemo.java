package demo.sizeGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-10
 * Time: 下午3:04
 */
public class SizeDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(GetObjectSize.sizeOf(new MutableLong()));
        System.out.println(GetObjectSize.sizeOf(new PaddedLong()));
        System.out.println(GetObjectSize.sizeOf(new Object()));
    }
}
