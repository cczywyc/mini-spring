package com.mini.spring.context;

import com.mini.spring.beans.BeanException;
import com.mini.spring.beans.factory.BeanFactory;
import com.mini.spring.beans.factory.SimpleBeanFactory;
import com.mini.spring.beans.factory.config.BeanDefinition;
import com.mini.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.mini.spring.core.ClassPathXmlResource;
import com.mini.spring.core.Resource;

/**
 * class path xmp application context, read xml and reject beans
 *
 * @author cczywyc
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeanException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
