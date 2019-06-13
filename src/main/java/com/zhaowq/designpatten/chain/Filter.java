package com.zhaowq.designpatten.chain;

/**
 * @author zhaowq
 * @date 2018/4/9
 */
public interface Filter {
    void doFilter(Request req, Response resp, FilterChain chain);
}
