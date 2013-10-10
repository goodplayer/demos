package demo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-8-5
 * Time: 下午1:36
 */
public class ToArrayTest {
    public static void main(String[] args) {
//        List<String> aaa = new ArrayList<String>();
//        aaa.add("jj");
//        System.out.println(((String[])aaa.toArray()).length);

        List<String> bbb = new ArrayList<String>();
        bbb.add("jj");
        System.out.println((bbb.toArray(new String[0])));
        System.out.println((bbb.toArray(new String[0])).length);
    }
}
