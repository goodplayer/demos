package demo.exception;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-5-30
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
public class PerformanceDemo {
    private static int TOTAL_CNT = 10000*10000;
    @Test
    public void testPerformance() {
        long time1 = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_CNT; i++){
            try {
                throwFastException();
            } catch (Exception e) {
            }
        }
        long time2 = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_CNT; i++){
            returnNewHashMap();
        }
        long time3 = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_CNT; i++){
            returnNull();
        }
        long time4 = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_CNT; i++){
            returnObject();
        }
        long time5 = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_CNT; i++){
            returnString();
        }
        long time6 = System.currentTimeMillis();
        for(int i = 0; i < TOTAL_CNT; i++){
            try {
                throwRuntimeException();
            } catch (Exception e) {
            }
        }
        long time7 = System.currentTimeMillis();

        System.out.println("fast exception:");
        System.out.println(time2-time1);
        System.out.println("new hash map:");
        System.out.println(time3-time2);
        System.out.println("null:");
        System.out.println(time4-time3);
        System.out.println("new object:");
        System.out.println(time5-time4);
        System.out.println("new string:");
        System.out.println(time6-time5);
        System.out.println("runtime exception:");
        System.out.println(time7-time6);
    }

    private static Object throwFastException(){
        throw new MyExcetion();
    }
    private static Object returnNewHashMap(){
        return new HashMap<String, String>();
    }
    private static Object returnNull(){
        return null;
    }
    private static Object returnObject(){
        return new Object();
    }
    private static Object returnString(){
        return new String();
    }
    private static Object throwRuntimeException(){
        throw new RuntimeException();
    }
}
class MyExcetion extends RuntimeException{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}