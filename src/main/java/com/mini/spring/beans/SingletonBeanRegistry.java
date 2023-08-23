package com.mini.spring.beans;

/**
 * singleton bean interface
 *
 * @author cczywyc
 */
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);
    Object getSingleton(String beanName);
    boolean containsSingleton(String beanName);
    String[] getSingletonNames();
}
