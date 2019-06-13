package com.zhaowq.mycomcat;

/**
 * @author zhaowq
 * @date 2018/10/11
 */
public abstract class MyServlet {
    public abstract void doGet(MyRequest myRequest, MyResponse myResponse);

    public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    public void service(MyRequest myRequest, MyResponse myResponse) {
        if ("POST".equalsIgnoreCase(myRequest.getMethod())) {
            doPost(myRequest, myResponse);
        } else if ("GET".equalsIgnoreCase(myRequest.getMethod())) {
            doGet(myRequest, myResponse);
        }
    }
}