package mvc.controller;

import java.util.*;

/**
 * @author
 * @description:
 * @create 2022/4/30-15:58
 */
public class work {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("bb");
        list.add("cc");
        list.add("asdasda");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }
}
