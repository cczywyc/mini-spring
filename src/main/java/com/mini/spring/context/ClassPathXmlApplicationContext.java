package com.mini.spring.context;

import com.mini.spring.beans.NoSuchBeanDefinitionException;
import com.mini.spring.beans.BeanFactory;
import com.mini.spring.beans.SimpleBeanFactory;
import com.mini.spring.beans.BeanDefinition;
import com.mini.spring.beans.XmlBeanDefinitionReader;
import com.mini.spring.core.ClassPathXmlResource;
import com.mini.spring.core.Resource;

/**
 * class path xmp application context, read xml and reject beans
 *
 * @author cczywyc
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    SimpleBeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = bf;
    }

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        this.beanFactory.registerBean(beanName, obj);
    }
}
