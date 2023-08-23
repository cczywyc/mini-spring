package com.mini.spring.beans;

/**
 * @author cczywyc
 */
public interface BeanFactory {
    Object getBean(String beanName) throws NoSuchBeanDefinitionException, BeansException;
    Boolean containsBean(String name);
    void registerBean(String beanName, Object obj);
    boolean isSingleton(String name);
    boolean isPrototype(String name);
    Class<?> getType(String name);

}
