package com.mini.spring.beans;

import com.mini.spring.core.Resource;
import org.dom4j.Element;

import java.util.List;

/**
 * @author cczywyc
 */
public class XmlBeanDefinitionReader {
    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);

            // handle properties
            List<Element> propertyElements = element.elements("property");
            PropertyValues propertyValues = new PropertyValues();
            for (Element e : propertyElements) {
                String type = e.attributeValue("type");
                String name = e.attributeValue("name");
                String value = e.attributeValue("value");
                propertyValues.addPropertyValue(new PropertyValue(type, name, value));
            }
            beanDefinition.setPropertyValues(propertyValues);

            // get constructor
            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues argumentValues = new ArgumentValues();
            for (Element e : constructorElements) {
                String type = e.attributeValue("type");
                String name = e.attributeValue("name");
                String value = e.attributeValue("value");
                argumentValues.addArgumentValue(new ArgumentValue(value, type, name));
            }
            beanDefinition.setConstructorArgumentValues(argumentValues);

            this.simpleBeanFactory.registerBeanDefinition(beanId, beanDefinition);
        }
    }
}
