package demo.jniGame;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-17
 * Time: 上午11:41
 */
public class PerfSample {
    public static void main(String[] args) {
        PerfSample p = new PerfSample();

        p.hello();

        p.helloJni();
    }

    public native void helloJni();

    public void hello() {
        //
    }

    static{
        System.loadLibrary("PerfSample");
    }
}
