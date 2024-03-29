package com.zhaowq.designpatten.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaowq
 * @date 2018/4/9
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    /**
     * 调用链上的过滤器时，记录过滤器的位置用
     */
    private int index = 0;

    public FilterChain addFilter(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Request req, Response resp) {
        if (index == filters.size()) {
            return;
        }
        //得到当前过滤器
        Filter f = filters.get(index);
        index++;

        f.doFilter(req, resp, this);
    }
}
