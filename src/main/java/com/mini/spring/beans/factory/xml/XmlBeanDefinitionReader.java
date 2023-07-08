package com.mini.spring.beans.factory.xml;

import com.mini.spring.beans.factory.BeanFactory;
import com.mini.spring.beans.factory.config.BeanDefinition;
import com.mini.spring.core.Resource;
import org.dom4j.Element;

/**
 * @author cczywyc
 */
public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
