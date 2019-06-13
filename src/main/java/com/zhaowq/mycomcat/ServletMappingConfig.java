package com.zhaowq.mycomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaowq
 * @date 2018/10/11
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "HelloWorldServlet"));
    }
}
