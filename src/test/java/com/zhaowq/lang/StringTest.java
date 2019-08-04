package com.zhaowq.lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaowq
 * @date 2015/11/13
 */
public class StringTest {

    @Test
    public void test() {
        String[] split = "a,b,c,".split(",");
        System.out.println(split.length);
    }

    @Test
    public void test2() {
        System.out.println(conversion(";545;"));
    }

    private static String conversion(String seqId) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] seqIds = seqId.split(";");
        System.out.println(seqIds.length);
        String[] ids = Arrays.copyOfRange(seqIds, 1, seqIds.length);
        for (String id : ids) {
            stringBuilder.append(id).append(" a");
        }
        return stringBuilder.toString().trim();
    }

    @Test
    public void test3(){
        String s1 = "Hollis";
        String s2 = new String("Hollis");
        String s3 = new String("Hollis").intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
