package com.mini.spring.beans.factory;

import com.mini.spring.beans.factory.config.BeanDefinition;
import com.mini.spring.beans.BeanException;

/**
 * @author cczywyc
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeanException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
