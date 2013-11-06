package demo.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-18
 * Time: 下午4:37
 */
public class SingletonTest {
    public static void main(String[] args) throws InterruptedException {
        InnerClassSingleton.otherMethod();
        Thread.sleep(5000);
        System.err.println("1");
        InnerClassSingleton.getInstance();
        System.err.println("2");
        Thread.sleep(2000);
    }
}
