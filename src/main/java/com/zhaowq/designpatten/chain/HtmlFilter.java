package com.zhaowq.designpatten.chain;

/**
 * @author zhaowq
 * @date 2018/4/10
 */
public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request req, Response resp, FilterChain chain) {
        //过滤req.reqStr中的HTML标记
        req.reqStr = req.reqStr.replace("<", "&lt;").replace(">", "&gt;");
        req.reqStr += "---HtmlFilter()---";
        chain.doFilter(req, resp);
        resp.respStr += "---HtmlFilter()---";
    }
}
