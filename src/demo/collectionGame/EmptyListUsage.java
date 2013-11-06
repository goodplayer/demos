package demo.collectionGame;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sunhao
 * Date: 13-10-14
 * Time: 上午11:15
 */
public class EmptyListUsage {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = Collections.emptyList();

        Set<String> set1 = new HashSet<String>(list1);
        Set<String> set2 = new HashSet<String>(list2);

        System.out.println(set1.size());
        System.out.println(set2.size());
    }
}
