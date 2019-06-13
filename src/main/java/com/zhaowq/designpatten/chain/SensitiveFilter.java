package com.zhaowq.designpatten.chain;

/**
 * @author zhaowq
 * @date 2018/4/10
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request req, Response resp, FilterChain chain) {
        // 过滤req.reqStr中的敏感词
        req.reqStr = req.reqStr.replace("敏感", "").replace("被就业", "就业");
        req.reqStr += "===SensitiveFilter";
        chain.doFilter(req, resp);
        resp.respStr += "===SensitiveFilter";
    }
}
