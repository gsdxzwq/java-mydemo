package com.zhaowq.toby.config;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhaowq
 * @date 2018/3/30
 */
public class ReferenceBean<T> extends ReferenceConfig<T> implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}