package com.zhaowq.lang;

/**
 * 类加载初始化顺序验证
 *
 * @author zhaowq
 * @date 2017/2/16
 */
public class LoadingTest {
    public static LoadingTest loadingTest = new LoadingTest();
    public static int value1;
    public static int value2 = 0;

    public LoadingTest() {
        value1 = 10;
        value2 = value1;
        System.out.println("before:" + value1);
        System.out.println("before:" + value2);
    }

    public static void main(String[] args) {
        System.out.println(value1);
        System.out.println(value2);
    }
}
