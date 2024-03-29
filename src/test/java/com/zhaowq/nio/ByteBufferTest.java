package com.zhaowq.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author zhaowq
 * @date 2019/6/19
 */
public class ByteBufferTest {
    @Test
    public void test() {
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->" + byteBuffer.limit());
        System.out.println("初始时-->position--->" + byteBuffer.position());
        System.out.println("初始时-->capacity--->" + byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        // 添加一些数据到缓冲区中
        String s = "Java3y";
        byteBuffer.put(s.getBytes());

        // 看一下初始时4个核心变量的值
        System.out.println("put完之后-->limit--->" + byteBuffer.limit());
        System.out.println("put完之后-->position--->" + byteBuffer.position());
        System.out.println("put完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        //切换成读模式
        byteBuffer.flip();
        System.out.println("flip完之后-->limit--->" + byteBuffer.limit());
        System.out.println("flip完之后-->position--->" + byteBuffer.position());
        System.out.println("flip完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("flip完之后-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        // 创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[byteBuffer.limit()];
        // 将读取的数据装进我们的字节数组中
        byteBuffer.get(bytes);
        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("get完之后-->limit--->" + byteBuffer.limit());
        System.out.println("get完之后-->position--->" + byteBuffer.position());
        System.out.println("get完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("get完之后-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        byteBuffer.clear();
        System.out.println("clear完之后-->limit--->" + byteBuffer.limit());
        System.out.println("clear完之后-->position--->" + byteBuffer.position());
        System.out.println("clear完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("clear完之后-->mark--->" + byteBuffer.mark());
    }
}
