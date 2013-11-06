package demo.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-18
 * Time: 下午4:37
 */
public class InnerClassSingleton {
    private static class INSTANCE_CONTAINER {
        private static String INSTANCE = "hello";
        public static String getInstance() {
            return INSTANCE;
        }
        static {
            System.err.println("Load inner class.");
        }
    }

    public static String getInstance() {
        return INSTANCE_CONTAINER.getInstance();
    }

    public static String otherMethod() {
        return "other";
    }

    static {
        System.err.println("Load class.");
    }
}
