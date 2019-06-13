package com.zhaowq.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取resources目录中文件的若干种方法
 *
 * @author zhaowq
 * @date 2016/8/15
 */
public class ReadResources {
    public static void main(String[] args) {
        //获取classpath路径
        System.out.println("classpath路径： " + ReadResources.class.getClassLoader().getResource("").getPath());

        //获取当前类的加载路径
        System.out.println("当前类加载路径： " + ReadResources.class.getResource("").getPath());

        // 方法一：从classpath路径出发读取
        readTxt(ReadResources.class.getClassLoader().getResource("a.txt").getPath());
        // 方法二：从类加载路径出发，相当于使用绝对路径
        readTxt(ReadResources.class.getResource("/a.txt").getPath());
        // 方法三：从类加载路径出发，相当于使用相对路径
        readTxt(ReadResources.class.getResource("../../../a.txt").getPath());
    }

    private static void readTxt(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
