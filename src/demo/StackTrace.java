package demo;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-7-29
 * Time: 下午3:25
 */
public class StackTrace {
    public static void main(String[] args) {
        //TODO
        runa();
        System.out.println();
    }
    private static void runa(){
        runb();
    }

    private static void runb(){
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
    }
}
