package com.zhaowq.designpatten.chain;

/**
 * @author zhaowq
 * @date 2018/4/10
 */
public class Request {
    /**
     * 在Request中只保持了一个reqStr字段记录对Request的操作
     * 为了方便模拟，没有将reqStr设置为private
     */
    String reqStr;
}
