package com.zhaowq.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaowq
 * @date 2018/3/31
 */
public class SubListTest {
    public static void main(String[] args) {
        List<String> sourceList = new ArrayList<String>() {{
            add("H");
            add("O");
            add("L");
            add("L");
            add("I");
            add("S");
        }};

        List subList = sourceList.subList(2, 5);

        System.out.println("sourceList ： " + sourceList);
        System.out.println("sourceList.subList(2, 5) 得到List ：");
        System.out.println("subList ： " + subList);

        sourceList.add("666");

        System.out.println("sourceList.add(666) 得到List ：");
        System.out.println("sourceList ： " + sourceList);
        System.out.println("subList ： " + subList);

    }
}
