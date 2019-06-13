package com.zhaowq.toby.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author zhaowq
 * @date 2018/3/30
 */
public class TobyRPCNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference", new TobyRPCBeanDefinitionParser());
    }
}