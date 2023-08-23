package com.mini.spring.beans;

/**
 * @author cczywyc
 */
public interface BeanFactory {
    Object getBean(String beanName) throws NoSuchBeanDefinitionException;
    Boolean containsBean(String name);
    void registerBean(String beanName, Object obj);
}
